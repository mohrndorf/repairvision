/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.completion.ui.codebricks.CodebricksFactory
 * @model kind="package"
 * @generated
 */
public interface CodebricksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codebricks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/codebricks/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "codebricks";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodebricksPackage eINSTANCE = org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebricksImpl <em>Codebricks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebricks()
	 * @generated
	 */
	int CODEBRICKS = 0;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS__ALTERNATIVES = 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS__TEMPLATE = 1;

	/**
	 * The number of structural features of the '<em>Codebricks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Codebricks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl <em>Codebrick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebrick()
	 * @generated
	 */
	int CODEBRICK = 1;

	/**
	 * The feature id for the '<em><b>Bricks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK__BRICKS = 0;

	/**
	 * The feature id for the '<em><b>Codebricks</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK__CODEBRICKS = 1;

	/**
	 * The feature id for the '<em><b>All Bricks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK__ALL_BRICKS = 2;

	/**
	 * The number of structural features of the '<em>Codebrick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Calculate Rows</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK___CALCULATE_ROWS = 0;

	/**
	 * The operation id for the '<em>Caluclate Columns</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK___CALUCLATE_COLUMNS = 1;

	/**
	 * The number of operations of the '<em>Codebrick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.BrickImpl <em>Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.BrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBrick()
	 * @generated
	 */
	int BRICK = 2;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK__CODEBRICK = 0;

	/**
	 * The number of structural features of the '<em>Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getViewableBrick()
	 * @generated
	 */
	int VIEWABLE_BRICK = 8;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The number of structural features of the '<em>Viewable Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK___GET_TEXT = BRICK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Viewable Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.StyledBrickImpl <em>Styled Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.StyledBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getStyledBrick()
	 * @generated
	 */
	int STYLED_BRICK = 11;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_BRICK__HIGHLIGHT = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Styled Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Styled Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl <em>Template Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTemplatePlaceholderBrick()
	 * @generated
	 */
	int TEMPLATE_PLACEHOLDER_BRICK = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl <em>Object Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getObjectPlaceholderBrick()
	 * @generated
	 */
	int OBJECT_PLACEHOLDER_BRICK = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl <em>Text Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.TextBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTextBrick()
	 * @generated
	 */
	int TEXT_BRICK = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl <em>Indent Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getIndentBrick()
	 * @generated
	 */
	int INDENT_BRICK = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl <em>Line Break Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getLineBreakBrick()
	 * @generated
	 */
	int LINE_BREAK_BRICK = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl <em>Blank Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBlankBrick()
	 * @generated
	 */
	int BLANK_BRICK = 9;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl <em>Composed Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getComposedBrick()
	 * @generated
	 */
	int COMPOSED_BRICK = 10;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl <em>Value Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getValuePlaceholderBrick()
	 * @generated
	 */
	int VALUE_PLACEHOLDER_BRICK = 12;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ObjectDomainPlaceholderBrickImpl <em>Object Domain Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ObjectDomainPlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getObjectDomainPlaceholderBrick()
	 * @generated
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK = 13;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl <em>Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getPlaceholderBrick()
	 * @generated
	 */
	int PLACEHOLDER_BRICK = 14;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__CODEBRICK = STYLED_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__HIGHLIGHT = STYLED_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__MANDATORY = STYLED_BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__PLACEHOLDER = STYLED_BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK_FEATURE_COUNT = STYLED_BRICK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK___GET_TEXT = STYLED_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK_OPERATION_COUNT = STYLED_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK = PLACEHOLDER_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT = PLACEHOLDER_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__MANDATORY = PLACEHOLDER_BRICK__MANDATORY;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER = PLACEHOLDER_BRICK__PLACEHOLDER;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__CHOICES = PLACEHOLDER_BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__CHOICE = PLACEHOLDER_BRICK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Remaining Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES = PLACEHOLDER_BRICK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK__COMPOSED = PLACEHOLDER_BRICK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Template Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK_FEATURE_COUNT = PLACEHOLDER_BRICK_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK___GET_TEXT = PLACEHOLDER_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Template Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PLACEHOLDER_BRICK_OPERATION_COUNT = PLACEHOLDER_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__CODEBRICK = PLACEHOLDER_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__HIGHLIGHT = PLACEHOLDER_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__MANDATORY = PLACEHOLDER_BRICK__MANDATORY;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__PLACEHOLDER = PLACEHOLDER_BRICK__PLACEHOLDER;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__ELEMENT = PLACEHOLDER_BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK__TYPE = PLACEHOLDER_BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK_FEATURE_COUNT = PLACEHOLDER_BRICK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK___GET_TEXT = PLACEHOLDER_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Object Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PLACEHOLDER_BRICK_OPERATION_COUNT = PLACEHOLDER_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__CODEBRICK = STYLED_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__HIGHLIGHT = STYLED_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__TEXT = STYLED_BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selectable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__SELECTABLE = STYLED_BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Text Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK_FEATURE_COUNT = STYLED_BRICK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK___GET_TEXT = STYLED_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Text Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK_OPERATION_COUNT = STYLED_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Bricks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK__BRICKS = BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Indent Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Indent Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The number of structural features of the '<em>Line Break Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Line Break Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The number of structural features of the '<em>Blank Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Blank Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Bricks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_BRICK__BRICKS = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composed Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Composed Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK__CODEBRICK = PLACEHOLDER_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK__HIGHLIGHT = PLACEHOLDER_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK__MANDATORY = PLACEHOLDER_BRICK__MANDATORY;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK__PLACEHOLDER = PLACEHOLDER_BRICK__PLACEHOLDER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK__TYPE = PLACEHOLDER_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK_FEATURE_COUNT = PLACEHOLDER_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK___GET_TEXT = PLACEHOLDER_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Value Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PLACEHOLDER_BRICK_OPERATION_COUNT = PLACEHOLDER_BRICK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__CODEBRICK = OBJECT_PLACEHOLDER_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__HIGHLIGHT = OBJECT_PLACEHOLDER_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__MANDATORY = OBJECT_PLACEHOLDER_BRICK__MANDATORY;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__PLACEHOLDER = OBJECT_PLACEHOLDER_BRICK__PLACEHOLDER;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__ELEMENT = OBJECT_PLACEHOLDER_BRICK__ELEMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__TYPE = OBJECT_PLACEHOLDER_BRICK__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN = OBJECT_PLACEHOLDER_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Domain Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK_FEATURE_COUNT = OBJECT_PLACEHOLDER_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK___GET_TEXT = OBJECT_PLACEHOLDER_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Object Domain Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DOMAIN_PLACEHOLDER_BRICK_OPERATION_COUNT = OBJECT_PLACEHOLDER_BRICK_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ComposedTemplatePlaceholderBrickImpl <em>Composed Template Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ComposedTemplatePlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getComposedTemplatePlaceholderBrick()
	 * @generated
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK = 15;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK = TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT = TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__MANDATORY = TEMPLATE_PLACEHOLDER_BRICK__MANDATORY;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER = TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CHOICES = TEMPLATE_PLACEHOLDER_BRICK__CHOICES;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CHOICE = TEMPLATE_PLACEHOLDER_BRICK__CHOICE;

	/**
	 * The feature id for the '<em><b>Remaining Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES = TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__COMPOSED = TEMPLATE_PLACEHOLDER_BRICK__COMPOSED;

	/**
	 * The feature id for the '<em><b>Container Brick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK = TEMPLATE_PLACEHOLDER_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composed Template Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK_FEATURE_COUNT = TEMPLATE_PLACEHOLDER_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK___GET_TEXT = TEMPLATE_PLACEHOLDER_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Composed Template Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TEMPLATE_PLACEHOLDER_BRICK_OPERATION_COUNT = TEMPLATE_PLACEHOLDER_BRICK_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Codebricks <em>Codebricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Codebricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks
	 * @generated
	 */
	EClass getCodebricks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.completion.ui.codebricks.Codebricks#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternatives</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks#getAlternatives()
	 * @see #getCodebricks()
	 * @generated
	 */
	EReference getCodebricks_Alternatives();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.completion.ui.codebricks.Codebricks#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks#getTemplate()
	 * @see #getCodebricks()
	 * @generated
	 */
	EReference getCodebricks_Template();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Codebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Codebrick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick
	 * @generated
	 */
	EClass getCodebrick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.completion.ui.codebricks.Codebrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getBricks()
	 * @see #getCodebrick()
	 * @generated
	 */
	EReference getCodebrick_Bricks();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.Codebrick#getCodebricks <em>Codebricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Codebricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getCodebricks()
	 * @see #getCodebrick()
	 * @generated
	 */
	EReference getCodebrick_Codebricks();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.Codebrick#getAllBricks <em>All Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getAllBricks()
	 * @see #getCodebrick()
	 * @generated
	 */
	EReference getCodebrick_AllBricks();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.Codebrick#calculateRows() <em>Calculate Rows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Calculate Rows</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#calculateRows()
	 * @generated
	 */
	EOperation getCodebrick__CalculateRows();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.Codebrick#caluclateColumns() <em>Caluclate Columns</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Caluclate Columns</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#caluclateColumns()
	 * @generated
	 */
	EOperation getCodebrick__CaluclateColumns();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Brick <em>Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Brick
	 * @generated
	 */
	EClass getBrick();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.Brick#getCodebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Codebrick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Brick#getCodebrick()
	 * @see #getBrick()
	 * @generated
	 */
	EReference getBrick_Codebrick();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick <em>Template Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick
	 * @generated
	 */
	EClass getTemplatePlaceholderBrick();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choices</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoices()
	 * @see #getTemplatePlaceholderBrick()
	 * @generated
	 */
	EReference getTemplatePlaceholderBrick_Choices();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choice</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoice()
	 * @see #getTemplatePlaceholderBrick()
	 * @generated
	 */
	EReference getTemplatePlaceholderBrick_Choice();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getRemainingChoices <em>Remaining Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Remaining Choices</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getRemainingChoices()
	 * @see #getTemplatePlaceholderBrick()
	 * @generated
	 */
	EReference getTemplatePlaceholderBrick_RemainingChoices();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#isComposed()
	 * @see #getTemplatePlaceholderBrick()
	 * @generated
	 */
	EAttribute getTemplatePlaceholderBrick_Composed();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick <em>Object Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick
	 * @generated
	 */
	EClass getObjectPlaceholderBrick();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getElement()
	 * @see #getObjectPlaceholderBrick()
	 * @generated
	 */
	EReference getObjectPlaceholderBrick_Element();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getType()
	 * @see #getObjectPlaceholderBrick()
	 * @generated
	 */
	EReference getObjectPlaceholderBrick_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.TextBrick <em>Text Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick
	 * @generated
	 */
	EClass getTextBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.TextBrick#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick#getText()
	 * @see #getTextBrick()
	 * @generated
	 */
	EAttribute getTextBrick_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.TextBrick#isSelectable <em>Selectable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selectable</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick#isSelectable()
	 * @see #getTextBrick()
	 * @generated
	 */
	EAttribute getTextBrick_Selectable();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.IndentBrick <em>Indent Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indent Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.IndentBrick
	 * @generated
	 */
	EClass getIndentBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.IndentBrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.IndentBrick#getBricks()
	 * @see #getIndentBrick()
	 * @generated
	 */
	EAttribute getIndentBrick_Bricks();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.LineBreakBrick <em>Line Break Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Break Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.LineBreakBrick
	 * @generated
	 */
	EClass getLineBreakBrick();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewable Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
	 * @generated
	 */
	EClass getViewableBrick();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#getText() <em>Get Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Text</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick#getText()
	 * @generated
	 */
	EOperation getViewableBrick__GetText();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.BlankBrick <em>Blank Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blank Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.BlankBrick
	 * @generated
	 */
	EClass getBlankBrick();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ComposedBrick <em>Composed Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ComposedBrick
	 * @generated
	 */
	EClass getComposedBrick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.completion.ui.codebricks.ComposedBrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ComposedBrick#getBricks()
	 * @see #getComposedBrick()
	 * @generated
	 */
	EReference getComposedBrick_Bricks();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.StyledBrick <em>Styled Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Styled Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.StyledBrick
	 * @generated
	 */
	EClass getStyledBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.StyledBrick#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.sidiff.completion.ui.codebricks.StyledBrick#isHighlight()
	 * @see #getStyledBrick()
	 * @generated
	 */
	EAttribute getStyledBrick_Highlight();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick <em>Value Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick
	 * @generated
	 */
	EClass getValuePlaceholderBrick();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getType()
	 * @see #getValuePlaceholderBrick()
	 * @generated
	 */
	EReference getValuePlaceholderBrick_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick <em>Object Domain Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Domain Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick
	 * @generated
	 */
	EClass getObjectDomainPlaceholderBrick();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick#getDomain()
	 * @see #getObjectDomainPlaceholderBrick()
	 * @generated
	 */
	EReference getObjectDomainPlaceholderBrick_Domain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick <em>Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick
	 * @generated
	 */
	EClass getPlaceholderBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EAttribute getPlaceholderBrick_Mandatory();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getPlaceholder <em>Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Placeholder</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#getPlaceholder()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EAttribute getPlaceholderBrick_Placeholder();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick <em>Composed Template Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Template Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick
	 * @generated
	 */
	EClass getComposedTemplatePlaceholderBrick();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick#getContainerBrick <em>Container Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick#getContainerBrick()
	 * @see #getComposedTemplatePlaceholderBrick()
	 * @generated
	 */
	EReference getComposedTemplatePlaceholderBrick_ContainerBrick();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CodebricksFactory getCodebricksFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebricksImpl <em>Codebricks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebricks()
		 * @generated
		 */
		EClass CODEBRICKS = eINSTANCE.getCodebricks();

		/**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICKS__ALTERNATIVES = eINSTANCE.getCodebricks_Alternatives();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICKS__TEMPLATE = eINSTANCE.getCodebricks_Template();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl <em>Codebrick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebrick()
		 * @generated
		 */
		EClass CODEBRICK = eINSTANCE.getCodebrick();

		/**
		 * The meta object literal for the '<em><b>Bricks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICK__BRICKS = eINSTANCE.getCodebrick_Bricks();

		/**
		 * The meta object literal for the '<em><b>Codebricks</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICK__CODEBRICKS = eINSTANCE.getCodebrick_Codebricks();

		/**
		 * The meta object literal for the '<em><b>All Bricks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICK__ALL_BRICKS = eINSTANCE.getCodebrick_AllBricks();

		/**
		 * The meta object literal for the '<em><b>Calculate Rows</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODEBRICK___CALCULATE_ROWS = eINSTANCE.getCodebrick__CalculateRows();

		/**
		 * The meta object literal for the '<em><b>Caluclate Columns</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODEBRICK___CALUCLATE_COLUMNS = eINSTANCE.getCodebrick__CaluclateColumns();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.BrickImpl <em>Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.BrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBrick()
		 * @generated
		 */
		EClass BRICK = eINSTANCE.getBrick();

		/**
		 * The meta object literal for the '<em><b>Codebrick</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRICK__CODEBRICK = eINSTANCE.getBrick_Codebrick();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl <em>Template Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTemplatePlaceholderBrick()
		 * @generated
		 */
		EClass TEMPLATE_PLACEHOLDER_BRICK = eINSTANCE.getTemplatePlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PLACEHOLDER_BRICK__CHOICES = eINSTANCE.getTemplatePlaceholderBrick_Choices();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PLACEHOLDER_BRICK__CHOICE = eINSTANCE.getTemplatePlaceholderBrick_Choice();

		/**
		 * The meta object literal for the '<em><b>Remaining Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES = eINSTANCE.getTemplatePlaceholderBrick_RemainingChoices();

		/**
		 * The meta object literal for the '<em><b>Composed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PLACEHOLDER_BRICK__COMPOSED = eINSTANCE.getTemplatePlaceholderBrick_Composed();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl <em>Object Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getObjectPlaceholderBrick()
		 * @generated
		 */
		EClass OBJECT_PLACEHOLDER_BRICK = eINSTANCE.getObjectPlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PLACEHOLDER_BRICK__ELEMENT = eINSTANCE.getObjectPlaceholderBrick_Element();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PLACEHOLDER_BRICK__TYPE = eINSTANCE.getObjectPlaceholderBrick_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl <em>Text Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.TextBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTextBrick()
		 * @generated
		 */
		EClass TEXT_BRICK = eINSTANCE.getTextBrick();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_BRICK__TEXT = eINSTANCE.getTextBrick_Text();

		/**
		 * The meta object literal for the '<em><b>Selectable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_BRICK__SELECTABLE = eINSTANCE.getTextBrick_Selectable();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl <em>Indent Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getIndentBrick()
		 * @generated
		 */
		EClass INDENT_BRICK = eINSTANCE.getIndentBrick();

		/**
		 * The meta object literal for the '<em><b>Bricks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDENT_BRICK__BRICKS = eINSTANCE.getIndentBrick_Bricks();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl <em>Line Break Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getLineBreakBrick()
		 * @generated
		 */
		EClass LINE_BREAK_BRICK = eINSTANCE.getLineBreakBrick();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getViewableBrick()
		 * @generated
		 */
		EClass VIEWABLE_BRICK = eINSTANCE.getViewableBrick();

		/**
		 * The meta object literal for the '<em><b>Get Text</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VIEWABLE_BRICK___GET_TEXT = eINSTANCE.getViewableBrick__GetText();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl <em>Blank Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBlankBrick()
		 * @generated
		 */
		EClass BLANK_BRICK = eINSTANCE.getBlankBrick();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl <em>Composed Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getComposedBrick()
		 * @generated
		 */
		EClass COMPOSED_BRICK = eINSTANCE.getComposedBrick();

		/**
		 * The meta object literal for the '<em><b>Bricks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_BRICK__BRICKS = eINSTANCE.getComposedBrick_Bricks();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.StyledBrickImpl <em>Styled Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.StyledBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getStyledBrick()
		 * @generated
		 */
		EClass STYLED_BRICK = eINSTANCE.getStyledBrick();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLED_BRICK__HIGHLIGHT = eINSTANCE.getStyledBrick_Highlight();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl <em>Value Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getValuePlaceholderBrick()
		 * @generated
		 */
		EClass VALUE_PLACEHOLDER_BRICK = eINSTANCE.getValuePlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_PLACEHOLDER_BRICK__TYPE = eINSTANCE.getValuePlaceholderBrick_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ObjectDomainPlaceholderBrickImpl <em>Object Domain Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ObjectDomainPlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getObjectDomainPlaceholderBrick()
		 * @generated
		 */
		EClass OBJECT_DOMAIN_PLACEHOLDER_BRICK = eINSTANCE.getObjectDomainPlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN = eINSTANCE.getObjectDomainPlaceholderBrick_Domain();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl <em>Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getPlaceholderBrick()
		 * @generated
		 */
		EClass PLACEHOLDER_BRICK = eINSTANCE.getPlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_BRICK__MANDATORY = eINSTANCE.getPlaceholderBrick_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Placeholder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_BRICK__PLACEHOLDER = eINSTANCE.getPlaceholderBrick_Placeholder();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ComposedTemplatePlaceholderBrickImpl <em>Composed Template Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ComposedTemplatePlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getComposedTemplatePlaceholderBrick()
		 * @generated
		 */
		EClass COMPOSED_TEMPLATE_PLACEHOLDER_BRICK = eINSTANCE.getComposedTemplatePlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Container Brick</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK = eINSTANCE.getComposedTemplatePlaceholderBrick_ContainerBrick();

	}

} //CodebricksPackage