FROM openjdk:17-alpine
ADD target/expense-app.jar expense-app.jar
EXPOSE 9090
ENTRYPOINT ["sh", "-c", "java -jar /expense-app.jar"]