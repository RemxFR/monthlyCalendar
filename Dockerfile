
FROM eclipse-temurin:8-jdk-jammy

WORKDIR /monthlyCalendar

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]