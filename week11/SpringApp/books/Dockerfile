FROM openjdk:17-alpine
ARG FILE_NAME=target/books-0.0.1-SNAPSHOT.jar
ADD ${FILE_NAME} bookstore.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bookstore.jar"]