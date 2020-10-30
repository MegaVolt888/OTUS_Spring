FROM maven:3.6.3-jdk-11-slim as build
COPY . /home/megavolt/Documents/OTUS_Spring/HomeWorks/
RUN mvn -f /home/megavolt/Documents/OTUS_Spring/HomeWorks/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/megavolt/Documents/OTUS_Spring/HomeWorks/target/HomeWork*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]