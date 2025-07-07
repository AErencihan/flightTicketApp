#FROM maven:3.8.4-openjdk-17-slim AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#
#RUN mvn -B clean install -DskipTests
#
#
#FROM openjdk:17 AS runtime
#WORKDIR /app
#COPY --from=build /app/target/flightTicketApp-0.0.1-SNAPSHOT.jar .
#
#CMD ["java", "-jar", "flightTicketApp-0.0.1-SNAPSHOT.jar"]



FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
# Bağımlılıkları önceden indir
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean install -DskipTests

FROM openjdk:17-slim AS runtime
WORKDIR /app
COPY --from=build /app/target/flightTicketApp-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "flightTicketApp-0.0.1-SNAPSHOT.jar"]