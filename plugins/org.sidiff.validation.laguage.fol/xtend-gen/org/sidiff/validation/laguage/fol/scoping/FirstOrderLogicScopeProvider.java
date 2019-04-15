/**
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.scoping;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.scoping.AbstractFirstOrderLogicScopeProvider;
import org.sidiff.validation.laguage.fol.util.ScopeUtil;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class FirstOrderLogicScopeProvider extends AbstractFirstOrderLogicScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      EReference _variable_Type = FirstOrderLogicPackage.eINSTANCE.getVariable_Type();
      boolean _equals = Objects.equal(reference, _variable_Type);
      if (_equals) {
        final Function1<EClassifier, Boolean> _function = (EClassifier it) -> {
          return Boolean.valueOf((it instanceof EClass));
        };
        return Scopes.scopeFor(
          IterableExtensions.<EClassifier>filter(ScopeUtil.getAllTypes(context), _function));
      } else {
        EReference _classifierConstant_Constant = FirstOrderLogicPackage.eINSTANCE.getClassifierConstant_Constant();
        boolean _equals_1 = Objects.equal(reference, _classifierConstant_Constant);
        if (_equals_1) {
          return Scopes.scopeFor(ScopeUtil.getAllTypes(context));
        } else {
          EReference _dataTypeConstant_Constant = FirstOrderLogicPackage.eINSTANCE.getDataTypeConstant_Constant();
          boolean _equals_2 = Objects.equal(reference, _dataTypeConstant_Constant);
          if (_equals_2) {
            return Scopes.scopeFor(ScopeUtil.getAllDataTypes(context));
          } else {
            EReference _get_Name = FirstOrderLogicPackage.eINSTANCE.getGet_Name();
            boolean _equals_3 = Objects.equal(reference, _get_Name);
            if (_equals_3) {
              return Scopes.scopeFor(ScopeUtil.getAllFeatures(context));
            } else {
              EReference _get_Type = FirstOrderLogicPackage.eINSTANCE.getGet_Type();
              boolean _equals_4 = Objects.equal(reference, _get_Type);
              if (_equals_4) {
                return Scopes.scopeFor(ScopeUtil.getAllSubTypes(context));
              } else {
                EReference _getClosure_Feature = FirstOrderLogicPackage.eINSTANCE.getGetClosure_Feature();
                boolean _equals_5 = Objects.equal(reference, _getClosure_Feature);
                if (_equals_5) {
                  return Scopes.scopeFor(ScopeUtil.getAllFeatures(context));
                } else {
                  EReference _indexOf_Feature = FirstOrderLogicPackage.eINSTANCE.getIndexOf_Feature();
                  boolean _equals_6 = Objects.equal(reference, _indexOf_Feature);
                  if (_equals_6) {
                    return Scopes.scopeFor(ScopeUtil.getAllFeatures(context));
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = super.getScope(context, reference);
    }
    return _xblockexpression;
  }
}