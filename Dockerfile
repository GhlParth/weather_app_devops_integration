FROM maven:3.8-openjdk-11-slim

WORKDIR /app

# In development, we don't copy the source code or build the jar inside the image.
# Instead, we will mount the source code as a volume in docker-compose.yml .
# and use Maven to run the application with hot-reloading enabled.

CMD ["mvn", "spring-boot:run"]