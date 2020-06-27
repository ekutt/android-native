cmake_minimum_required(VERSION 3.10.2)

include_directories(${CMAKE_SOURCE_DIR}/gpaCalculator/include)

add_library(gpaCalc-jni
             SHARED
             GPACalculator_jni.cpp)

add_library(GPALIB SHARED IMPORTED)
set_target_properties(GPALIB PROPERTIES IMPORTED_LOCATION "${CMAKE_LIBRARY_OUTPUT_DIRECTORY}/libgpaCalc.so")

target_link_libraries(gpaCalc-jni PUBLIC GPALIB)