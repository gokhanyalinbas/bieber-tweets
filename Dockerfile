FROM openjdk:8
ADD target/java-exercise.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]