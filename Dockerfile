FROM alpine:3.15.4

RUN apk update && \
    apk upgrade
RUN apk add openjdk8

EXPOSE 8080
