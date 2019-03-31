# Start with a base image containing Java runtime
FROM arm32v7/openjdk:8

# Add Maintainer Info
LABEL maintainer="mathieu@ronvel.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Add the application's jar to the container
ADD target/farztev-backend-0.0.1.jar farztev-backend.jar

# Run the jar file 
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /farztev-backend.jar