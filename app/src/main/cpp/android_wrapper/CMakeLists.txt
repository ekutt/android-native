cmake_minimum_required(VERSION 3.10.2)

include_directories(${CMAKE_SOURCE_DIR}/gpaCalculator/include)

add_library(gpaCalc-jni
             SHARED
             GPACalculator_jni.cpp)

target_link_libraries(gpaCalc-jni PRIVATE gpaCalc)