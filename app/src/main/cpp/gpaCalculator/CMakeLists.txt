cmake_minimum_required(VERSION 3.10.2)

include_directories("${CMAKE_SOURCE_DIR}/gpaCalculator/include")

add_library(gpaCalc
             SHARED
             src/GPACalculator.cpp)