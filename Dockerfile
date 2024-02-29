FROM openjdk:17-jdk-slim

LABEL maintainer="Ngor SECK"

EXPOSE 8080

RUN mkdir -p /app/data

ADD target/product-service.jar product-service.jar

ENTRYPOINT ["java", "-jar", "product-service.jar"]