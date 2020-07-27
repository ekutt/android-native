Android Native Wrapper for C++ Library 
==============================================
Android application project.
The aim of this project is to show how to create Android wrapper for a C++ library and use it in Android application.
Application in this project calculates GPAs based on hard-coded student data. It uses Java code as UI functionality provider and native C++ code for GPA calculation. 

#### Current project status
 ![.github/workflows/build.yml](https://github.com/ekutt/android-native/workflows/.github/workflows/build.yml/badge.svg?branch=master) 

## Building 
### Requirements
- Android NDK r21d
- Android SDK
- Android SDK Build tools 30.0.0
- CMake 3.10.2

Edit 'buildToolsVersion' in 'build.gradle' files if necessary.

Clone this project and create local.properties file under project root directory.
Add the following properties to local.properties file with directory information where you installed Android sdk and ndk:

	sdk.dir=<SDK_INSTALL_DIR>
	ndk.dir=<NDK_INSTALL_DIR>

#### Building The Project

The project is in Gradle project format. There are numerous ways you can build the project: 
- Open the project in Android Studio and run build.
- Alternatively, you can open the terminal under project root directory and run the following 
command:

	./gradlew build 
	
- Image converter application uses libgpaCalc-jni.so and libgpaCalc.so libraries:

Since libgpaCalc-jni.so and libgpaCalc.so builds are added as an external native build to the project, Gradle deals with deploying them into final apk.
Native dependencies and their linkage are as follows: 

![alt text](https://github.com/ekutt/android-native/blob/assets/assets/1_n3BrKUuWgLjmgr6l763nOg.png)	

##### More Information
For more information, you can check the blog here: https://medium.com/@emrekutt/implementing-an-android-wrapper-for-a-c-library-db932bcbc83d

