#!/usr/bin/env bash
cd currency-config-server
mvn clean
mvn package -DskipTests
cd ../currency-service-discovery
mvn clean
mvn package -DskipTests
cd ../currency-api-gateway
mvn clean
mvn package -DskipTests
cd ../currency-web
grails package . -DskipTests
cd ../currency-data
grails package . -DskipTests
cd ../currency
grails package . -DskipTests