package org.sidiff.graphpattern.attributes;

import java.io.StringWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class JavaSciptParser {

	private transient static Reference<ScriptEngine> engine;

	protected static ScriptEngine getEngine() {
		synchronized (JavaSciptParser.class) {
			if ((engine == null) || (engine.get() == null)) {
				ScriptEngine weakSingleton = createJavaScriptEngine();
				engine = new WeakReference<ScriptEngine>(weakSingleton);
			}
			return engine.get();
		}
	}
	
	protected static ScriptEngine createJavaScriptEngine() {
		return new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	/**
	 * @param value
	 *            An script expression.
	 * @return The constant as primitive data type or <code>null</code>.
	 */
	public static Object getConstant(String value) {
		
		// Parse string:
		String originalValue = value;
		
		if (isString(originalValue)) {
			value = value.substring(1, value.length() - 1);
		}
		
		// Parse integer:
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
		}
		
		// Parse floating point:
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
		}
		
		// Parse boolean:
		try {
			if (value.equalsIgnoreCase("true")) {
				return true;
			}
			if (value.equalsIgnoreCase("false")) {
				return false;
			}
		} catch (Exception e) {
		}
		
		// Return string?
		if (isString(originalValue)) {
			return value;
		} else {
			return null;
		}
	}
	
	public static List<String> getVariables(String value) {
		
		// NOTE: Intercept simple cases just for performance optimization.
		
		// no content:
		if (value.isEmpty()) {
			return Collections.emptyList();
		}
		
		// one variable:
		if (isVariable(value)) {
			return Collections.singletonList(value);
		}
		
		// one string:
		if (isString(value)) {
			return Collections.emptyList();
		}
		
		// constant value:
		if (isConstant(value)) {
			return Collections.emptyList();
		}
		
		// java script expression:
		try {
			value = value.replace("\"", "'");
			
			String script = 
					"load(\"nashorn:parser.js\");\r\n" + 
							"var ast = parse(\"" + value + "\");" + 
							"print(JSON.stringify(ast));";
			
			ScriptEngine engine= getEngine();
			StringWriter output = new StringWriter();
			
			ScriptContext scriptContext = new SimpleScriptContext();
			scriptContext.setWriter(output);
			
			engine.eval(script, scriptContext);
			
			String ast = output.toString();
			String attributeASTPattern = "(.*?)(\\{\"type\":\"Identifier\",\"name\":\")(.*?)(\"\\})(.*?)";
			
			Pattern compiledAttributeASTPattern = Pattern.compile(attributeASTPattern);
			Matcher matcher = compiledAttributeASTPattern.matcher(ast);
			
			List<String> variables = new ArrayList<>();
			
			while(matcher.find()) {
				String variable = matcher.group(3);
				
				if (!variable.isEmpty()) {
					variables.add(variable);
				}
			}
			
			return variables;
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public static boolean isVariable(String value) {
		return value.matches("^([a-zA-Z\\d_$]*)$");
	}
	
	public static boolean isConstant(String value) {
		return getConstant(value) != null;
	}
	
	public static boolean isString(String value) {
		return value.startsWith("\"") && value.endsWith("\"") && !value.substring(1, value.length() - 1).contains("\"");
	}
}