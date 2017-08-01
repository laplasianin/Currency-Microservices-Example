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
/Users/ilalebeduk/Documents/Programs/grails-3.3.0/bin/grails package . -DskipTests
cd ../currency-data
/Users/ilalebeduk/Documents/Programs/grails-3.3.0/bin/grails package . -DskipTests
cd ../currency
/Users/ilalebeduk/Documents/Programs/grails-3.3.0/bin/grails package . -DskipTests