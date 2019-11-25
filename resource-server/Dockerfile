FROM openjdk:11-jre-slim
ADD ./resource-server/target/resource-server.jar resource-server.jar
ENTRYPOINT ["java", "-jar", "resource-server.jar"]
