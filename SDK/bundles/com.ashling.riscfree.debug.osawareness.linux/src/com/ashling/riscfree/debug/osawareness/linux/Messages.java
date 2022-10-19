package com.ashling.riscfree.debug.osawareness.linux;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ashling.riscfree.debug.osawareness.linux.messages"; //$NON-NLS-1$
	public static String Process_name;
	public static String Module_name;
	public static String Load_symbols_of_module;
	public static String Debug_module_from_init;
	public static String Rootfs_dir;
	public static String Load_symbols_for_process;
	public static String Debug_process_from_main;
	public static String Debug_process_from_main_with_dots;
	public static String Shared_lib_paths;
	public static String Browse_with_dots;
	public static String Browse;
	public static String Debug;
	public static String Error;
	public static String Watch;
	public static String Module_symbol_file;
	public static String Module_name_without_ko;
	public static String Share_Library;
	public static String Add;
	public static String Remove;
	public static String Insert_the_module;
	public static String Press_ok_and_insert_module_via_console;
	public static String Couldnt_obtain_valid_debug_context;
	public static String Debug_module_from_init_with_dots;
	public static String Wait_for_module_insertion_from_console_with_dots;
	public static String Target_continue_failed_with_error_message;
	public static String Adding_symbol_info_of_module_with_dots;
	public static String Adding_symbol_sections_failed;
	public static String Run_to_init_with_dots;
	public static String Eval_of_init_addr_failed;
	public static String Run_the_process;
	public static String Press_ok_and_run_process_from_console;
	public static String Running_to_main_with_dots;
	public static String Setting_shared_library_path_with_dots;
	public static String Waiting_for_process_execution_from_console_with_dots;
	public static String Debug_context_not_suspended;
	public static String Selected_debug_context_not_suspended;
	public static String No_active_linux_aware_debugging;
	public static String Selected_context_not_part_of_linux_aware_debugging;
	public static String Target_continue_command_failed;
	public static String Setting_breakpoint_at_location_failed;
	public static String Load_module_symbol;
	public static String Failed_to_load_module_symbol;
	public static String Load_process_symbol;
	public static String Failed_to_load_process_symbol;
	public static String Debug_already_running_process_path;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
