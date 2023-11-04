package org.openhwgroup.corev.ide.wizard;

import java.io.BufferedInputStream;

/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.openhwgroup.corev.ide.definition.Activator;
import org.openhwgroup.corev.ide.wizard.util.LabelsHandle;
import org.openhwgroup.corev.ide.wizard.util.ViewContentProvider;
import org.openhwgroup.corev.ide.wizard.util.ViewLabelProvider;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileManipulations;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
import org.eclipse.ui.internal.wizards.datatransfer.ILeveledImportStructureProvider;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.internal.registry.osgi.OSGIUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ui.internal.wizards.datatransfer.TarEntry;
import org.eclipse.ui.internal.wizards.datatransfer.TarException;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;
import org.eclipse.ui.internal.wizards.datatransfer.TarInputStream;
import org.eclipse.ui.internal.wizards.datatransfer.TarLeveledStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.ZipLeveledStructureProvider;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import com.ashling.riscfree.debug.opxd.core.utils.OSUtil;
import com.ashling.riscfree.debug.opxd.core.utils.OSUtil.OS;


public class SampleProjectSelectionWizard extends WizardPage {

	private Tree tree;
	private TreeViewer viewer;
	private Composite container;
	private String exampleProjectNodePathDefault;

	private List<String> selectedProjectFromTree = new ArrayList<>();
	private ILeveledImportStructureProvider structureProvider;
	private ProjectRecord[] selectedProjects = new ProjectRecord[0];

	private static final String ZIP_FORMAT = ".zip"; //$NON-NLS-1$
	private static final String TAR_FORMAT = ".tar"; //$NON-NLS-1$
	private static final String TAR_GZ_FORMAT = ".tar.gz"; //$NON-NLS-1$

	public SampleProjectSelectionWizard(String str, IStructuredSelection selection) {
		super(LabelsHandle.getString("ImportWizard.Sample.WizardTitle")); //$NON-NLS-1$
		setTitle(LabelsHandle.getString("ImportWizard.Sample.WizardHeading")); //$NON-NLS-1$
		setDescription(LabelsHandle.getString("ImportWizard.SampleProjectSelectionWizard.Desc")); //$NON-NLS-1$
	}

