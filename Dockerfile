FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY target/BookStoreApplication.jar /app/BookStoreApplication.jar

CMD ["java", "-jar", "BookStoreApplication.jar"]