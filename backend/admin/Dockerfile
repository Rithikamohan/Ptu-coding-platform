FROM openjdk:17-oracle
COPY target/Admin-0.0.1-SNAPSHOT.jar admin.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","admin.jar"]
#
# Build stage
#
#FROM maven:3.8.2-jdk-11 AS build
#COPY . .
#RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
#FROM openjdk:11-jdk-slim
#COPY --from=build /target/Student-0.0.1-SNAPSHOT.jar studentms.jar
# ENV PORT=8080
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","studentms.jar"]