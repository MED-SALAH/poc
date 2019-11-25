#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine as build

# Set the current working directory inside the image
WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
ARG DEPENDENCY=/app/target/dependency

ENTRYPOINT ["java","-jar","demo.jar","com.presentation.demo.DemoApplication"]

#java -cp lib/* com.presentation.demo.DemoApplication
#java -jar ////my.jar com.presentation.demo.DemoApplication