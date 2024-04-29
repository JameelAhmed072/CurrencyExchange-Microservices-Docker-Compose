FROM openjdk:17
EXPOSE 9092
ADD target/currency-conversion.jar currency-conversion.jar
ENTRYPOINT ["java","-jar","/currency-conversion.jar"]