cmake_minimum_required(VERSION 3.21)
project(Box)

set(CMAKE_CXX_STANDARD 14)

add_executable(Box BoxX.h Box.cpp Container.cpp Container.h main.cpp)
