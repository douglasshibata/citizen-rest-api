# Build stage
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /builder

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /application

COPY --from=build /builder/target/*.jar ./application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]
