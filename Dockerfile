# Use a base image with Java pre-installed
# FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
# WORKDIR /app

# Copy the compiled JAR file into the container at /app
# COPY target/demo-0.0.1-SNAPSHOT.jar /app/BookstoreApplication.jar

# Expose the port your application runs on
# EXPOSE 8080

# Specify the command to run your application
# CMD ["java", "-jar", "BookstoreApplication.jar"]


FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests 

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar bookstore.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "bookstore.jar" ]