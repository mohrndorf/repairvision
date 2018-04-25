package org.sidiff.graphpattern.profile.constraints;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.constraints.ConstraintGraphPatternProfile.STEREOTYPE;

public class ConstraintGraphPatternVisualization implements IGraphPatternVisualization {
	
	protected int[] BLUE_FOREGROUND = {0, 0, 255};
	
	protected int[] BLUE_BACKGROUND = {221, 221, 255};
	
	@Override
	public int[] getNodeBackgroundColor(NodePattern node, Gradient gradient) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);

			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case not:
				return BLUE_BACKGROUND;
			}
		}
		
		return new int[] {255, 255, 255};
	}

	@Override
	public int[] getNodeFrameColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {	
			case not:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getNodeLabelColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case not:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getEdgeLineColor(EdgePattern edge) {
		
		if (!edge.getStereotypes().isEmpty()) {
			Stereotype stereotype = edge.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case not:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getEdgeLabelColor(EdgePattern edge) {
		
		if (!edge.getStereotypes().isEmpty()) {
			Stereotype stereotype = edge.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case not:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getAttributeLabelColor(AttributePattern attribute) {
		
		if (!attribute.getStereotypes().isEmpty()) {
			Stereotype stereotype = attribute.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case not:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}
}
