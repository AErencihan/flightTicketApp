#FROM maven:3.8.4-openjdk-17-slim AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
##RUN mvn clean install -DskipTests
## Build aşamasında
#RUN --mount=type=cache,target=/root/.m2 mvn clean install -DskipTests
#
#FROM openjdk:17 AS runtime
#WORKDIR /app
#COPY --from=build /app/target/flightTicketApp-0.0.1-SNAPSHOT.jar .
#CMD ["java", "-jar", "flightTicketApp-0.0.1-SNAPSHOT.jar"]



FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean install -DskipTests -B

FROM openjdk:17 AS runtime
WORKDIR /app
COPY --from=build /app/target/flightTicketApp-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "flightTicketApp-0.0.1-SNAPSHOT.jar"]
