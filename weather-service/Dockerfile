FROM amazoncorretto:11

# For amazoncorretto:11-alpine --> Doesn't work with Mac M1 chip
#RUN apk -U upgrade && \
#    echo http://dl-2.alpinelinux.org/alpine/edge/community/ >> /etc/apk/repositories && \
#    RUN apk --no-cache add shadow &&  \
#    addgroup -S docker && \
#    adduser -S app_user -G docker

RUN yum -y update && \
    yum install -y shadow-utils && \
    yum clean all && \
    groupadd docker && \
    adduser app_user -G docker

USER app_user:docker

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

COPY ./scripts/wait-for-it.sh ./

ENTRYPOINT [ "sh", "-c", "./wait-for-it.sh $DISCOVERY_HOST:8761 -- java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]