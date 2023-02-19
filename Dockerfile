FROM alpine:3.15.4

RUN apk update && \
    apk upgrade

RUN apk add openjdk8

EXPOSE 8080

ADD target/musixApp.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]