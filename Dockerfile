# Use official Eclipse Temurin JDK 17 image
FROM eclipse-temurin:17

# Set working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY . /app

# Install Ant (using Debian package manager inside the container)
RUN apt-get update && apt-get install -y ant

# Build the project with Ant
RUN ant jar

# Default command: run the MyInfArith class using the jar
# Example: docker run myarith int add 123 456
ENTRYPOINT ["java", "-jar", "build/jar/arithmetic.jar"]
