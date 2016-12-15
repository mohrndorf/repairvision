/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.generator

import java.util.Collections
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetTerm
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable
import java.util.HashMap

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class FirstOrderLogicGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var names = new HashMap<Object, String>();
		
		var variableCounter = 0
		var pathCounter = 0

		var code = 
			'''
				«FOR variable : resource.allContents.filter(typeof(Variable)).toIterable»
					«compile(variable, variableCounter++, names)»
				«ENDFOR»
				
				«FOR getTerm : resource.allContents.filter(typeof(GetTerm)).toIterable»
					«compile(getTerm, pathCounter++, names)»
				«ENDFOR»
			'''
		
		fsa.generateFile(resource.URI.lastSegment + '.java', code)
		saveAsXMI(resource);
	}
	
	def String compile(Variable variable, int counter, HashMap<Object, String> names) {
		var name = 'v' + counter + '_' variable.name;
		names.put(variable, name)
		
		return '''Variable «name» = new Variable("«variable.name»");'''
	}
	
	def String compile(GetTerm path, int counter, HashMap<Object, String> names) {
		
		// Term t1_m_receiveEvent_covered =
		var name = '''t«counter»_«path.eAllContents.filter(typeof(Get)).map[name.name].join('_')»'''
		var getVariable = 'Term  = ' + name
		names.put(path, name)
		
		//new Get(new Get(m, DOMAIN.getMessage_ReceiveEvent()), DOMAIN.getInteractionFragment_Covered());
		var code = new StringBuffer('new Get(' + path.name.name + ', ' + compile(path.feature.name) + ')')
		compile(path.feature.next, code)
		
		return getVariable + code + ';'
	}
	
	def void compile(Get get, StringBuffer code) {
		
		if (get != null) {
			code.insert(0, 'new Get(')
			code.append(', ' + compile(get.name) + ')')
		
			compile(get.next, code)
		}
	}
	
	def String compile(EStructuralFeature featue) {
		return 'DOMAIN.get' + featue.containerClass.simpleName + '_' + featue.name + '()'
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
	
		/**
	 * Creates a deep copy (i.e. full tree content) of the given object.
	 * 
	 * @param original
	 *            The root object which will be copied.
	 * @return The copy trace: Original -> Copy
	 */
	def static Map<EObject, EObject> deepCopy(EObject original) {

		// Copier = Map: Original -> Copy
		var copier = new Copier();

		// Root:
		copier.copy(original);

		// References:
		copier.copyReferences();

		return copier;
	}
}
