FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/SCT-2.0.war sct.war
ENTRYPOINT ["java","-jar","/sct.war"]