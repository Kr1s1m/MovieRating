FROM ubuntu:latest
LABEL authors="Kardam"

# --- Build stage ---
FROM eclipse-temurin:11-jdk-alpine AS build
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Fix line endings for Linux just in case the wrapper was saved on Windows
RUN sed -i 's/\r$//' mvnw
RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B
COPY src ./src
RUN ./mvnw clean package -DskipTests

# --- Run stage ---
FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]