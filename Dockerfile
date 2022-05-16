FROM openjdk:17-jdk-alpine
LABEL maintainer="Henrique Santos"
COPY target/pipeline-demo-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]