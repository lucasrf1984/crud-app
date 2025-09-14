FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/java-crud-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
