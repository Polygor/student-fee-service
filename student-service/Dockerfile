FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/student-service-0.0.1-SNAPSHOT.jar student-service.jar
ENTRYPOINT ["java", "-jar", "/student-service.jar"]
