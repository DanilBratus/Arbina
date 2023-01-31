FROM openjdk:11
COPY build/libs/ /libs
EXPOSE 8080
ENTRYPOINT ["java","-jar","libs/Arbina-1.0-SNAPSHOT.jar"]
