FROM openjdk:19-jdk-alpine
COPY target/ordercriteria.jar .
CMD ["java", "-jar", "ordercriteria.jar"]