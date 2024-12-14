FROM openjdk:17
COPY fandom-0.0.1-SNAPSHOT.jar fans.jar
ENTRYPOINT ["java", "-jar", "/fans.jar"]
