package org.sidiff.repair.history.editrules.learn.scope;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.editrule.tools.recorder.filters.IAttributeFilter;
import org.sidiff.editrule.tools.recorder.filters.IObjectFilter;
import org.sidiff.editrule.tools.recorder.filters.IReferenceFilter;

public class DifferenceSlicingCriterion {

	// Historical Model //

	protected Set<EObject> historicalFragment;
	
	// Revised Model Extensions //

	protected int historicalFragmentDistance = -1;
	
	// Historical Model Filter //

	protected IObjectFilter historicalObjectFilter = IObjectFilter.DUMMY;
	
	protected IReferenceFilter historicalReferenceFilter = IReferenceFilter.DUMMY;
	
	protected IAttributeFilter historicalAttributeFilter = IAttributeFilter.DUMMY;

	// Revised Model //

	protected Set<EObject> revisedFragment;
	
	// Revised Model Extensions //

	protected int revisedFragmentDistance = -1;

	// Revised Model Filter //
	
	protected IObjectFilter revisedObjectFilter = IObjectFilter.DUMMY;
	
	protected IReferenceFilter revisedReferenceFilter = IReferenceFilter.DUMMY;
	
	protected IAttributeFilter revisedAttributeFilter = IAttributeFilter.DUMMY;

	// Meta-Model Filter //

	protected Set<EClass> classBlacklist;

	protected Set<EReference> referenceBlacklist;

	// Syntactic Extensions //

	/**
	 * Adds the direct corresponding container of all added/removed objects in
	 * the fragment.
	 */
	protected boolean addFirstCorrespondingContainer = true;

	/**
	 * Adds the corresponding container of all added/removed objects in the
	 * fragment until the root element of the model.
	 */
	protected boolean addAllCorrespondingContainers = false;

	/**
	 * Adds the direct added/removed container of all added/removed objects in
	 * the fragment.
	 */
	protected boolean addFirstChangedContainer = true;

	/**
	 * Adds the added/removed container of all added/removed objects in the
	 * fragment until the root element of the model.
	 */
	protected boolean addAllChangedContainers = false;

	public DifferenceSlicingCriterion() {
		this.historicalFragment = new HashSet<>();
		this.revisedFragment = new HashSet<>();

		this.classBlacklist = new HashSet<>();
		this.referenceBlacklist = new HashSet<>();
	}

	public Set<EObject> getHistoricalFragment() {
		return historicalFragment;
	}

	public void setHistoricalFragment(Set<EObject> historicalFragment) {
		this.historicalFragment = historicalFragment;
	}

	public int getHistoricalFragmentDistance() {
		return historicalFragmentDistance;
	}

	public void setHistoricalFragmentDistance(int historicalFragmentDistance) {
		this.historicalFragmentDistance = historicalFragmentDistance;
	}

	public IObjectFilter getHistoricalObjectFilter() {
		return historicalObjectFilter;
	}

	public void setHistoricalObjectFilter(IObjectFilter historicalObjectFilter) {
		this.historicalObjectFilter = historicalObjectFilter;
	}

	public IReferenceFilter getHistoricalReferenceFilter() {
		return historicalReferenceFilter;
	}

	public void setHistoricalReferenceFilter(IReferenceFilter historicalReferenceFilter) {
		this.historicalReferenceFilter = historicalReferenceFilter;
	}

	public IAttributeFilter getHistoricalAttributeFilter() {
		return historicalAttributeFilter;
	}

	public void setHistoricalAttributeFilter(IAttributeFilter historicalAttributeFilter) {
		this.historicalAttributeFilter = historicalAttributeFilter;
	}

	public Set<EObject> getRevisedFragment() {
		return revisedFragment;
	}

	public void setRevisedFragment(Set<EObject> revisedFragment) {
		this.revisedFragment = revisedFragment;
	}

	public int getRevisedFragmentDistance() {
		return revisedFragmentDistance;
	}

	public void setRevisedFragmentDistance(int revisedFragmentDistance) {
		this.revisedFragmentDistance = revisedFragmentDistance;
	}

	public IObjectFilter getRevisedObjectFilter() {
		return revisedObjectFilter;
	}

	public void setRevisedObjectFilter(IObjectFilter revisedObjectFilter) {
		this.revisedObjectFilter = revisedObjectFilter;
	}

	public IReferenceFilter getRevisedReferenceFilter() {
		return revisedReferenceFilter;
	}

	public void setRevisedReferenceFilter(IReferenceFilter revisedReferenceFilter) {
		this.revisedReferenceFilter = revisedReferenceFilter;
	}

	public IAttributeFilter getRevisedAttributeFilter() {
		return revisedAttributeFilter;
	}

	public void setRevisedAttributeFilter(IAttributeFilter revisedAttributeFilter) {
		this.revisedAttributeFilter = revisedAttributeFilter;
	}

	public Set<EClass> getClassBlacklist() {
		return classBlacklist;
	}

	public void setClassBlacklist(Set<EClass> classBlacklist) {
		this.classBlacklist = classBlacklist;
	}

	public Set<EReference> getReferenceBlacklist() {
		return referenceBlacklist;
	}

	public void setReferenceBlacklist(Set<EReference> referenceBlacklist) {
		this.referenceBlacklist = referenceBlacklist;
	}

	public boolean isAddFirstCorrespondingContainer() {
		return addFirstCorrespondingContainer;
	}

	public void setAddFirstCorrespondingContainer(boolean addFirstCorrespondingContainer) {
		this.addFirstCorrespondingContainer = addFirstCorrespondingContainer;
	}

	public boolean isAddAllCorrespondingContainers() {
		return addAllCorrespondingContainers;
	}

	public void setAddAllCorrespondingContainers(boolean addAllCorrespondingContainers) {
		this.addAllCorrespondingContainers = addAllCorrespondingContainers;
	}

	public boolean isAddFirstChangedContainer() {
		return addFirstChangedContainer;
	}

	public void setAddFirstChangedContainer(boolean addFirstChangedContainer) {
		this.addFirstChangedContainer = addFirstChangedContainer;
	}

	public boolean isAddAllChangedContainers() {
		return addAllChangedContainers;
	}

	public void setAddAllChangedContainers(boolean addAllChangedContainers) {
		this.addAllChangedContainers = addAllChangedContainers;
	}
}
