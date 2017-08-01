# Currency-Microservices-Example
![Image](https://github.com/laplasianin/Currency-Microservices-Example/blob/master/currency-architecture)

### How to buildand run with dockers:
1. ./build-services.sh
1. ./build-dockers.sh
1. ./docker-compose up

### Docker support is not finished yet and services are not able to discover each over so there is way to run it dockerless: 
1. ./build-services.sh
1. ./1-run-config-server.sh
1. ./2-run-service-discovery.sh
1. ./3-run-api-gateway.sh
1. ./4-run-currency-data.sh
1. ./5-run-currency-back.sh
1. ./6-run-currency-web.sh

![Image](https://github.com/laplasianin/Currency-Microservices-Example/blob/master/pics/table.png)
![Image](https://github.com/laplasianin/Currency-Microservices-Example/blob/master/pics/chart.png)
![Image](https://github.com/laplasianin/Currency-Microservices-Example/blob/master/pics/discoivery.png)
