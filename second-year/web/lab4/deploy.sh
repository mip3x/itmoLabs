#!/bin/bash

./gradlew clean build
cp ./build/libs/lab4.war ../wildfly/standalone/deployments/ROOT.war
