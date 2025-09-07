
FROM gradle:8.7-jdk17 AS build
WORKDIR /home/gradle/project
COPY . .
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/finance-service-*.jar app.jar
EXPOSE 8084
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
