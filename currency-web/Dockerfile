FROM java:8
ADD build/libs/currency-web-0.1.war currency-web.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/currency-web.war"]