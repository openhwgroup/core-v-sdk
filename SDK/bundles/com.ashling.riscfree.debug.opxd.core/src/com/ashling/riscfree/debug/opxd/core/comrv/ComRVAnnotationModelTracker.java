package com.ashling.riscfree.debug.opxd.core.comrv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.cdt.core.model.CModelException;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.ui.CDTUITools;
import org.eclipse.cdt.ui.ICEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import com.ashling.riscfree.debug.opxd.core.Activator;

public class ComRVAnnotationModelTracker {

	private List<String> loadedOverlaySymbols = new ArrayList<>();
	private List<String> overlaySymbols = new ArrayList<>();
	HashMap<String, CFunctionDetails> symbolMap = new HashMap<>();
	List<IMarker> markerList = new ArrayList<>();
	MapFileParser parser;
	private static ComRVAnnotationModelTracker markerInstance = null;

	public static ComRVAnnotationModelTracker getInstance() {
		if (markerInstance == null) {
			markerInstance = new ComRVAnnotationModelTracker();
		}
		return markerInstance;
	}

	/**
	 * This method will retrieve all the CEditors currently opened in the editor
	 * and annotate all the editors
	 * 
	 * @param The list of symbols
	 * @param The list of loaded symbols
	 */

	public void annotateAllCEditors(List<String> overlaySymbols, List<String> loadedOverlaySymbols) {
		this.overlaySymbols = overlaySymbols;
		this.loadedOverlaySymbols = loadedOverlaySymbols;
		addPartEventListener();
		ITranslationUnit unit = null;

		for (IWorkbenchWindow w : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			for (IWorkbenchPage p : w.getPages()) {
				for (IEditorReference e : p.getEditorReferences()) {
					IWorkbenchPartReference partref = e;
					IWorkbenchPart part = partref.getPart(false);
					if (part instanceof ICEditor) {
						ICEditor editor = (ICEditor) part;
						ICElement element = CDTUITools.getEditorInputCElement(editor.getEditorInput());
						if (element == null) {
							return;
						}
						IDocumentProvider provider = ((ITextEditor) part).getDocumentProvider();
						if (provider != null) {
							ITextEditor textEditor = ((ITextEditor) part);
							IDocumentProvider documentProvider = textEditor.getDocumentProvider();
							if (documentProvider == null) {
								return;
							}
							final IEditorInput input = textEditor.getEditorInput();
							if (input != null) {
								unit = (ITranslationUnit) CDTUITools.getEditorInputCElement(input);
								generateMethodList(unit);
							}

						}
					}
				}
			}
		}
	}

	private void removeParListener() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		for (IWorkbenchWindow w : workbench.getWorkbenchWindows()) {
			w.getPartService().removePartListener(partListener);
		}
	}

	public void clearSelections() {
		loadedOverlaySymbols.clear();
		overlaySymbols.clear();
		markerList.stream().forEach(p -> {
			try {
				p.delete();
			} catch (CoreException e) {
				Activator.log(e);
			}
		});
		markerList.clear();
		removeParListener();

	}

	/*
	 * identify the functions in the given c file
	 */
	private void generateMethodList(ITranslationUnit unit) {
		symbolMap.clear();
		if (unit != null) {
			String fileContent = new String(unit.getContents());
			try {
				List<ICElement> element = unit.getChildrenOfType(ICElement.C_FUNCTION);
				if (element != null) {
					for (int i = 0; i < element.size(); i++) {
						findFunction(element.get(i).toString(), countLines(fileContent), unit);
					}
					addMarkerAnnotation(unit);
				}
			} catch (CModelException e1) {
				Activator.log(e1);
			}
		}
	}

	/*
	 * find the total number of lines in a file
	 */
	private static int countLines(String str) {
		String[] lines = str.split("\r\n|\r|\n");
		return lines.length;
	}

	/*
	 * find the start line and end line of the given function
	 */
	private void findFunction(String functionName, int fileLength, ITranslationUnit unit) {
		int startLine = 0;
		boolean functionFound = false;
		int length = 0;
		try {
			for (int i = 0; i < fileLength; i++) {

				if (unit.getElementAtLine(i) != null) {
					if (unit.getElementAtLine(i).toString().equalsIgnoreCase(functionName)
							&& unit.getElementAtLine(i).getElementType() == ICElement.C_FUNCTION) {
						if (!functionFound) {
							startLine = i;
							functionFound = true;
						}
						length++;
					}
				}
			}
			
			symbolMap.put(functionName, new CFunctionDetails(functionName, startLine, startLine + length));

		} catch (CModelException e) {
			Activator.log(e);
		}

	}

	/*
	 * Add marker to the non-overlay functions
	 */
	private void addMarkerAnnotation(ITranslationUnit unit) {

		IPath path = new Path(unit.getPath().toString());
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(path);
		symbolMap.forEach((k, v) -> {

			for (String overlaySymbol : overlaySymbols) {

				if (overlaySymbol.equalsIgnoreCase(k) && !loadedOverlaySymbols.contains(k)) {
					for (int i = v.getStartLine(); i < v.getEndLine(); i++) {
						try {
							markerList.add(ComRVResourceMarkerAnnotationModel.createMarker(file, i));
						} catch (CoreException e) {
							Activator.log(e);
						}
					}
				}

			}
		});
	}

	private void addPartEventListener() {

		IWorkbench workbench = PlatformUI.getWorkbench();
		// Add part listener for current windows
		for (IWorkbenchWindow w : workbench.getWorkbenchWindows()) {
			w.getPartService().addPartListener(partListener);
		}
	}

	/*
	 * When the user open a new file in editor we need to mark the non-loaded
	 * symbols
	 */
	private IPartListener2 partListener = new IPartListener2() {

		@Override
		public void partActivated(IWorkbenchPartReference partRef) {
			if (partRef != null) {
				IWorkbenchPart part = partRef.getPart(false);
				ITranslationUnit unit = null;
				if (part instanceof ICEditor) {
					ICEditor editor = (ICEditor) part;
					ICElement element = CDTUITools.getEditorInputCElement(editor.getEditorInput());
					if (element == null) {
						return;
					}
					IDocumentProvider provider = ((ITextEditor) part).getDocumentProvider();
					if (provider != null) {
						ITextEditor textEditor = ((ITextEditor) part);
						IDocumentProvider documentProvider = textEditor.getDocumentProvider();
						if (documentProvider == null) {
							return;
						}
						final IEditorInput input = textEditor.getEditorInput();
						if (input != null) {
							unit = (ITranslationUnit) CDTUITools.getEditorInputCElement(input);
							generateMethodList(unit);
						}

					}
				}
			}
		}

		@Override
		public void partOpened(IWorkbenchPartReference partref) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
		}
	};
}
