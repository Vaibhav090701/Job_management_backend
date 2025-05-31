# Use Eclipse Temurin JDK 17 (compatible with Spring Boot 3.x, lightweight Alpine variant)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target directory (Maven output)
COPY target/*.jar app.jar

# Expose the port (Render assigns dynamically via PORT env variable, default 8080 locally)
EXPOSE ${PORT:8080}

# Run the Spring Boot JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]