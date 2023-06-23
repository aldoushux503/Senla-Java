#!/bin/bash

find src/com/example/hotel -name "*.java" -exec javac -d bin {} +

jar cvfm HotelAdministratorTest.jar resources/Manifest.txt -C bin .