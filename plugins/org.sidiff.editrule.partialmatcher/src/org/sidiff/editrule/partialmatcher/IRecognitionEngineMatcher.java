package org.sidiff.editrule.partialmatcher;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public interface IRecognitionEngineMatcher {

	interface IChangeTag {
		String getName();
	}
	
	Iterator<IMatching> recognizeEditRule();
	
	List<NodePattern> getAllChanges();
	
	List<IChangeTag> getAvailableChangeTags();
	
	List<NodePattern> getTaggedChanges(IChangeTag tag);
	
	String getEditRuleName();
	
	List<NodePattern> getEditRuleNodes();
	
	List<EdgePattern> getEditRuleEdges();
	
	List<EdgePattern> getCurrentMatchingPath();
	
	Node getEditRuleTrace(NodePattern node);
	
	Edge getEditRuleTrace(EdgePattern node);
}
