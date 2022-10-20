<img src="https://www.openhwgroup.org/images/openhw-landscape.svg" width="418px" height="103px" /> <img src="https://www.openhwgroup.org/images/core-v-portrait.png" align="right" width="150px" height="120px"/>

# CORE-V-SDK Quick Start Guide
The purpose of this Quick Start Guide (QSG) is to get you up and running quickly with the CORE-V-SDK on one of the various supported operating system platforms.
Currently supported OSs are Windows (10/11) and Linux (RH 7.9/8.4 & Ubuntu 18.04/20.04). Note: only the x86 architecture is supported (Arm is not supported).

# Getting Started
Download the CORE-V SDK package ([64-bit Windows](http://downloads.openhwgroup.org/) /[64-bit Linux](http://downloads.openhwgroup.org/))

## Windows Installation
Run the supplied installer executable and follow the installation wizard to install CORE-V-SDK in the directory of your choice. Installation includes all 
the necessary toolchain components, and the default directory is:
~~~
C:\Users\[USER]\AppData\Local\OpenHW\CORE-V-SDKvX.Y.Z
~~~
where X.Y.Z is the version.
## Linux Installation
CORE-V-SDK Linux installer is provided as a .run file. Add execution permission to the file using the command:
~~~
chmod +rwx CORE-V-SDK_SetupvX.Y.Z.run
~~~
Execute this .run file and follow the instructions.
~~~
$./CORE-V-SDKSetupvX.Y.Z.run
~~~
 Installation includes all the necessary components, and the default directory is: 
~~~ 
 /home/username/OpenHW/CORE-V-SDKvX.Y.Z/
~~~

### Import Sample Project
To import and run the sample cli-test project or qemu_32_example provided with the SDK 

#### Step 1: Launch IDE
~~~
Launch the CORE-V-SDK by double clicking on the "CORE-V-SDK" shortcut in Windows or "CORE-V-SDK.launch" in Linux (from the installation location).
~~~
![image](https://user-images.githubusercontent.com/69203453/166261343-412d61b7-6b86-41ac-9e07-bd2a5b25338d.png)


#### Step 2: From Welcome, Select Import

![image](https://user-images.githubusercontent.com/69203453/166261646-2730ab0d-79c3-4cfe-983b-a15dc8497ca5.png)

#### Step 3: Select OpenHW Sample Projects

![image](https://user-images.githubusercontent.com/69203453/165941846-1476e590-fc4d-4ffe-bb98-eff27eda7c39.png)

#### Step 4: Select the Example Projects 

![image](https://user-images.githubusercontent.com/69203453/165941926-c93e3689-a374-4301-8ba4-70a2276474d5.png)

#### Step 5: Compile Projects

Assuming everything above has completed this step is simplicity itself. With the corresponding project selected in the Project Explorer pane, click on Build (the hammer icon):

![image](https://user-images.githubusercontent.com/69203453/166262302-143bb245-61b6-4817-8107-9307ebd743fd.png)

#### Step 6: Debug Configurations

Under the `Run` menu select `Debug Configurations...`

![image](https://user-images.githubusercontent.com/69203453/166262803-49f91f14-3879-477e-a59e-49147fa6b94d.png)

#### Step 7: Debug the Project 
1. Under `GDB OpenOCD Debugging` select `cli_test Ashling Opella-LD` or `cli_test hs2` and then `Debug`, or for QEMU:
2. Under `RISC-V QEMU Simulator Debugging` select `qemu_32_example` and then `Debug`

## How to Import Existing Projects from Git

![image](https://user-images.githubusercontent.com/69203453/166265280-5c0928d1-ba7c-492d-a06c-58182a3c7aa5.png)

#### Step 1: Specify Clone URI

![image](https://user-images.githubusercontent.com/69203453/165948885-bf7bc6e9-7709-4d16-ad50-c180618631d9.png)

#### Step 2: Specify the Source Git Repository

Provide the full URL path to the repository. The path you provide will depend on the protocol used to access GitHub. For example, https://github.com/openhwgroup/core-v-mcu-cli-test.git is the path when using https.

![git3](https://user-images.githubusercontent.com/69203453/165165294-4c94af14-0ce2-4bbd-9dba-41534adfffca.png)

#### Step 3: Select the Branch to Clone

Note: the list of branches will change over time.
The `main` branch is stable, but not necessarily the latest.
All other branches are development branches and may not be stable.

![image](https://user-images.githubusercontent.com/69203453/165950736-d3ee1604-ece6-4cf6-9a8f-279b4efab1b7.png)

#### Step 4: Specify Directory for Git to use (use the default)

![git5](https://user-images.githubusercontent.com/69203453/165166065-a4d8a265-c5b5-48d2-9486-58b0fec9c968.png)

#### Step 5: Select Projects to Import

![image](https://user-images.githubusercontent.com/69203453/166695499-76e08d86-8af1-4da4-b644-de6b37d2ee5d.png)


## Terminal window

CORE-V-SDK includes a built in Terminal Window (useful to run cli test). To open, 

~~~
Select Window -> Show View -> Other... -> search "Terminal"
~~~
![image](https://user-images.githubusercontent.com/69203453/165900959-1a0fe8e8-efa6-4ff5-9ad5-5ab02ce04a29.png)

Click on "Open a new Terminal View"

![terminal1](https://user-images.githubusercontent.com/69203453/165899755-676a18df-6f61-4c0c-ad9d-495639f9a38d.png)

Select "Local Terminal"

![image](https://user-images.githubusercontent.com/69203453/165900146-0d0714b3-af08-48f0-8a52-153027526a3f.png)

## CSR Register View

CORE-V-SDK supports Debugger Register View support for CSR Registers.To see the register view,

Browse the register file from the given location 

`C:\Users\[USER]\AppData\Local\OpenHW\CORE-V-SDKvX.Y.Z\registers\csr\gdb_reg_riscv_rv32.xml`

![image](https://user-images.githubusercontent.com/69203453/182455819-7a9372c1-069c-4838-8185-e60d7a6f7326.png)

To open the view, 
~~~
Select Window -> Show View -> Other... -> search "Registers"
~~~

![image](https://user-images.githubusercontent.com/69203453/182458391-e45da9f2-981b-417b-82ec-f2cdff7ddd32.png)

## FreeRTOS Task and Queue Views

CORE-V-SDK supports Debugger Task and Queue Views support for FreeRTOS projects.To see the views,

Go to the `OS Awareness` Tab, select "Enable OS Aware Debugging" and choose the "OS" and "Version"

![image](https://user-images.githubusercontent.com/69203453/196983401-c7ee6773-b4fd-4935-bfa2-1aacc84fa06e.png)

To open the view, 
~~~
Select Window -> Show View -> Other... -> search "FreeRTOS Task List"
~~~

or

~~~
Select Window -> Show View -> Other... -> search "FreeRTOS Queue List"
~~~

![image](https://user-images.githubusercontent.com/69203453/196985372-12d9c83c-58a6-4923-80fe-b2a11efd7806.png)


















