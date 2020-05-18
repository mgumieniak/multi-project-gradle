FROM openjdk:13-alpine
ADD ["build/libs/product-service-1.0.jar", "app.jar"]
EXPOSE 8000
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["sh", "-c","java -Dspring.profiles.active=docker -jar app.jar"]
