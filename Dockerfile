FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/Kameleoon.jar
WORKDIR /opt/app
COPY ${JAR_FILE} kameleoon.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","kameleoon.jar"]


