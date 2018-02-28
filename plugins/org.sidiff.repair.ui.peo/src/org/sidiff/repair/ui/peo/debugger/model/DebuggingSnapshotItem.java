package org.sidiff.repair.ui.peo.debugger.model;

import java.util.Collections;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.partialmatcher.IRecognitionEngine;
import org.sidiff.editrule.partialmatcher.IRecognitionEngine.IChangeTag;
import org.sidiff.repair.ui.peo.Activator;

public class DebuggingSnapshotItem implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	// Parent Session //
	private DebuggingSession session;
	
	// Variables //
	private List<ChangesItem> variableSets;
	
	// Edit Rule Graph Pattern //
	private EditRuleGraphItem editRule;
	
	// Matching //
	
	private EditRuleGraphMatchingItem editRuleGraphMatching;
	
	public DebuggingSnapshotItem(DebuggingSession session, IRecognitionEngine recognitionEngine) {
		this.session = session;
		
		for (IChangeTag variableTag : recognitionEngine.getAvailableChangeTags()) {
			variableSets.add(new ChangesItem(this, variableTag, recognitionEngine.getTaggedChanges(variableTag)));
		}
		
		this.editRule = new EditRuleGraphItem(this, recognitionEngine.getEditRuleName(),
				recognitionEngine.getEditRuleNodes(), recognitionEngine.getEditRuleEdges());
		this.editRuleGraphMatching = new EditRuleGraphMatchingItem(this,
				Collections.singletonList(recognitionEngine.getCurrentMatchingPath()));
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Snapshot";
	}

	@Override
	public ITreeItem getParent() {
		return session;
	}
	
	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public ITreeItem[] getChildren() {
		ITreeItem[] children = new ITreeItem[variableSets.size() + 2];
		
		for (int i = 0; i < variableSets.size(); i++) {
			children[i] = variableSets.get(i);
		}
		
		children[variableSets.size()] = editRule;
		children[variableSets.size() + 1] = editRuleGraphMatching;
		
		return children;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (ChangesItem variablesItem : variableSets) {
			string.append(variablesItem.toString() + "\n");
		}
		
		return string.toString();
	}
}
