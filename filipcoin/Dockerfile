# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from your local machine to the container
COPY target/filipcoin-1.0-SNAPSHOT.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
