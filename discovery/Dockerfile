FROM amazoncorretto:11

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

ENTRYPOINT ["java","-jar","/app.jar"]