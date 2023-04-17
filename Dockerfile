## Based on https://community.render.com/t/3232

# Build stage
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY CD_app/src /home/app/src
COPY CD_app/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/CD_app-0.0.1-SNAPSHOT.jar /usr/local/lib/pkg.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/pkg.jar"]
