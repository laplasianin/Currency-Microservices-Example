FROM java:8
ADD build/libs/currency-0.1.war currency-back.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/currency-back.war"]