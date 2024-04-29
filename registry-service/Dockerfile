FROM openjdk:17
EXPOSE 8761
ADD target/registry-service.jar registry-service.jar
ENTRYPOINT ["java","-jar","/registry-service.jar"]