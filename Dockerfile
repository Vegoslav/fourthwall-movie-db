FROM openjdk:11.0.14.1-oracle
ARG JAR_FILE=./target/movie-db.jar
COPY ${JAR_FILE} movie-db.jar
ENTRYPOINT ["java","-jar","/movie-db.jar"]