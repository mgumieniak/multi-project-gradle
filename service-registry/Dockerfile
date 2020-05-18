FROM openjdk:13-alpine
ADD ["build/libs/service-registry-1.0.jar", "app.jar"]
EXPOSE 8761
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["sh", "-c","java -Dspring.profiles.active=docker -jar app.jar"]
