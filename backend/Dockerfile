FROM gradle:6.4.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src/backend
RUN gradle build --no-daemon

FROM openjdk:11.0.7-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/backend/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
