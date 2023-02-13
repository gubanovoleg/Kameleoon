FROM openjdk:18-jdk-alpine
COPY target/Kameleoon.jar /kameleoon.jar
CMD ["java","-jar","/kameleoon.jar"]



