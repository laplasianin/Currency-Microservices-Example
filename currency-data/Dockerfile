FROM java:8
ADD build/libs/currency-data-0.1.war currency-data.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/currency-data.war"]