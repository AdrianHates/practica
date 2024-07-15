# Etapa de compilación
FROM maven:3.8.4-jdk-22 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package

# Etapa de producción
FROM openjdk:22-jre-slim
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]