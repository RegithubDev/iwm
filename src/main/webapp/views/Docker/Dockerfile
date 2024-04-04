# Use a base image with Java 17
FROM adoptopenjdk:17-jdk-hotspot AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./sr
# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image with Java 17
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the built WAR file from the previous stage
COPY --from=build /app/target/iris.war .

# Expose the port your Spring MVC application runs on (default is 8080)
EXPOSE 8080

# Specify the command to run your Spring MVC application
CMD ["java", "-jar", "iris.war"]
