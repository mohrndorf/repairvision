/**
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.validation.laguage.fol.firstOrderLogic.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage
 * @generated
 */
public class FirstOrderLogicAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FirstOrderLogicPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FirstOrderLogicAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FirstOrderLogicPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FirstOrderLogicSwitch<Adapter> modelSwitch =
    new FirstOrderLogicSwitch<Adapter>()
    {
      @Override
      public Adapter caseConstraintLibrary(ConstraintLibrary object)
      {
        return createConstraintLibraryAdapter();
      }
      @Override
      public Adapter caseDomain(Domain object)
      {
        return createDomainAdapter();
      }
      @Override
      public Adapter caseConstraint(Constraint object)
      {
        return createConstraintAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseFormula(Formula object)
      {
        return createFormulaAdapter();
      }
      @Override
      public Adapter caseUnaryFormula(UnaryFormula object)
      {
        return createUnaryFormulaAdapter();
      }
      @Override
      public Adapter caseEquals(Equals object)
      {
        return createEqualsAdapter();
      }
      @Override
      public Adapter caseGreater(Greater object)
      {
        return createGreaterAdapter();
      }
      @Override
      public Adapter caseGreaterEqual(GreaterEqual object)
      {
        return createGreaterEqualAdapter();
      }
      @Override
      public Adapter caseSmaller(Smaller object)
      {
        return createSmallerAdapter();
      }
      @Override
      public Adapter caseSmallerEqual(SmallerEqual object)
      {
        return createSmallerEqualAdapter();
      }
      @Override
      public Adapter caseIsEmpty(IsEmpty object)
      {
        return createIsEmptyAdapter();
      }
      @Override
      public Adapter caseIsInstanceOf(IsInstanceOf object)
      {
        return createIsInstanceOfAdapter();
      }
      @Override
      public Adapter caseIsValueLiteralOf(IsValueLiteralOf object)
      {
        return createIsValueLiteralOfAdapter();
      }
      @Override
      public Adapter caseQuantifier(Quantifier object)
      {
        return createQuantifierAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseGet(Get object)
      {
        return createGetAdapter();
      }
      @Override
      public Adapter caseGetContainer(GetContainer object)
      {
        return createGetContainerAdapter();
      }
      @Override
      public Adapter caseGetContainments(GetContainments object)
      {
        return createGetContainmentsAdapter();
      }
      @Override
      public Adapter caseGetClosure(GetClosure object)
      {
        return createGetClosureAdapter();
      }
      @Override
      public Adapter caseSize(Size object)
      {
        return createSizeAdapter();
      }
      @Override
      public Adapter caseIndexOf(IndexOf object)
      {
        return createIndexOfAdapter();
      }
      @Override
      public Adapter caseConcatenate(Concatenate object)
      {
        return createConcatenateAdapter();
      }
      @Override
      public Adapter caseCapitalize(Capitalize object)
      {
        return createCapitalizeAdapter();
      }
      @Override
      public Adapter caseClassifier(Classifier object)
      {
        return createClassifierAdapter();
      }
      @Override
      public Adapter caseClassifierConstant(ClassifierConstant object)
      {
        return createClassifierConstantAdapter();
      }
      @Override
      public Adapter caseAsClassifier(AsClassifier object)
      {
        return createAsClassifierAdapter();
      }
      @Override
      public Adapter caseDataType(DataType object)
      {
        return createDataTypeAdapter();
      }
      @Override
      public Adapter caseDataTypeConstant(DataTypeConstant object)
      {
        return createDataTypeConstantAdapter();
      }
      @Override
      public Adapter caseAsDataType(AsDataType object)
      {
        return createAsDataTypeAdapter();
      }
      @Override
      public Adapter caseIntConstant(IntConstant object)
      {
        return createIntConstantAdapter();
      }
      @Override
      public Adapter caseStringConstant(StringConstant object)
      {
        return createStringConstantAdapter();
      }
      @Override
      public Adapter caseBoolConstant(BoolConstant object)
      {
        return createBoolConstantAdapter();
      }
      @Override
      public Adapter caseIff(Iff object)
      {
        return createIffAdapter();
      }
      @Override
      public Adapter caseIf(If object)
      {
        return createIfAdapter();
      }
      @Override
      public Adapter caseXor(Xor object)
      {
        return createXorAdapter();
      }
      @Override
      public Adapter caseOr(Or object)
      {
        return createOrAdapter();
      }
      @Override
      public Adapter caseAnd(And object)
      {
        return createAndAdapter();
      }
      @Override
      public Adapter caseNot(Not object)
      {
        return createNotAdapter();
      }
      @Override
      public Adapter caseForAll(ForAll object)
      {
        return createForAllAdapter();
      }
      @Override
      public Adapter caseExists(Exists object)
      {
        return createExistsAdapter();
      }
      @Override
      public Adapter caseVariableRef(VariableRef object)
      {
        return createVariableRefAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary <em>Constraint Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary
   * @generated
   */
  public Adapter createConstraintLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Domain
   * @generated
   */
  public Adapter createDomainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint
   * @generated
   */
  public Adapter createConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Formula
   * @generated
   */
  public Adapter createFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.UnaryFormula <em>Unary Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.UnaryFormula
   * @generated
   */
  public Adapter createUnaryFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Equals <em>Equals</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Equals
   * @generated
   */
  public Adapter createEqualsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Greater <em>Greater</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Greater
   * @generated
   */
  public Adapter createGreaterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GreaterEqual <em>Greater Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.GreaterEqual
   * @generated
   */
  public Adapter createGreaterEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Smaller <em>Smaller</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Smaller
   * @generated
   */
  public Adapter createSmallerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.SmallerEqual <em>Smaller Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.SmallerEqual
   * @generated
   */
  public Adapter createSmallerEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.IsEmpty <em>Is Empty</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.IsEmpty
   * @generated
   */
  public Adapter createIsEmptyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.IsInstanceOf <em>Is Instance Of</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.IsInstanceOf
   * @generated
   */
  public Adapter createIsInstanceOfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.IsValueLiteralOf <em>Is Value Literal Of</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.IsValueLiteralOf
   * @generated
   */
  public Adapter createIsValueLiteralOfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier
   * @generated
   */
  public Adapter createQuantifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Get <em>Get</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Get
   * @generated
   */
  public Adapter createGetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer <em>Get Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer
   * @generated
   */
  public Adapter createGetContainerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainments <em>Get Containments</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainments
   * @generated
   */
  public Adapter createGetContainmentsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure <em>Get Closure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure
   * @generated
   */
  public Adapter createGetClosureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Size <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Size
   * @generated
   */
  public Adapter createSizeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf <em>Index Of</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf
   * @generated
   */
  public Adapter createIndexOfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate <em>Concatenate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate
   * @generated
   */
  public Adapter createConcatenateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize <em>Capitalize</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize
   * @generated
   */
  public Adapter createCapitalizeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Classifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Classifier
   * @generated
   */
  public Adapter createClassifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.ClassifierConstant <em>Classifier Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.ClassifierConstant
   * @generated
   */
  public Adapter createClassifierConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.AsClassifier <em>As Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.AsClassifier
   * @generated
   */
  public Adapter createAsClassifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.DataType
   * @generated
   */
  public Adapter createDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.DataTypeConstant <em>Data Type Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.DataTypeConstant
   * @generated
   */
  public Adapter createDataTypeConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.AsDataType <em>As Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.AsDataType
   * @generated
   */
  public Adapter createAsDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant <em>Int Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
   * @generated
   */
  public Adapter createIntConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant <em>String Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
   * @generated
   */
  public Adapter createStringConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant <em>Bool Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
   * @generated
   */
  public Adapter createBoolConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Iff <em>Iff</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Iff
   * @generated
   */
  public Adapter createIffAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.If
   * @generated
   */
  public Adapter createIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Xor <em>Xor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Xor
   * @generated
   */
  public Adapter createXorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Or
   * @generated
   */
  public Adapter createOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.And
   * @generated
   */
  public Adapter createAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Not <em>Not</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Not
   * @generated
   */
  public Adapter createNotAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll <em>For All</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll
   * @generated
   */
  public Adapter createForAllAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Exists <em>Exists</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.Exists
   * @generated
   */
  public Adapter createExistsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef
   * @generated
   */
  public Adapter createVariableRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //FirstOrderLogicAdapterFactory
