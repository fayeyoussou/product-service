FROM amazoncorretto:21-alpine3.19-jdk

#LABEL maintainer="Youssoupha"
#
#EXPOSE 8080
#
#RUN mkdir -p /app/data
#
## Add the wait-for-it script
#
#ADD target/product-service.jar product-service.jar
#
## Use the wait-for-it script to wait for MySQL before starting the application
##ENTRYPOINT [ "java", "-jar", "product-service.jar"]