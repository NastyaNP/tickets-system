FROM maven:3.9.6-eclipse-temurin-21-alpine as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM jyckbase/java21
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "/app/*.jar"]
