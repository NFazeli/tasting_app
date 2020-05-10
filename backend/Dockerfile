FROM gradle:6.4.0-jdk11 AS build
COPY --chown=gradle:gradle ./backend/ /home/gradle/src/backend
WORKDIR /home/gradle/src/backend
RUN gradle build --no-daemon

FROM openjdk:11.0.7-slim
RUN apt-get update && apt-get install -y curl
RUN mkdir /app
COPY --from=build /home/gradle/src/backend/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
HEALTHCHECK --interval=5s --timeout=5s --retries=5 CMD curl --fail http://localhost:8080/actuator/health || exit 1
