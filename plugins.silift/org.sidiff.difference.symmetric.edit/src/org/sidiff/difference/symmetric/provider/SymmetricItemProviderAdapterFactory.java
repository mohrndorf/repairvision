/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.sidiff.difference.symmetric.util.SymmetricAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SymmetricItemProviderAdapterFactory extends SymmetricAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the item providers created, so that they can be {@link #dispose disposed}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Disposable disposable = new Disposable();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.SymmetricDifference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSymmetricDifferenceAdapter() {
		return new SymmetricDifferenceItemProvider(this);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.AddObject} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddObjectItemProvider addObjectItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.AddObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddObjectAdapter() {
		if (addObjectItemProvider == null) {
			addObjectItemProvider = new AddObjectItemProvider(this);
		}

		return addObjectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.RemoveObject} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveObjectItemProvider removeObjectItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.RemoveObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRemoveObjectAdapter() {
		if (removeObjectItemProvider == null) {
			removeObjectItemProvider = new RemoveObjectItemProvider(this);
		}

		return removeObjectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.AddReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddReferenceItemProvider addReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.AddReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddReferenceAdapter() {
		if (addReferenceItemProvider == null) {
			addReferenceItemProvider = new AddReferenceItemProvider(this);
		}

		return addReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.RemoveReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveReferenceItemProvider removeReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.RemoveReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRemoveReferenceAdapter() {
		if (removeReferenceItemProvider == null) {
			removeReferenceItemProvider = new RemoveReferenceItemProvider(this);
		}

		return removeReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.SemanticChangeSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticChangeSetItemProvider semanticChangeSetItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.SemanticChangeSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSemanticChangeSetAdapter() {
		if (semanticChangeSetItemProvider == null) {
			semanticChangeSetItemProvider = new SemanticChangeSetItemProvider(this);
		}

		return semanticChangeSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.AttributeValueChange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueChangeItemProvider attributeValueChangeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.AttributeValueChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueChangeAdapter() {
		if (attributeValueChangeItemProvider == null) {
			attributeValueChangeItemProvider = new AttributeValueChangeItemProvider(this);
		}

		return attributeValueChangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EString2EObjectSetMapItemProvider eString2EObjectSetMapItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEString2EObjectSetMapAdapter() {
		if (eString2EObjectSetMapItemProvider == null) {
			eString2EObjectSetMapItemProvider = new EString2EObjectSetMapItemProvider(this);
		}

		return eString2EObjectSetMapItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.EditRuleMatch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditRuleMatchItemProvider editRuleMatchItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.EditRuleMatch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEditRuleMatchAdapter() {
		if (editRuleMatchItemProvider == null) {
			editRuleMatchItemProvider = new EditRuleMatchItemProvider(this);
		}

		return editRuleMatchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.EObjectSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectSetItemProvider eObjectSetItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.EObjectSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEObjectSetAdapter() {
		if (eObjectSetItemProvider == null) {
			eObjectSetItemProvider = new EObjectSetItemProvider(this);
		}

		return eObjectSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.FragmentJoin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentJoinItemProvider fragmentJoinItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.FragmentJoin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFragmentJoinAdapter() {
		if (fragmentJoinItemProvider == null) {
			fragmentJoinItemProvider = new FragmentJoinItemProvider(this);
		}

		return fragmentJoinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.difference.symmetric.FragmentSplit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentSplitItemProvider fragmentSplitItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.difference.symmetric.FragmentSplit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFragmentSplitAdapter() {
		if (fragmentSplitItemProvider == null) {
			fragmentSplitItemProvider = new FragmentSplitItemProvider(this);
		}

		return fragmentSplitItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * Associates an adapter with a notifier via the base implementation, then records it to ensure it will be disposed.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void associate(Adapter adapter, Notifier target) {
		super.associate(adapter, target);
		if (adapter != null) {
			disposable.add(adapter);
		}
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		disposable.dispose();
	}

}