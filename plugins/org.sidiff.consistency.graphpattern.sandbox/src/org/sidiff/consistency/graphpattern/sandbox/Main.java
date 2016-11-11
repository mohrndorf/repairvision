package org.sidiff.consistency.graphpattern.sandbox;

import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.algorithms.IMatchingEngine;
import org.sidiff.consistency.graphpattern.sandbox.algorithms.KrissinelAlgorithm;
import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.io.ReadGraphs;
import org.sidiff.consistency.graphpattern.sandbox.io.WriteVisualization;

public class Main {
	
	private static String base = "D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\";
	
	private static String name = "M003";

	public static void main(String[] args) {
		
		// Load example:
		Example example = ReadGraphs.readExample(base + name + ".graph");
		
		// Calculate matching:
		long start = System.currentTimeMillis();
		
		IMatchingEngine engine = new KrissinelAlgorithm();
		List<Match> matchings = engine.getMatches(example);
		
		System.out.println("Matching Time: " + ((double) (System.currentTimeMillis() - start)) / 1000 + "s");
		System.out.println("Matches Found: " + matchings.size());
		
		// Visualize:
		String viz = WriteVisualization.writeVisualization(name, example, Match.getMaxMatch(matchings));
		String path = base + name + ".graph.dot";
		WriteVisualization.saveVisualization(viz, path);

		System.out.println("Visualization: " + path);

	}

}
