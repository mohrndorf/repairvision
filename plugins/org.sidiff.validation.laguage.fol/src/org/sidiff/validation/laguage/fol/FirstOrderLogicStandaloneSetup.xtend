/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class FirstOrderLogicStandaloneSetup extends FirstOrderLogicStandaloneSetupGenerated {

	def static void doSetup() {
		new FirstOrderLogicStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}