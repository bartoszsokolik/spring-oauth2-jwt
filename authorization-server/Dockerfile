FROM openjdk:11-jre-slim
ADD ./authorization-server/target/authorization-server.jar authorization-server.jar
ENTRYPOINT ["java", "-jar", "authorization-server.jar"]
