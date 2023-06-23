#!/bin/bash

find . -name "*.java" -exec javac -d ../bin {} +

jar cvfm HotelAdministratorTest.jar Manifest.txt -C ../bin .
