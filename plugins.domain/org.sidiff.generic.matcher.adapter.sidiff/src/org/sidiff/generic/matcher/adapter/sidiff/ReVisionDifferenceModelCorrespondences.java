package org.sidiff.generic.matcher.adapter.sidiff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.correspondences.AbstractCorrespondences;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;

public class ReVisionDifferenceModelCorrespondences extends AbstractCorrespondences {

	public static final String SERVICE_ID = "ReVisionDifferenceCorrespondences";

	/**
	 * The underlying Difference-Model instance of the service.
	 */
	private Difference difference = null;

	public ReVisionDifferenceModelCorrespondences(Difference difference) {
		this.difference = difference;
	}

	public Difference getDifference() {
		return difference;
	}		

	public Correspondence getCorrespondence(EObject element) {
		Correspondence correspondence = difference.getCorrespondenceOfModelA(element);
		
		if (correspondence == null) {
			return difference.getCorrespondenceOfModelB(element);
		}
		
		return null;
	}

	@Override
	public boolean hasCorrespondences(EObject element) {
		return getCorrespondence(element) != null;
	}

	@Override
	public void addCorrespondence(EObject... elements) {
		
		if (elements.length != 2) {
			throw new UnsupportedOperationException("Only pairwise matches allowed: Size " + elements.length);
		}

		addCorrespondence(elements[0], elements[1]);

	}
	@Override
	public void addCorrespondence(List<EObject> elements) {

		if (elements.size() != 2) {
			throw new UnsupportedOperationException("Only pairwise matches allowed: Size " + elements.size());
		}

		addCorrespondence(elements.get(0), elements.get(1));
	}

	public void addCorrespondence(EObject elementA, EObject elementB) {

		// add correspondence to matching
		Correspondence correspondence = DifferenceFactory.eINSTANCE.createCorrespondence();
		correspondence.setMatchedA(elementA);
		correspondence.setMatchedB(elementB);
		difference.addCorrespondence(correspondence);

		// remove elementA and elementB from unmatchedA and unmatchedB, respectively
		difference.getUnmatchedA().remove(elementA);
		difference.getUnmatchedB().remove(elementB);
	}


	public void removeCorrespondences(EObject element) {
		Correspondence correspondence = getCorrespondence(element);

		// update matching
		difference.removeCorrespondence(correspondence);
		difference.getUnmatchedA().add(correspondence.getMatchedA());
		difference.getUnmatchedB().add(correspondence.getMatchedB());
	}

	@Override
	public Collection<EObject> getCorrespondences(EObject element) {
		ArrayList<EObject> correspondences = new ArrayList<EObject>();
		Correspondence correspondence = getCorrespondence(element);
		
		if (correspondence != null) {
			correspondences.add(correspondence.getMatchedA() == element 
					? correspondence.getMatchedB()
					: correspondence.getMatchedA());
		}

		return correspondences;
	}

	public EObject getCorrespondingElement(EObject element) {
		return getCorrespondences(element).iterator().next();
	}
	
	@Override
	public boolean isCorresponding(EObject... elements) {
		
		if (elements.length != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches allowed
		}		

		return isCorresponding(elements[0], elements[1]);
	}
	
	@Override
	public boolean isCorresponding(List<EObject> elements) {
		
		if (elements.size() != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches allowed
		}		

		return isCorresponding(elements.get(0), elements.get(1));
	}

	public boolean isCorresponding(EObject elementA, EObject elementB) {
		// correspondence between elementA and elementB
		return getCorrespondence(elementA) != null && getCorrespondence(elementA).getMatchedB() == elementB;
	}

	@Override
	public Collection<EObject> getElementsWithCorrespondences(Resource model) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		
		if (model == getDifference().getModelA()) {
			for (Correspondence correspondence : getDifference().getCorrespondences()) {
				result.add(correspondence.getMatchedA());
			}
		} else if (model == getDifference().getModelB()) {
			for (Correspondence correspondence : getDifference().getCorrespondences()) {
				result.add(correspondence.getMatchedB());
			}
		}

		return result;
	}

	@Override
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model) {
		ArrayList<EObject> result = new ArrayList<EObject>();

		if (model == getDifference().getModelA()) {
			result.addAll(getDifference().getUnmatchedA());
		} else if (model == getDifference().getModelB()) {
			result.addAll(getDifference().getUnmatchedB());
		}

		return result;
	}

	@Override
	public void removeCorrespondence(EObject... elements) {
		for (EObject element : elements) {
			removeCorrespondences(element);
		}
	}

	@Override
	public void removeCorrespondence(List<EObject> elements) {
		for (EObject element : elements) {
			removeCorrespondences(element);
		}
	}

	@Override
	public void removeFromCorrespondence(EObject element) {
		// as we only support pairwise correspondences, we remove the whole correspondence itself
		removeCorrespondence(element);
	}

	@Override
	public void init(Collection<Resource> models) {

		if (!canHandle(models)) {
			throw new UnsupportedOperationException();
		}	

		Iterator<Resource> it = models.iterator();
		Resource modelA = it.next();
		Resource modelB = it.next();

		initUnmatched(modelA,  modelB);
	}

	public void init(ICorrespondences service, Resource resourceA, Resource resourceB) {
		initUnmatched(resourceA, resourceB);

		// set correspondences (we assume exactly one corresponding element)
		for (EObject matchedA : service.getElementsWithCorrespondences(resourceA)) {
			EObject matchedB = service.getCorrespondences(matchedA).iterator().next();
			addCorrespondence(matchedA, matchedB);
		}
	}

	private void initUnmatched(Resource resourceA, Resource resourceB) {
		
		// add unmatchedA
		for (Iterator<EObject> iterator = resourceA.getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			difference.getUnmatchedA().add(obj);
		}

		// add unmatchedB
		for (Iterator<EObject> iterator = resourceB.getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			difference.getUnmatchedB().add(obj);
		}
	}

	@Override
	public void reset() {
		this.difference = null;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("The ReVision difference implementation of the Correspondence service.");
	}

	@Override
	public boolean canHandle(Collection<Resource> models) {
		if(models.size() > 2) {
			return false;
		}
		return true;
	}

}
