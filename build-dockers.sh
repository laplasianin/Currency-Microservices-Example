#!/usr/bin/env bash
cd currency-config-server
docker build -t config-server .
cd ../currency-service-discovery
docker build -t service-discovery .
cd ../currency-api-gateway
docker build -t api-gateway .
cd ../currency-web
docker build -t currency-web .
cd ../currency-data
docker build -t currency-data .
cd ../currency
docker build -t currency-back .