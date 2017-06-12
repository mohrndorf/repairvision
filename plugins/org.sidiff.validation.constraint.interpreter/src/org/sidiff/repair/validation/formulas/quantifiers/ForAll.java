package org.sidiff.repair.validation.formulas.quantifiers;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Sequence;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;
import org.sidiff.repair.validation.terms.functions.GetClosure;

/**
 * Represents an universal quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class ForAll extends Quantifier {

	// forAll(Type bounded in iteration : formula)
	
	public ForAll(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
	}

	@Override
	public boolean evaluate(IScopeRecorder scope) {
		iteration.evaluate(scope);

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (!formula.evaluate(scope))  {
				result = false;
				return result;
			}
		}
		
		result = true;
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected, IScopeRecorder scope) {
		Alternative alternativ = Alternative.nextAlternative(parent);
		
		// if σ = t
		if (expected) {
			// A: Delete all invalid elements (terms) of the set!
			if (iteration instanceof GetClosure) {
				// Closure:
				Set<Object> invalid = new HashSet<>();
				
				for (Object nextObject : getIterable()) {
					bounded.assign(nextObject);

					if (!formula.evaluate(scope))  {
						invalid.add(nextObject);
					}
				}
				
				((GetClosure) iteration).repair(alternativ, RepairType.DELETE, invalid);
			} else {
				iteration.repair(alternativ, RepairType.DELETE, scope);
			}
			
			// B: Make all invalid elements (terms) of the set valid!
			Sequence sequence = Sequence.nextSequence(alternativ);
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (!formula.evaluate(scope))  {
					formula.repair(sequence, expected, scope);
				}
			}
		}
		
		// if σ = f
		else {
			// A: Add at least one invalid element (term) to the iterated set!
			if (iteration instanceof GetClosure) {
				// Closure:
				Set<Object> invalid = new HashSet<>();
				
				for (Object nextObject : getIterable()) {
					bounded.assign(nextObject);

					if (!formula.evaluate(scope))  {
						invalid.add(nextObject);
					}
				}
				
				((GetClosure) iteration).repair(alternativ, RepairType.CREATE, invalid);
			} else {
				if (isMany()) {
					iteration.repair(alternativ, RepairType.CREATE, scope);
				} else {
					if (isEmpty()) {
						iteration.repair(alternativ, RepairType.CREATE, scope);
					} else {
						iteration.repair(alternativ, RepairType.MODIFY, scope);
					}
				}
			}
			
			// B: Make at least one element (term) of the set invalid!
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate(scope))  {
					formula.repair(alternativ, expected, scope);
				}
			}
		}
	}
}
