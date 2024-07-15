FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/receipt-service-0.0.1-SNAPSHOT.jar receipt-service.jar
ENTRYPOINT ["java", "-jar", "/receipt-service.jar"]
