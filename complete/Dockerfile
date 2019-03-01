FROM openjdk:8-jdk-alpine 
RUN apk --no-cache add curl
COPY build/libs/*.jar mn-gatlin.jar
CMD java ${JAVA_OPTS} -jar mn-gatlin.jar