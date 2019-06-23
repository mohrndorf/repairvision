/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.provider.NodeItemProvider;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.NodeExtension;

/**
 * This is the item provider adapter for a {@link org.sidiff.graphpattern.profile.henshin_extension.NodeExtension} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeExtensionItemProvider 
	extends NodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeExtensionItemProvider(AdapterFactory adapterFactory) {
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

			addSubgraphsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Subgraphs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubgraphsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GraphElementExtension_subgraphs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GraphElementExtension_subgraphs_feature", "_UI_GraphElementExtension_type"),
				 HenshinExtensionPackage.Literals.GRAPH_ELEMENT_EXTENSION__SUBGRAPHS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns NodeExtension.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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
				(HenshinPackage.Literals.NODE__ATTRIBUTES,
				 HenshinExtensionFactory.eINSTANCE.createAttributeExtension()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return HenshinExtensionEditPlugin.INSTANCE;
	}

}
