/*
 * generated by Xtext 2.12.0
 */
package org.sidiff.validation.laguage.fol.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FirstOrderLogicAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/sidiff/validation/laguage/fol/parser/antlr/internal/InternalFirstOrderLogic.tokens");
	}
}