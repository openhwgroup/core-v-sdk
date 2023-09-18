package com.ashling.riscfree.debug.osawareness.ui.tab;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.ashling.riscfree.debug.awareness.util.OSInfoManager;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.utils.LaunchConfigurationUtility;
import com.ashling.riscfree.debug.osawareness.ui.Activator;

public class TabOSAwareness extends AbstractLaunchConfigurationTab {

	private static final String TAB_NAME = "OS Awareness";
	private static final String TAB_ID = Activator.PLUGIN_ID + ".ui.advancedtab";
	private static Image TAB_IMAGE = null;
	private Button rtosDebugging;
	private Text rtosScriptLocation;
	private Button rtosLocationBrowseButton;
	private Combo rtosVersionCombo;
	private Combo rtosTypeCombo;
	private static final GridData LABEL_LAYOUT = new GridData(120, -1);
	private static String rtosTypeCombo_lastSelection = "";
	private Button enableMMUAwareness;
	Button customConfiguration;

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout layout = new GridLayout();
		comp.setLayout(layout);

		createRTOSGroup(comp);
	}

	private void createRTOSGroup(Composite parent) {

		Group group = new Group(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			group.setLayout(layout);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			group.setLayoutData(gd);
		}

		Composite comp = new Composite(group, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.marginHeight = 0;
			comp.setLayout(layout);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			comp.setLayoutData(gd);
		}

		{
			rtosDebugging = new Button(comp, SWT.CHECK);
			rtosDebugging.setText("Enable OS Aware Debugging");
			rtosDebugging.setToolTipText("Enable OS Aware Debugging");
			GridData gd = new GridData();
			gd.horizontalSpan = ((GridLayout) comp.getLayout()).numColumns;
			rtosDebugging.setLayoutData(gd);
		}

		{
			Composite local = new Composite(comp, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 4;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			local.setLayout(layout);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = ((GridLayout) comp.getLayout()).numColumns - 1;
			local.setLayoutData(gd);

			Label label = new Label(local, SWT.NONE);
			label.setText("OS :");
			

			rtosTypeCombo = new Combo(local, SWT.READ_ONLY | SWT.DROP_DOWN);
			rtosTypeCombo.setLayoutData(new GridData());
			rtosTypeCombo.setItems(OSInfoManager.INSTANCE.getSupportedRTOS());

			label = new Label(local, SWT.NONE);
			label.setText("Version :");

			rtosVersionCombo = new Combo(local, SWT.READ_ONLY | SWT.DROP_DOWN);
			rtosVersionCombo.setLayoutData(new GridData());
		}
		Label dummyLabel;
		if (LaunchConfigurationUtility.enableMMUAwarenessCfg()) {
			enableMMUAwareness = new Button(comp, SWT.CHECK);
			enableMMUAwareness.setText("Enable MMU awareness");
			enableMMUAwareness.setToolTipText("Enable MMU aware debugging");

			enableMMUAwareness.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					scheduleUpdateJob();
				}
			});
			GridData gd = new GridData();
			gd.horizontalSpan = ((GridLayout) comp.getLayout()).numColumns;
			enableMMUAwareness.setLayoutData(gd);
		}
		else {
			dummyLabel = new Label(comp, SWT.NONE);
			dummyLabel.setText("");
		}

		{
			customConfiguration = new Button(comp, SWT.CHECK);
			customConfiguration.setText("Custom Scripts");
			dummyLabel = new Label(comp, SWT.NONE);
			dummyLabel.setText("");
			dummyLabel = new Label(comp, SWT.NONE);
			dummyLabel.setText("");
		}

		{
			Label label = new Label(comp, SWT.NONE);
			label.setText("Script location");
			label.setLayoutData(LABEL_LAYOUT);
			label.setToolTipText("Python script location for RTOS");

			Composite local = new Composite(comp, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			local.setLayout(layout);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = ((GridLayout) comp.getLayout()).numColumns - 1;
			local.setLayoutData(gd);
			{
				rtosScriptLocation = new Text(local, SWT.SINGLE | SWT.BORDER);
				gd = new GridData(GridData.FILL_HORIZONTAL);
				rtosScriptLocation.setLayoutData(gd);

				rtosLocationBrowseButton = new Button(local, SWT.NONE);
				rtosLocationBrowseButton.setText("...");

			}
		}

		// ----- Actions ------------------------------------------------------

		rtosScriptLocation.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				scheduleUpdateJob();
				
			}
		});
		
		rtosDebugging.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				scheduleUpdateJob();
			}
		});

		rtosLocationBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseButtonSelected("Select script location", rtosScriptLocation);
				// scheduleUpdateJob();
			}
		});

		rtosTypeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!rtosTypeCombo_lastSelection.equalsIgnoreCase(rtosTypeCombo.getText())) {
					rtosTypeCombo_lastSelection = rtosTypeCombo.getText();
					rtosVersionCombo
							.setItems(OSInfoManager.INSTANCE.getSupportedVersions(rtosTypeCombo.getText()));
					rtosVersionCombo.select(0);
				}
				scheduleUpdateJob();
			}
		});

		rtosVersionCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				scheduleUpdateJob();
			}
		});

		customConfiguration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = customConfiguration.getSelection();
				handleCustomScriptSelection(selection);
				scheduleUpdateJob();
			}

		});

		rtosDebugging.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = rtosDebugging.getSelection();
				setAllControlsEnabled(selection);
				if (selection) {
					handleCustomScriptSelection(customConfiguration.getSelection());
				}
				scheduleUpdateJob();
			}
		});

	}

	private void setAllControlsEnabled(boolean selection) {
		customConfiguration.setEnabled(selection);
		rtosTypeCombo.setEnabled(selection);
		rtosVersionCombo.setEnabled(selection);
		rtosScriptLocation.setEnabled(selection);
		rtosLocationBrowseButton.setEnabled(selection);
	}

	private void handleCustomScriptSelection(boolean selection) {
		rtosScriptLocation.setEnabled(selection);
		rtosLocationBrowseButton.setEnabled(selection);
		rtosTypeCombo.setEnabled(!selection);
		rtosVersionCombo.setEnabled(!selection);

	}

	private void browseButtonSelected(String title, Text text) {
		DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
		dialog.setText(title);
		String str = text.getText().trim();
		int lastSeparatorIndex = str.lastIndexOf(File.separator);
		if (lastSeparatorIndex != -1)
			dialog.setFilterPath(str.substring(0, lastSeparatorIndex));
		str = dialog.open();
		if (str != null)
			text.setText(str);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConfigurationAttributes.RTOS_DEBUG, DefaultPreferences.OS_AWARENESS_RTOS_DEBUGGING);
		configuration.setAttribute(ConfigurationAttributes.RTOS_CUSTOM, DefaultPreferences.OS_AWARENESS_CUSTOM_RTOS);
		configuration.setAttribute(ConfigurationAttributes.RTOS_SCRIPT_LOCATION, "");
		configuration.setAttribute(ConfigurationAttributes.RTOS_TYPE, OSInfoManager.INSTANCE.getDefaultOSType().orElse(""));
		configuration.setAttribute(ConfigurationAttributes.RTOS_VERSION, OSInfoManager.INSTANCE.getDefaultOSVersion().orElse(""));
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			boolean isRTOSDebugging = configuration.getAttribute(ConfigurationAttributes.RTOS_DEBUG,
					DefaultPreferences.OS_AWARENESS_RTOS_DEBUGGING);
			rtosDebugging.setSelection(isRTOSDebugging);
			setAllControlsEnabled(isRTOSDebugging);
			customConfiguration.setSelection(configuration.getAttribute(ConfigurationAttributes.RTOS_CUSTOM,
					DefaultPreferences.OS_AWARENESS_CUSTOM_RTOS));
			if (isRTOSDebugging) {
				handleCustomScriptSelection(customConfiguration.getSelection());
			}
			String rtosType = configuration.getAttribute(ConfigurationAttributes.RTOS_TYPE,
					OSInfoManager.INSTANCE.getDefaultOSType().orElse(""));
			rtosTypeCombo.setText(rtosType);
			if (!rtosType.isEmpty()) {
				rtosVersionCombo.setItems(OSInfoManager.INSTANCE.getSupportedVersions(rtosType));
			}
			rtosVersionCombo.setText(configuration.getAttribute(ConfigurationAttributes.RTOS_VERSION,
					OSInfoManager.INSTANCE.getDefaultOSVersion().orElse("")));
			if(enableMMUAwareness != null) {
				enableMMUAwareness.setSelection(configuration.getAttribute(ConfigurationAttributes.MMU_AWARENESS_CHECK,
						DefaultPreferences.DEFAULT_MMU_AWARENESS_CHECK));
			}
			rtosScriptLocation.setText(configuration.getAttribute(ConfigurationAttributes.RTOS_SCRIPT_LOCATION,
					""));
		} catch (CoreException e) {
			Activator.log(e);
		}

	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		if (rtosDebugging.getSelection() && customConfiguration.getSelection()) {
			if (!rtosScriptLocation.getText().isEmpty()) {
				File f = new File(rtosScriptLocation.getText());
				if (f.exists())
				{
					return true;
				}
			}
			setErrorMessage("Script location is not valid");
			return false;
		}
		return super.isValid(launchConfig);
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConfigurationAttributes.RTOS_DEBUG, rtosDebugging.getSelection());
		configuration.setAttribute(ConfigurationAttributes.RTOS_CUSTOM, customConfiguration.getSelection());
		configuration.setAttribute(ConfigurationAttributes.RTOS_SCRIPT_LOCATION, rtosScriptLocation.getText());
		configuration.setAttribute(ConfigurationAttributes.RTOS_TYPE, rtosTypeCombo.getText());
		configuration.setAttribute(ConfigurationAttributes.RTOS_VERSION, rtosVersionCombo.getText());
		if(enableMMUAwareness != null) {
			configuration.setAttribute(ConfigurationAttributes.MMU_AWARENESS_CHECK, enableMMUAwareness.getSelection());
		}
	}

	@Override
	public String getName() {
		return TAB_NAME;
	}

	@Override
	public String getId() {
		return TAB_ID;
	}

	@Override
	public Image getImage() {
		if (null == TAB_IMAGE) {
			TAB_IMAGE = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/osawareness_tabview.gif")
					.createImage();
		}
		return TAB_IMAGE;
	}

}
