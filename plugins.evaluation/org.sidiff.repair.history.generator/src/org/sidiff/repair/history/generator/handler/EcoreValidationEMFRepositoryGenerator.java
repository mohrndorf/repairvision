package org.sidiff.repair.history.generator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.generator.HistoryModelGenerator;
import org.sidiff.repair.history.generator.repository.IHistoryRepository;
import org.sidiff.repair.history.generator.repository.LocalHistoryRepository;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.history.generator.validation.EMFValidator;

/**
 * Resolves references to other Ecore models in the same plug-in.
 */
public class EcoreValidationEMFRepositoryGenerator extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Job job = new Job("Generate History Model"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ISelection selection = HandlerUtil.getCurrentSelection(event);
				
				if (selection instanceof IStructuredSelection){
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					
					if(structuredSelection.getFirstElement() instanceof IFolder){
						IFolder folder = (IFolder) structuredSelection.getFirstElement();
						
						DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
						
						IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.ecore.repair.history.matcher.EcoreMatcher");
						
//						IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.matcher.signature.name.NamedElementMatcher");
//						IConfigurable configurable = (IConfigurable) matcher;
//						configurable.getConfigurationOptions();
//						configurable.setConfigurationOption("Use Qualified Names", true);
//						configurable.setConfigurationOption("Allow Ambiguous Names", true);
						
//						IMatcher matcher = MatchingUtils.getMatcherByKey("EMFCompareMatcherAdapter");
						
//						IMatcher matcher = MatchingUtils.getMatcherByKey("SimilarityFloodingMatcher");
						
						ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations");
						
						
						differenceSettings.setMatcher(matcher);
						differenceSettings.setTechBuilder(builder);
						
						String inputFolderPath = folder.getLocation().toOSString();
						String inputProjectPath = folder.getProject().getLocation().toOSString();
						String outputProject = HistoryModelGenerator.getProjectName(
								HistoryModelGenerator.PROJECT_NAME_PREFIX, inputFolderPath);
						String[] modelFileFilter = new String[]{"ecore"};
						
						IHistoryRepository repository = new LocalHistoryRepository(inputProjectPath, modelFileFilter);
						EvaluationSettings evaluationSettings = new EvaluationSettings(
								folder.getName(),
								modelFileFilter, 
								repository, 
								differenceSettings, 
								new EMFValidator());
						
						new HistoryModelGenerator().generateHistoryProject(inputFolderPath, outputProject, evaluationSettings);
					}
				}				
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		return null;
	}

}
