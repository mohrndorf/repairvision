/**
 */
package org.sidiff.graphpattern.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.edit.util.LabelServices;

/**
 * This is the item provider adapter for a {@link org.sidiff.graphpattern.Pattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternItemProvider 
	extends PatternElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBundlePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Bundle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBundlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pattern_bundle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pattern_bundle_feature", "_UI_Pattern_type"),
				 GraphpatternPackage.Literals.PATTERN__BUNDLE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GraphpatternPackage.Literals.PATTERN__GRAPHS);
			childrenFeatures.add(GraphpatternPackage.Literals.PATTERN__PARAMETERS);
			childrenFeatures.add(GraphpatternPackage.Literals.PATTERN__ASSIGNMENTS);
			childrenFeatures.add(GraphpatternPackage.Literals.PATTERN__SUBPATTERNS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Pattern.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Pattern"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return LabelServices.getLabel((Pattern) object);
//		return label == null || label.length() == 0 ?
//			getString("_UI_Pattern_type") :
//			getString("_UI_Pattern_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Pattern.class)) {
			case GraphpatternPackage.PATTERN__GRAPHS:
			case GraphpatternPackage.PATTERN__PARAMETERS:
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
			case GraphpatternPackage.PATTERN__SUBPATTERNS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.PATTERN__GRAPHS,
				 GraphpatternFactory.eINSTANCE.createGraphPattern()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.PATTERN__PARAMETERS,
				 GraphpatternFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.PATTERN__ASSIGNMENTS,
				 GraphpatternFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.PATTERN__SUBPATTERNS,
				 GraphpatternFactory.eINSTANCE.createPattern()));
	}

}
