# Use a base image with Java pre-installed
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/BookstoreApplication*.jar /app/BookstoreApplication.jar

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "BookstoreApplication.jar"]