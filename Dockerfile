FROM openjdk:19-jdk-alpine3.16

COPY app/ /project
WORKDIR /project

RUN apk --no-cache --upgrade add \
    curl \
    bash \
    build-base \
    python3 \
    alpine-sdk


CMD ["/bin/bash"]