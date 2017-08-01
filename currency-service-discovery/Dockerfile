FROM java:8
ADD target/discovery-service-0.0.1-SNAPSHOT.jar service-discovery.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-discovery.jar"]