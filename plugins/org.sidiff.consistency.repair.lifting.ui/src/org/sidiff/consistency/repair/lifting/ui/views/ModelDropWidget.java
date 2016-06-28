package org.sidiff.consistency.repair.lifting.ui.views;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Composite;

public abstract class ModelDropWidget {

	protected TableViewer viewer_models;
	
	public ModelDropWidget(Composite parent) {
		
		// Initialize:
		viewer_models = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			viewer_models.setContentProvider(new ArrayContentProvider());
			viewer_models.setLabelProvider(new StorageLabelProvider());
		}
		
		// Drag and Drop support:
		int dndOperations = DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { 
				LocalTransfer.getInstance(), 
				LocalSelectionTransfer.getTransfer(), 
				FileTransfer.getInstance() };

		viewer_models.addDropSupport(dndOperations, transfers, new ViewerDropAdapter(viewer_models) {

			@Override
			public boolean validateDrop(Object target, int operation, TransferData transferType) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean performDrop(Object data) {

				if (data instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) data;

					selection.iterator().forEachRemaining(element -> {
						if (element instanceof IResource) {
							if (addModel((IResource) element)) {
								viewer_models.add(element);
							}
						}
					});
					return true;
				}
				return false;
			}
		});
		
		viewer_models.addDragSupport(DND.DROP_MOVE, transfers, new ViewerDragAdapter(viewer_models) {
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				super.dragFinished(event);
				Object selection = ((StructuredSelection) viewer_models.getSelection()).getFirstElement();
				
				if (selection instanceof IResource) {
					if (removeModel((IResource) selection)) {
						viewer_models.remove(selection);
					}
				}
			}
		});
	}
	
	public void clear() {
		viewer_models.setInput(null);
	}

	protected abstract boolean addModel(IResource element);

	protected abstract boolean removeModel(IResource selection);
	
	public static URI getURI(IResource workbenchResource) {

		String projectName = workbenchResource.getProject().getName();
		String filePath = workbenchResource.getProjectRelativePath().toOSString();
		String platformPath = projectName + "/" + filePath;

		return URI.createPlatformResourceURI(platformPath, true);
	}
}
