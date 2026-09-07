# ==============================
# Stage 1: Build the application
# ==============================
FROM maven:3.9.9-amazoncorretto-21 AS build

WORKDIR /app

# Copy Maven configuration first
# This allows Docker to cache dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy application source
COPY src ./src

# Build Spring Boot application
RUN mvn clean package -DskipTests


# ==============================
# Stage 2: Run the application
# ==============================
FROM amazoncorretto:21-alpine

WORKDIR /app

# Copy only the generated JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Spring Boot application port
EXPOSE 8081

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
