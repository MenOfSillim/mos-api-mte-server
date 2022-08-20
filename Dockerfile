FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV	USE_PROFILE prod
ENTRYPOINT ["java", "-Dspring.profiles.active=${USE_PROFILE}", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

