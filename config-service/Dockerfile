FROM openjdk:13
ADD build/libs/config-service-1.0.jar app.jar
EXPOSE 8888 8787
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","app.jar"]
