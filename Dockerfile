FROM openjdk:8 
ADD target/pixo-server.jar pixo-server.jar 
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "pixo-server.jar"]