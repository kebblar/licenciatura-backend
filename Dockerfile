FROM maven:3.5-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app
COPY settings.xml /usr/src/app
USER root
RUN mvn -f /usr/src/app/pom.xml --settings /usr/src/app/settings.xml clean package -Dmaven.test.skip

FROM gcr.io/distroless/java  
COPY --from=build /usr/src/app/target/backend-0.0.1-SNAPSHOT.jar /usr/app/backend-0.0.1-SNAPSHOT.jar  
EXPOSE 443  
ENTRYPOINT ["java","-jar","/usr/app/backend-0.0.1-SNAPSHOT.jar"]  
