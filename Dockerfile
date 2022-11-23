FROM openjdk:8
MAINTAINER zhangzhe
WORKDIR /
ADD target/truck-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
