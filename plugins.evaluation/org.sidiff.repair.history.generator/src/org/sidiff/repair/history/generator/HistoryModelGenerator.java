package org.sidiff.repair.history.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.history.revision.uuid.UUIDResource;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.repair.history.generator.repository.IHistoryRepository;
import org.sidiff.repair.history.generator.repository.ModelNamingUtil;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;

public class HistoryModelGenerator {
	
	//----
	
	public boolean PRINT_IDS = false;
	
	//----
	
	public static String PROJECT_NAME_PREFIX = "org.sidiff.ecore.testdata.history";
	
	public static String VERSIONS_FOLDER = "versions";
	
	public static String DIFF_FOLDER = "differences";
	
	public static String HISTORY_FILE_EXTENSION = "history";
	
	//----
	
	protected EvaluationSettings settings;
	
	//----
	
	public void generateHistoryProject(String inputPath, String outputProject, EvaluationSettings settings) {
		this.settings = settings;
		
		try {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(outputProject);
			
			if (!project.exists()) {
				
				// Scan for model files within that folder:
				File modelFolder = new File(inputPath);
				List<File> files = IHistoryRepository.searchModelFiles(modelFolder, settings.getFileFilters());
				
				// Create a history:
				if (!files.isEmpty()) {
					History history = generateHistory(files, settings);
					saveHistory(history, outputProject);
					
					System.out.println(history.toString());
				}
			} else {
				WorkbenchUtil.showError("The project '" + project.getName() + "' already exists!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProjectName(String projectPrefix, String inputPath) {
		File modelFolder = new File(inputPath);
		String name = modelFolder.getName();
		
		if (modelFolder.getName().lastIndexOf(".") != -1) {
			name = modelFolder.getName().toLowerCase().substring(0, modelFolder.getName().lastIndexOf("."));
		}
		
		return projectPrefix + "." + name;
	}
	
	private void saveHistory(History history, String outputProject) throws CoreException, IOException {
		IHistoryRepository repository = settings.getRepository();
		
		// Get the project the history shall be stored in:
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(outputProject);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		
		IFolder versionFolder = project.getFolder(VERSIONS_FOLDER);
		versionFolder.create(false, true, new NullProgressMonitor());
		
		URI platformVersionFolderURI = URI.createPlatformResourceURI(
				project.getName() + "/" + VERSIONS_FOLDER, true);
		
		URI relativeVersionFolderURI = URI.createURI(
				VERSIONS_FOLDER, true);
		
		// Save referenced models:
		for (String uriString : repository.getReferencedModels()) {
			URI resolvedURI = URI.createURI(uriString);
			
			URI subModelCopy = platformVersionFolderURI
					.appendSegment(ModelNamingUtil.getModelName(resolvedURI.lastSegment()))
					.appendSegment(repository.formatModelFileName(resolvedURI));
			
			Resource referencedModel = repository.getResourceSet().getResource(resolvedURI, true);
			referencedModel.setURI(subModelCopy);
			referencedModel.save(Collections.EMPTY_MAP);
		}
		
		// Save versions:
		for (Version version : history.getVersions()) {
			URI platformTargetURI = platformVersionFolderURI.appendSegment(getModelFileName(version));
			version.getModel().setURI(platformTargetURI);
			
			URI relativeTargetURI = relativeVersionFolderURI.appendSegment(getModelFileName(version));
			version.setModelURI(relativeTargetURI.toString());
			
			try {
				version.getModel().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Save history:
		URI historyURI = EMFStorage.pathToUri(project.getLocation().toOSString() 
				+ File.separator + history.getName() + "." + HISTORY_FILE_EXTENSION);

		Resource historyResource = repository.getResourceSet().createResource(historyURI);
		historyResource.getContents().add(history);
		historyResource.save(Collections.EMPTY_MAP);

	}
	
	private String getModelFileName(Version version) {
		int revision = ((History) version.eContainer()).getVersions().indexOf(version) + 1;
		return String.format("%03d", revision) + "_" + settings.getRepository().formatModelFileName(URI.createURI(version.getModelURI()));
	}
	
	private History generateHistory(List<File> files, EvaluationSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(settings.getHistoryName());
		
		// Load history:
		System.out.println("############################## LOAD MODELS ##############################");
		
		// Convert files to URIs:
		List<URI> modelURIs = new ArrayList<>();
		
		for (File modelFile : files) {
			System.out.println(modelFile);
			
			URI modelURI = EMFStorage.fileToUri(modelFile);
			modelURIs.add(modelURI);
		}
		
		// Sort history:
		settings.getRepository().sortHistory(modelURIs);
		
		// Load model data:
		for (int i = 0; i < modelURIs.size(); i++) {
			Resource resource = settings.getRepository().loadModel(modelURIs.get(i));
			Version version = generateVersion(i + 1, resource, settings);

			if (version != null) {
				history.getVersions().add(version);
			}
		}
		
		// Calculate matchings:
		System.out.println("############################## Calcualte Traces ##############################");
		
		for (int i = 0; i < (history.getVersions().size() - 1); i++) {
			int j = i + 1;
			
			Version versionA = history.getVersions().get(i);
			Version versionB = history.getVersions().get(j);
			
			System.out.println("Versions: " + versionA.getName() + " -> " + versionB.getName());
			
			while (versionB.getStatus().equals(ModelStatus.DEFECT) && (j < (history.getVersions().size() - 1))) {
				versionB = history.getVersions().get(++j);
			}
			try {
				if (versionA.getStatus().equals(ModelStatus.DEFECT)
						|| versionB.getStatus().equals(ModelStatus.DEFECT)) {
					continue;
				}

				Matching matching = generateMatching(versionA, versionB, settings);
				generateUUIDs(matching);
			} catch (InvalidModelException e) {
				e.printStackTrace();
			} catch (NoCorrespondencesException e) {
				System.err.println("  No correspondences found: " + versionA.getName() + " -> " + versionB.getName() );
			}
		}
		
		generateIntroducedAndResolved(history, settings);
		
		return history;
	}
	
	private Version generateVersion(int revision, Resource model, EvaluationSettings settings) {
		EcoreUtil.resolveAll(model);
		Collection<Problem> validationErrors = settings.getValidator().validate(model);
		
		ModelStatus modelStatus = validationErrors.isEmpty() ? ModelStatus.VALID : ModelStatus.INVALID;
		
		// Mark defect models
		for (Problem validationError : validationErrors) {
			for (EObject element : validationError.getInvalidElements()) {
				if (element.eIsProxy()) {
					modelStatus = ModelStatus.DEFECT;
				}
			}
		}
		
		Version version = HistoryModelFactory.eINSTANCE.createVersion();
		version.setModel(model);
		version.getProblems().addAll(validationErrors);
		version.setStatus(modelStatus);
		version.setName(String.format("%03d", revision) + " - " + ModelNamingUtil.getModelName(model.getURI().toString()));
		
		return version;
	}
	
	private Matching generateMatching(Version versionA, Version versionB,
			EvaluationSettings settings) throws InvalidModelException, NoCorrespondencesException {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		Matching matching = MatchingFacade.match(
				Arrays.asList(resourceA, resourceB), settings.getDifferenceSettings());

		return matching;
	}
	
	private void generateUUIDs(Matching matching) {
		if (PRINT_IDS) System.out.println("HistoryModelGenerator.generateUUIDs()");
		
		for (Correspondence correspondence : matching.getCorrespondences()) {
			if (!UUIDResource.isDynamic(correspondence.getMatchedA()) && !UUIDResource.isDynamic(correspondence.getMatchedB())) {
				String uuid = EMFUtil.getXmiId(correspondence.getMatchedA());
				assert uuid != null : "UUID for element" + correspondence.getMatchedA() + "not set!";
				EMFUtil.setXmiId(correspondence.getMatchedB(), uuid);
				
				if (PRINT_IDS) System.out.println("Corresponding: " + uuid + " :: " + correspondence.getMatchedB());
			}
		}
	}
	
	private void generateIntroducedAndResolved(History history, EvaluationSettings settings) {
		for (Version versionA : history.getVersions()) {
			if (!history.getSuccessorVersions(versionA).isEmpty()) {
				Version versionB = history.getSuccessorVersions(versionA).get(0);
				
				for (Problem errorB : versionB.getProblems()) {
					boolean hasCorresponding = false;
					
					for (Problem errorA : versionA.getProblems()) {
						if (settings.getValidator().matchValidationError(errorA, errorB)) {
							errorB.setPredecessor(errorA);
							hasCorresponding = true;
							errorB.setIntroducedIn(errorA.getIntroducedIn());
							break;
						}
					}
					if (!hasCorresponding) {
						errorB.setIntroducedIn(versionB);
					}
				}
			}
		}
		List<Version> reverseOrder = new ArrayList<>();
		reverseOrder.addAll(history.getVersions());
		Collections.reverse(reverseOrder);
		
		for (Version versionB : reverseOrder) {
			if (!history.getPredecessorVersions(versionB).isEmpty()) {
				Version versionA = history.getPredecessorVersions(versionB).get(0);
				
				for (Problem errorA : versionA.getProblems()) {
					boolean hasCorresponding = false;
					
					for (Problem errorB : versionB.getProblems()) {
						if (settings.getValidator().matchValidationError(errorA, errorB)) {
							errorA.setSuccessor(errorB);
							hasCorresponding = true;
							errorA.setResolvedIn(errorB.getResolvedIn());
							break;
						}
					}
					if (!hasCorresponding) {
						errorA.setResolvedIn(versionB);
					}
				}
			}
		}
	}
}