	@Override
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		PatternFilter filter = new PatternFilter() {

			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				ITreeNode parentElement = (ITreeNode) element;
				while (parentElement != null) {
					if (super.isLeafMatch(viewer, parentElement)) {
						return true;
					}
					parentElement = parentElement.getParent();
				}
				return false;
			}
		};

		FilteredTree filterTree = new FilteredTree(container, SWT.CHECK, filter, true, true);

		viewer = filterTree.getViewer();
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		exampleProjectNodePathDefault = resolvePath("${eclipse_home}/../examples"); //$NON-NLS-1$
		viewer.setInput(new FolderNode(new File(exampleProjectNodePathDefault)));

		viewer.expandAll();
		viewer.collapseAll();

		tree = filterTree.getViewer().getTree();
		tree.addListener(SWT.Selection, event -> {

			TreeItem item = (TreeItem) event.item;
			if (event.detail == SWT.CHECK) {

				boolean checked = item.getChecked();
				checkItems(item, checked);
				checkPath(item.getParentItem(), checked, false);
				if (!checked) {
					item.setExpanded(false);
					viewer.refresh();
				}

				viewer.setSelection(StructuredSelection.EMPTY);
			}
		});

		setControl(container);
	}

	public void checkPath(TreeItem item, boolean checked, boolean grayed) {
		if (item == null)
			return;
		if (grayed) {
			checked = true;
		} else {
			int index = 0;
			TreeItem[] items = item.getItems();
			while (index < items.length) {
				TreeItem child = items[index];
				if (child.getGrayed() || checked != child.getChecked()) {
					checked = grayed = true;
					break;
				}
				index++;
			}
		}
		item.setChecked(checked);
		item.setGrayed(grayed);
		checkPath(item.getParentItem(), checked, grayed);
	}

	public void checkItems(TreeItem item, boolean checked) {
		item.setGrayed(false);
		item.setChecked(checked);
		item.setExpanded(true);
		viewer.refresh();
		for (TreeItem child : item.getItems()) {
			checkItems(child, checked);
		}
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	
	public void performFinish() {

		fetchProjectPathFromTreeNodeSelection(tree.getItem(0), tree.getItem(0).getText());
		List<IProject> projectsNotCopied = new ArrayList<>();
		List<String> invalidFileSelected = new ArrayList<>();
		File file;
		boolean isFreeRTOSProject =false;
		for (String projectPath : selectedProjectFromTree) {
			file=new File(projectPath);
			String parentFolder=file.getParentFile().getName();
			if(parentFolder.equalsIgnoreCase("FreeRTOS")) { //$NON-NLS-1$
				isFreeRTOSProject=true;
				break;
			}
		}
		
		if(isFreeRTOSProject) {
			if(OSUtil.getOS()== OS.WINDOWS) {
			selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/FreeRTOS-Kernel.zip")); //$NON-NLS-1$
			selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/common-io.zip")); //$NON-NLS-1$
			selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/shared.zip")); //$NON-NLS-1$
			}else if(OSUtil.getOS()== OS.WINDOWS) {
				selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/FreeRTOS-Kernel.tar.gz")); //$NON-NLS-1$
				selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/common-io.tar.gz")); //$NON-NLS-1$
				selectedProjectFromTree.add(resolvePath("${eclipse_home}/../examples/shared_examples/shared.tar.gz")); //$NON-NLS-1$
				
			}
		}
		for (String projectPath : selectedProjectFromTree) {
			if(projectPath.contains("shared.zip")) {  //$NON-NLS-1$ 
				extractZip(projectPath,ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
				continue;
			}else if(projectPath.contains("shared.tar.gz")) { //$NON-NLS-1$
				extractTarGz(projectPath,ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
				continue;
			}
			List<IProject> createdProjects = new ArrayList<>();
			try {
				getContainer().run(true, true, monitor -> {

					boolean isProjectExists = false;
					ILeveledImportStructureProvider importStructureProvider = null;
					if (ArchiveFileManipulations.isTarFile(projectPath)) {
						TarFile sourceFile = getSpecifiedTarSourceFile(projectPath);
						structureProvider = new TarLeveledStructureProvider(sourceFile);
					} else if (ArchiveFileManipulations.isZipFile(projectPath)) {
						ZipFile sourceFile = getSpecifiedZipSourceFile(projectPath);
						structureProvider = new ZipLeveledStructureProvider(sourceFile);
					}
					Object child = structureProvider.getRoot();

					Collection<ProjectRecord> files = new ArrayList<>();
					collectProjectFilesFromProvider(files, child, 0, monitor);
					Iterator<ProjectRecord> filesIterator = files.iterator();
					selectedProjects = new ProjectRecord[files.size()];
					int index = 0;
					while (filesIterator.hasNext()) {
						selectedProjects[index++] = filesIterator.next();
					}

					if (selectedProjects.length >= 1) {


						// import from file system
						File importSource = null;
						ProjectRecord record = selectedProjects[0];// Assuming single record/project in the project zip
																	// files
						String projectName = record.getProjectName();
						final IWorkspace workspace = ResourcesPlugin.getWorkspace();

						IProject[] existingProjects = workspace.getRoot().getProjects();
						for (IProject existingProject : existingProjects) {
							if (Objects.equals(projectName, existingProject.getName())) {
								if(projectName.equals("common-io") || projectName.equals("FreeRTOS-Kernel")) {//$NON-NLS-1$//$NON-NLS-2$
								continue;
								}
								isProjectExists = true;
								projectsNotCopied.add(existingProject);
							}
						}

						// Do not copy the project if already exists in the workspace
						if (!isProjectExists) {
							final IProject project = workspace.getRoot().getProject(projectName);
							createdProjects.add(project);
							if (record.description == null) {
								// error case
								record.description = workspace.newProjectDescription(projectName);
								IPath locationPath = new Path(record.projectSystemFile.getAbsolutePath());

								// If it is under the root use the default location
								if (Platform.getLocation().isPrefixOf(locationPath)) {
									record.description.setLocation(null);
								} else {
									record.description.setLocation(locationPath);
								}
							} else {
								record.description.setName(projectName);
							}

							SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
							if (record.projectArchiveFile != null) {
								// import from archive
								List<?> fileSystemObjects = structureProvider.getChildren(record.parent);
								structureProvider.setStrip(record.level);
								ImportOperation operation = new ImportOperation(project.getFullPath(),
										structureProvider.getRoot(), structureProvider, null, fileSystemObjects);
								operation.setContext(getShell());

								try {
									if (operation != null) {
										operation.run(subMonitor.split(1));
									}
								} catch (InvocationTargetException e) {
									Activator.log(e);
								}
							}
							// import project from location copying files - use default project location for
							// this workspace
							URI locationURI = record.description.getLocationURI();
							// if location is null, project already exists in this location or
							// some error condition occured.
							if (locationURI != null) {

								importSource = new File(locationURI);
								IProjectDescription desc = workspace.newProjectDescription(projectName);
								desc.setBuildSpec(record.description.getBuildSpec());
								desc.setComment(record.description.getComment());
								desc.setDynamicReferences(record.description.getDynamicReferences());
								desc.setNatureIds(record.description.getNatureIds());
								desc.setReferencedProjects(record.description.getReferencedProjects());
								record.description = desc;
							}

							if (importSource != null) {
								try {
									List filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(importSource);
									ImportOperation operation = new ImportOperation(project.getFullPath(), importSource,
											FileSystemStructureProvider.INSTANCE, null, filesToImport);

									operation.setContext(getShell());
									operation.setOverwriteResources(true); // need to overwrite
									operation.setCreateContainerStructure(false);

									operation.run(subMonitor.split(70));

									project.open(subMonitor.split(1));
									Thread.sleep(100);
								} catch (Exception e) {
									IDEWorkbenchPlugin.log(e.getMessage(), e);
								}
							}

						} // Skip the code until here if the project already exists in the workspace
					} else {
						invalidFileSelected.add(projectPath);
					}

				});
			} catch (InvocationTargetException e) {
				IDEWorkbenchPlugin.log(e.getMessage(), e);
			} catch (InterruptedException e) {
				// Nothing to do if the user interrupts.
				Activator.log(e);
			}
		}

		StringBuilder workspaceProjects = new StringBuilder();
		int counter = 0;

		List<IProject> newListprojectsNotCopied = projectsNotCopied.stream().distinct().collect(Collectors.toList());

		for (IProject projectNotCopied : newListprojectsNotCopied) {
			counter++;
			workspaceProjects.append(counter + ". " + projectNotCopied.getName() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		String projectsList = workspaceProjects.toString();
		if (!projectsNotCopied.isEmpty()) {
			MessageDialog.openInformation(new Shell(Display.getDefault()),
					LabelsHandle.getString("ImportWizard.Sample.WizardHeading"), //$NON-NLS-1$
					LabelsHandle.getString("ImportWizard.SampleProjectSelectionWizard.ExistingProject.Message") + "\n\n" //$NON-NLS-1$ //$NON-NLS-2$
							+ projectsList);
		}

		if (!invalidFileSelected.isEmpty()) {
			MessageDialog.openInformation(new Shell(Display.getDefault()),
					LabelsHandle.getString("ImportWizard.Sample.WizardHeading"), //$NON-NLS-1$
					LabelsHandle.getString("ImportWizard.SampleProjectSelectionWizard.InvalidProject.Message")); //$NON-NLS-1$
		}
		selectedProjectFromTree = null;// To remove all selected projects from the list
		projectsNotCopied.clear();
		invalidFileSelected.clear();
	}

	/**
	 * Answer a handle to the zip file currently specified as being the source.
	 * Return null if this file does not exist or is not of valid format.
	 */
	private ZipFile getSpecifiedZipSourceFile(String fileName) {
		if (fileName.isEmpty()) {
			return null;
		}

		try {
			return new ZipFile(fileName);
		} catch (IOException e) {
			Activator.log(e);
		}
		return null;
	}

	/**
	 * Answer a handle to the zip file currently specified as being the source.
	 * Return null if this file does not exist or is not of valid format.
	 */
	private TarFile getSpecifiedTarSourceFile(String fileName) {
		if (fileName.isEmpty()) {
			return null;
		}

		try {
			return new TarFile(fileName);
		} catch (TarException | IOException e) {
			// ignore
		}
		return null;
	}

	/**
	 * Collect the list of .project files that are under directory into files.
	 *
	 * @param files
	 * @param monitor The monitor to report to
	 * @return boolean <code>true</code> if the operation was completed.
	 */
	private boolean collectProjectFilesFromProvider(Collection<ProjectRecord> files, Object entry, int level,
			IProgressMonitor monitor) {

		List<?> children = structureProvider.getChildren(entry);
		Iterator<?> childrenEnum = children.iterator();
		while (childrenEnum.hasNext()) {
			Object child = childrenEnum.next();
			if (structureProvider.isFolder(child)) {
				collectProjectFilesFromProvider(files, child, level + 1, monitor);
			}
			String elementLabel = structureProvider.getLabel(child);
			if (elementLabel.equals(IProjectDescription.DESCRIPTION_FILE_NAME)) {
				files.add(new ProjectRecord(child, entry, level));
			}
		}
		return true;
	}

	private void fetchProjectPathFromTreeNodeSelection(TreeItem item, String path) {

		if ((item.getItems().length == 0) && item.getChecked()) {
			selectedProjectFromTree
					.add(fileExistingInTheDirectory(resolvePath(exampleProjectNodePathDefault + "/" + path))); //$NON-NLS-1$
		} else {

			for (int i = 0; i < item.getItemCount(); ++i) {
				if (item.getItem(i).getChecked()) {
					fetchProjectPathFromTreeNodeSelection(item.getItem(i), path + "/" + item.getItem(i).getText()); //$NON-NLS-1$
				}
			}
		}
	}

	private String fileExistingInTheDirectory(String availablePath) {
		String[] formatSupports = { ZIP_FORMAT, TAR_FORMAT, TAR_GZ_FORMAT };

		for (String fileExtension : formatSupports) {
			String absolutePath = availablePath + fileExtension;
			File tempFile = new File(absolutePath);
			if (tempFile.exists()) {
				return absolutePath;
			}
		}
		return null;
	}

	private String resolvePath(String value) {
		try {
			// Do not report undefined variables
			value = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(value, false)
					.trim();
		} catch (CoreException e) {
			Activator.log(e);
		}
		return value;
	}
	
	 public void extractZip(String sourceFilePath, String destinationFolder) {
	        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sourceFilePath))) {
	            extractFromZipStream(zipInputStream, destinationFolder);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void extractFromZipStream(ZipInputStream zipInputStream, String destinationFolder) {
	        try {
	            ZipEntry zipEntry;
	            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
	                File outputFile = new File(destinationFolder, zipEntry.getName());

	                if (zipEntry.isDirectory()) {
	                    outputFile.mkdirs();
	                } else {
	                    File parent = outputFile.getParentFile();
	                    if (!parent.exists()) {
	                        parent.mkdirs();
	                    }

	                    try (OutputStream output = new FileOutputStream(outputFile)) {
	                        byte[] buffer = new byte[1024];
	                        int bytesRead;
	                        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
	                            output.write(buffer, 0, bytesRead);
	                        }
	                    }
	                }
	                zipInputStream.closeEntry();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void extractTarGz(String sourceFilePath, String destinationFolder) {
	        try (FileInputStream fileStream = new FileInputStream(sourceFilePath);
	             GZIPInputStream gzipStream = new GZIPInputStream(fileStream);
	             BufferedInputStream bufferedStream = new BufferedInputStream(gzipStream);
	             TarInputStream tarInputStream = new TarInputStream(bufferedStream)) {

	            extractFromTarStream(tarInputStream, destinationFolder);

	        } catch (IOException | TarException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void extractFromTarStream(TarInputStream tarInputStream, String destinationFolder) {
	        try {
	            TarEntry entry;
	            while ((entry = tarInputStream.getNextEntry()) != null) {
	                if (entry.getName().endsWith(File.separator)) {
	                    new File(destinationFolder, entry.getName()).mkdirs();
	                } else {
	                    File outputFile = new File(destinationFolder, entry.getName());
	                    File parent = outputFile.getParentFile();
	                    if (!parent.exists()) {
	                        parent.mkdirs();
	                    }

	                    try (OutputStream output = new FileOutputStream(outputFile)) {
	                        byte[] buffer = new byte[1024];
	                        int bytesRead;
	                        while ((bytesRead = tarInputStream.read(buffer)) != -1) {
	                            output.write(buffer, 0, bytesRead);
	                        }
	                    }
	                }
	            }
	        } catch (IOException | TarException e) {
	            e.printStackTrace();
	        }
	    }

	public class ProjectRecord {
		private File projectSystemFile;

		private Object projectArchiveFile;

		private String projectName;

		private Object parent;

		private int level;

		private boolean hasConflicts;

		private boolean isInvalid = false;

		private IProjectDescription description;

		/**
		 * Create a record for a project based on the info in the file.
		 *
		 * @param file
		 */
		public ProjectRecord(File file) {
			projectSystemFile = file;
			setProjectName();
		}

		/**
		 * @param file   The Object representing the .project file
		 * @param parent The parent folder of the .project file
		 * @param level  The number of levels deep in the provider the file is
		 */
		public ProjectRecord(Object file, Object parent, int level) {
			this.projectArchiveFile = file;
			this.parent = parent;
			this.level = level;
			setProjectName();
		}

		/**
		 * Set the name of the project based on the projectFile.
		 */
		private void setProjectName() {
			try {
				if (projectArchiveFile != null) {
					InputStream stream = structureProvider.getContents(projectArchiveFile);

					// If we can get a description pull the name from there
					if (stream == null) {
						if (projectArchiveFile instanceof ZipEntry) {
							IPath path = new Path(((ZipEntry) projectArchiveFile).getName());
							projectName = path.segment(path.segmentCount() - 2);
						} else if (projectArchiveFile instanceof TarEntry) {
							IPath path = new Path(((TarEntry) projectArchiveFile).getName());
							projectName = path.segment(path.segmentCount() - 2);
						}
					} else {
						description = IDEWorkbenchPlugin.getPluginWorkspace().loadProjectDescription(stream);
						stream.close();
						projectName = description.getName();
					}

				}

				// If we don't have the project name try again
				if (projectName == null) {
					IPath path = new Path(projectSystemFile.getPath());
					// if the file is in the default location, use the directory
					// name as the project name
					if (isDefaultLocation(path)) {
						projectName = path.segment(path.segmentCount() - 2);
						description = IDEWorkbenchPlugin.getPluginWorkspace().newProjectDescription(projectName);
					} else {
						description = IDEWorkbenchPlugin.getPluginWorkspace().loadProjectDescription(path);
						projectName = description.getName();
					}

				}
			} catch (CoreException | IOException e) {
				this.projectName = DataTransferMessages.WizardProjectsImportPage_invalidProjectName;
				this.isInvalid = true;
			}
		}

		/**
		 * Returns whether the given project description file path is in the default
		 * location for a project
		 *
		 * @param path The path to examine
		 * @return Whether the given path is the default location for a project
		 */
		private boolean isDefaultLocation(IPath path) {
			// The project description file must at least be within the project,
			// which is within the workspace location
			if (path.segmentCount() < 2) {
				return false;
			}
			return path.removeLastSegments(2).toFile().equals(Platform.getLocation().toFile());
		}

		/**
		 * Get the name of the project
		 *
		 * @return String
		 */
		public String getProjectName() {
			return projectName;
		}

		/**
		 * Returns whether the given project description file was invalid
		 *
		 * @return boolean
		 */
		public boolean isInvalidProject() {
			return isInvalid;
		}

		/**
		 * Gets the label to be used when rendering this project record in the UI.
		 *
		 * @return String the label
		 * @since 3.4
		 */
		public String getProjectLabel() {
			String path = projectSystemFile == null ? structureProvider.getFullPath(parent)
					: projectSystemFile.getParent();
			return NLS.bind(DataTransferMessages.WizardProjectsImportPage_projectLabel, projectName, path);
		}

		/**
		 * @return Returns the hasConflicts.
		 */
		public boolean hasConflicts() {
			return hasConflicts;
		}
	}

}
