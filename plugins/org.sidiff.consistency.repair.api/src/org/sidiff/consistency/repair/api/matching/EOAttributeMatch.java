package org.sidiff.consistency.repair.api.matching;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;

public class EOAttributeMatch extends EOMatch {

	private Attribute attribute;
	
	private EObject object;
	
	private Object value;

	public EOAttributeMatch(Attribute attribute, EObject object, Object value) {
		super(Type.CREATE);
		this.object = object;
		this.attribute = attribute;
		this.value = value;
		
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public EObject getObject() {
		return object;
	}

	public void setObject(EObject object) {
		this.object = object;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
