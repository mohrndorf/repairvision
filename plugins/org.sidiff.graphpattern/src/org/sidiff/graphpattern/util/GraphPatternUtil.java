package org.sidiff.graphpattern.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

public class GraphPatternUtil {

	/**
	 * @param nodesA
	 *            A set of nodes.
	 * @param nodesB
	 *            Another set of nodes.
	 * @return <code>true</code> if there is at least one type preserving mapping
	 *         between the node sets.
	 */
	public static boolean isTypeEqual(List<NodePattern> nodesA, List<NodePattern> nodesB) {
		if (nodesA.size() == nodesB.size()) {
			Set<NodePattern> remainingB = new HashSet<>(nodesB);
			
			for (NodePattern nodePatternA : nodesA) {
				NodePattern match = null;
				
				for (NodePattern nodePatternB : remainingB) {
					if (nodePatternA.getType().equals(nodePatternB.getType())) {
						match = nodePatternB;
						break;
					}
				}
				
				if (match != null) {
					remainingB.remove(match);
				} else {
					return false;
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param nodes
	 *            A set of nodes.
	 * @param stereotypes
	 *            A stereotype configuration
	 * @return The number of nodes in the given set that are annotated with the
	 *         given stereotype.
	 */
	public static int getPatternSize(List<NodePattern> nodes, Stereotype... stereotypes) {
		List<Stereotype> stereotypeList = Arrays.asList(stereotypes);
		int size = 0;
		
		for (NodePattern node : nodes) {
			if (node.getStereotypes().size() == stereotypes.length) {
				if (node.getStereotypes().containsAll(stereotypeList)) {
					++size;
				}
			}
		}
		
		return size;
	}
}
