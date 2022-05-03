/*******************************************************************************
 * Copyright (c) 2021 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Nikifor Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.definition.ui.project;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.api.Configuration;
import org.openhwgroup.corev.ide.definition.api.Toolchain;
import org.openhwgroup.corev.ide.definition.project.SimpleConfiguration;
import org.openhwgroup.corev.ide.definition.storage.JsonStorage;
import org.openhwgroup.corev.ide.definition.storage.Storage;

public final class DefinePage extends WizardPage {

	private String projectName = new String();
	private String projectPath = new String();
	private List<Board> boards = new LinkedList<>();
	private List<Toolchain> toolchains = new LinkedList<>();
	private final Storage storage = new JsonStorage();

	protected DefinePage() {
		super("definition"); //$NON-NLS-1$
		setDescription("Create new CORE-V project from scratch"); //$NON-NLS-1$
		setTitle("New CORE-V project"); //$NON-NLS-1$
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = container(parent);
		createNameGroup(container);
		createPathGroup(container);
		createConfigurationGroup(container);
		setControl(container);
	}

	private Composite container(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).create());
		container.setLayoutData(GridDataFactory.fillDefaults().create());
		return container;
	}

	private void createNameGroup(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(GridDataFactory.fillDefaults().create());
		label.setText("Project name:"); //$NON-NLS-1$
		Text name = new Text(container, SWT.BORDER);
		name.setMessage("Project name"); //$NON-NLS-1$
		name.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).grab(true, false).create());
		name.addModifyListener(event -> {
			if (!ResourcesPlugin.getWorkspace().getRoot().getProject(name.getText()).exists()) {
				projectName = name.getText();
			}
		});
	}

	private void createPathGroup(Composite container) {
		Label pathLabel = new Label(container, SWT.NONE);
		pathLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).create());
		pathLabel.setText("Path to the project root:"); //$NON-NLS-1$
		Text path = new Text(container, SWT.BORDER);
		path.setMessage("Path to the project root"); //$NON-NLS-1$
		path.setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).create());
		path.addModifyListener(event -> {
			projectPath = path.getText();
		});
		Button pathButton = new Button(container, SWT.PUSH);
		pathButton.setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).create());
		pathButton.setText("Browse..."); //$NON-NLS-1$
		pathButton.addListener(SWT.Selection, event -> {
			DirectoryDialog dialog = new DirectoryDialog(container.getShell(), SWT.NONE);
			String open = dialog.open();
			path.setText(open);
			projectPath = open;
		});
	}

	private void createConfigurationGroup(Composite container) {
		Group configuration = new Group(container, SWT.NONE);
		configuration.setText("Project configuration"); //$NON-NLS-1$
		configuration.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).create());
		configuration.setLayoutData(GridDataFactory.fillDefaults().span(3, 1).grab(true, true).create());
		ListViewer boards = new ListViewer(configuration, SWT.BORDER | SWT.MULTI);
		boards.setLabelProvider(new MetaLabelProvider());
		boards.setContentProvider(ArrayContentProvider.getInstance());
		boards.setInput(storage.boards());
		boards.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		boards.addSelectionChangedListener(event -> this.boards = event.getStructuredSelection().toList());
		ListViewer toolchains = new ListViewer(configuration, SWT.BORDER | SWT.MULTI);
		toolchains.setLabelProvider(new MetaLabelProvider());
		toolchains.setContentProvider(ArrayContentProvider.getInstance());
		toolchains.setInput(storage.toolchains());
		toolchains.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		toolchains.addSelectionChangedListener(event -> this.toolchains = event.getStructuredSelection().toList());
		Button boardsButton = new Button(configuration, SWT.PUSH);
		boardsButton.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		boardsButton.setText("Select boards"); //$NON-NLS-1$
		Button toolchainsButton = new Button(configuration, SWT.PUSH);
		toolchainsButton.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		toolchainsButton.setText("Select toolchains"); //$NON-NLS-1$
	}

	public String name() {
		return projectName;
	}

	public String path() {
		return projectPath;
	}

	public Configuration configuration() {
		return new SimpleConfiguration(boards, toolchains);
	}

}
