/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.generator

import java.util.ArrayList
import java.util.Collections
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil
import org.sidiff.validation.laguage.fol.util.GeneratorUtil
import org.sidiff.common.utilities.ui.util.NameUtil

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class FirstOrderLogicGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val library = resource.contents.head as ConstraintLibrary
		
		if(library === null) {
			return
		}
		
		val className = generateJavaClass(library, fsa)
		generatePluginXml(className, fsa)
		
//		saveAsXMI(resource); // TODO: just for debugging
	}

	private def generateJavaClass(ConstraintLibrary library, IFileSystemAccess2 fsa) {
		val libraryName = library.libraryName
		val className = library.javaClassName
		val packageName = library.javaPackageName

		fsa.generateFile(
			packageName.replace('.', '/') + '/' + className + '.java',
			library.toJavaCode(libraryName, className, packageName))
		
		if (packageName.empty) {
			return className;
		} else {
			return packageName + '.' + className
		}
	}
	
	private def getLibraryName(ConstraintLibrary library) {
		return NameUtil.beautifyName(library.eResource.URI.trimFileExtension.lastSegment)
	}
	
	private def getJavaClassName(ConstraintLibrary library) {
		return library.eResource.URI.trimFileExtension.lastSegment
	}

	private def getJavaPackageName(ConstraintLibrary library) {
		var String packageName = null; // null if src segment not yet found
		
		for (segment : library.eResource.URI.trimSegments(1).segments) { // trim filename first
			if (packageName === null && segment == "src") {
				packageName = '';
			} else if (packageName !== null) {
				if (!packageName.empty) {
					packageName += '.'
				}
				packageName += segment
			}
		}
		
		if (packageName === null) {
			throw new IllegalStateException("FOL file must be contained in the 'src' folder")
		}
		return packageName
	}
	
	private def toJavaCode(ConstraintLibrary library, String libraryName, String className, String packageName) {
		var domains = getDomainPackages(library)

		'''
		«IF (!packageName.empty)»package «packageName»;«ENDIF»
		
		import java.util.ArrayList;
		import java.util.LinkedHashMap;
		import java.util.LinkedHashSet;
		import java.util.List;
		import java.util.Set;
		import java.util.Map;
		
		import org.sidiff.validation.constraint.project.registry.*;
		
		import org.sidiff.validation.constraint.interpreter.*;
		import org.sidiff.validation.constraint.interpreter.formulas.*;
		import org.sidiff.validation.constraint.interpreter.formulas.binary.*;
		import org.sidiff.validation.constraint.interpreter.formulas.predicates.*;
		import org.sidiff.validation.constraint.interpreter.formulas.predicates.collections.*;
		import org.sidiff.validation.constraint.interpreter.formulas.predicates.integers.*;
		import org.sidiff.validation.constraint.interpreter.formulas.predicates.types.*;
		import org.sidiff.validation.constraint.interpreter.formulas.quantifiers.*;
		import org.sidiff.validation.constraint.interpreter.formulas.unary.*;
		import org.sidiff.validation.constraint.interpreter.terms.*;
		import org.sidiff.validation.constraint.interpreter.terms.constants.*;
		import org.sidiff.validation.constraint.interpreter.terms.functions.*;
		import org.sidiff.validation.constraint.interpreter.terms.functions.collections.*;
		import org.sidiff.validation.constraint.interpreter.terms.functions.navigation.*;
		import org.sidiff.validation.constraint.interpreter.terms.functions.strings.*;
		
		public class «className» implements IConstraintLibrary {
			
			private String name = "«libraryName»";
			
			private Set<String> domains;
			
			private Set<String> documentTypes;
			
			private Map<String, IConstraint> constraints;
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public Set<String> getDomains() {
				
				if (domains == null) {
					this.domains = new LinkedHashSet<>();
					 
					«FOR domain : library.domains»
					addDomain("«domain.domain»");
					«ENDFOR»
				}
				
				return domains;
			}
			
			private void addDomain(String domain) {
				domains.add(domain);
			}
			
			@Override
			public Set<String> getDocumentTypes() {
				
				if (documentTypes == null) {
					documentTypes = new LinkedHashSet<>();
					
					«FOR documentType : getDocumentTypes(library)»
					addDocumentType("«documentType»");
					«ENDFOR»
				}
				
				return documentTypes;
			}
			
			private void addDocumentType(String documentType) {
				documentTypes.add(documentType);
			}
			
			public Map<String, IConstraint> getConstraintEntries() {
				
				if (constraints == null) {
					constraints = new LinkedHashMap<>();
				
					«FOR constraint : library.constraints»
					addConstraint(create«constraint.name»Constraint());
					«ENDFOR»
				}
				
				return constraints;
			}
			
			private void addConstraint(IConstraint rule) {
				constraints.put(rule.getName(), rule);
			}
			
			@Override
			public List<IConstraint> getConstraints() {
				return new ArrayList<>(getConstraintEntries().values());
			}
			
			@Override
			public IConstraint getConstraint(String name) {
				return getConstraintEntries().get(name);
			}
			
			«FOR constraint : library.constraints»
			«new FirstOrderLogicGeneratorConstraint(domains).doGenerate(constraint)»
			
			«ENDFOR»
		}
		'''
	}
	
	private def List<String> getDocumentTypes(ConstraintLibrary library) {
		var documentTypes = new LinkedHashSet()
		
		for (context : library.constraints) {
			documentTypes.add(context.variable.type.EPackage.nsURI)
		}
		
		return new ArrayList(documentTypes)
	}
	
	private def Map<String, String> getDomainPackages(ConstraintLibrary library) {

		// Map package nsURI to package name for compilation of meta types
		var workspaceGenModels = EMFMetaAccessUtil.workspaceGenModels
		var domains = newHashMap
		
		for (domain : library.domains) {
			var nsURI = domain.domain.trim
			var packageImport = EMFMetaAccessUtil.getEPackageClass(nsURI, workspaceGenModels)
			
			if (packageImport === null) {
				throw new IllegalArgumentException("Package is not registered: " + domain.domain)
			}
			
			domains.put(domain.domain, packageImport)
		}
		
		return domains
	}
	
	private def generatePluginXml(String extensionClass, IFileSystemAccess2 fsa) {
		GeneratorUtil.createExtensionPoint(fsa.getURI('plugin.xml').segment(1), extensionClass)
		
//		fsa.generateFile(
//			'plugin.xml',
//			FirstOrderLogicOutputConfigurationProvider::PROJECT_ROOT,
//			'''
//			<?xml version="1.0" encoding="UTF-8"?>
//			<?eclipse version="3.4"?>
//			<!-- Generated file, do not modify. -->
//			<plugin>
//			   <extension
//			         point="org.sidiff.validation.constraint.project.registry">
//			      <library
//			            library="«extensionClass»">
//			      </library>
//			   </extension>
//			</plugin>
//			''')
	}
	
	def static void saveAsXMI(Resource resource) {
		var root = resource.contents.get(0)
		var trace = deepCopy(root)
		
		var copyRoot = trace.get(root)
		var resourceSet = new ResourceSetImpl();
		
	 	var xmiResource = resourceSet.createResource(resource.URI.trimFileExtension.appendFileExtension("xmi"));
		xmiResource.contents.add(copyRoot);
		
		xmiResource.save(Collections.emptyMap());
	}
	
	private def static Map<EObject, EObject> deepCopy(EObject original) {

		// Copier = Map: Original -> Copy
		var copier = new Copier();

		// Root:
		copier.copy(original);

		// References:
		copier.copyReferences();

		return copier;
	}
}
