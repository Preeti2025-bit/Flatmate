FROM --platform=arm64 openjdk:17-jdk-slim
WORKDIR /app
COPY target/com-0.0.1-SNAPSHOT.jar.original /app
EXPOSE 3306
ENTRYPOINT [ "java","-jar","app.jar" ]
# Use OpenJDK 17 base image
# FROM openjdk:17-jdk-slim

# # Set the working directory inside the container
# WORKDIR /app

# # Copy the built JAR file into the container
# COPY target/com-0.0.1-SNAPSHOT.jar /app/app.jar

# # Expose port if needed (not mandatory unless you're running on a port)
# EXPOSE 8080

# # Command to run the app
# ENTRYPOINT ["java", "-jar", "app.jar"]
