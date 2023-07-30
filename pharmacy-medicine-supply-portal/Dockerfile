FROM openjdk:8-jdk-alpine
ADD target/authorization-service-0.0.1-SNAPSHOT.jar authorization-service-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT [ "java", "-jar", "/authorization-service-0.0.1-SNAPSHOT.jar" ]