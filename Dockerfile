# ============================
# 1. Build Stage
# ============================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cache optimized)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the full project and build the jar
COPY . .
RUN mvn clean package -DskipTests

# ============================
# 2. Run Stage
# ============================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (Render ignores it but useful)
EXPOSE 8080

# Use Render's dynamic PORT
ENV PORT=8080

# Start app
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
