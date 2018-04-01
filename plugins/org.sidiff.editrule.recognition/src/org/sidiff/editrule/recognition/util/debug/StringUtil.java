package org.sidiff.editrule.recognition.util.debug;

import java.util.List;

import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class StringUtil {
	
	public static String printSelections(List<NodePattern> nodes) {
		StringBuffer print = new StringBuffer();
		
		for (NodePattern node : nodes) {
			print.append("Node: " + node.getName());
			print.append(", Type: " + node.getType().getName() + ":\n");
			print.append(printSelection(node, "  "));
			print.append("\n");
		}
		
		return print.toString();
	}
	
	public static String printSelection(NodePattern node) {
		return printSelection(node, "");
	}

	public static String printSelection(NodePattern node, String indent) {
		StringBuffer selectionPrint = new StringBuffer();
		Domain.get(node).iterator()
		.forEachRemaining(selection -> {selectionPrint.append(indent + removeBundleNames(selection) + "\n");});
		return selectionPrint.toString();
	}
	
	public static String removeBundleNames(Object obj) {
		String name = obj.toString();
		name = name.replaceFirst("org\\.sidiff\\.consistency\\.graphpattern\\.impl\\.", "");
		name = name.replaceFirst("org\\.eclipse\\.uml2\\.uml\\.internal\\.impl\\.", "");
		name = name.replaceFirst("org\\.sidiff\\.difference\\.symmetric\\.impl\\.", "");
		return name;
	}
}
