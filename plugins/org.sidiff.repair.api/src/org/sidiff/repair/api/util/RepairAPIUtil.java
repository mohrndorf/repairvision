package org.sidiff.repair.api.util;

import java.util.List;

import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.repair.api.IRepairPlan;

public class RepairAPIUtil {

	public static int countOfNodeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfNodeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (((Node) graphElement).getAction().getType().equals(Action.Type.CREATE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfNodeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (((Node) graphElement).getAction().getType().equals(Action.Type.DELETE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (((Edge) graphElement).getAction().getType().equals(Action.Type.CREATE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (((Edge) graphElement).getAction().getType().equals(Action.Type.DELETE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countUnboundParameters(IRepairPlan repair) {
		int count = 0;
		
		for (Parameter parameter : repair.getParameters()) {
			if (repair.getParameterValue(parameter) == null) {
				++count;
			}
		}
		
		return count;
	}
}
