FROM centos:7
ENV RELEASE_PATH target/api-swarm.jar
RUN yum install -y \
    java-1.8.0-openjdk-headless \
  && yum clean all

WORKDIR /opt/api

ADD ${RELEASE_PATH} /opt/api

RUN groupadd -r duser -g 1001 \
    && useradd -u 1001 -r -g duser -d /opt/api/ -s /sbin/nologin -c "Docker image user" duser \
    && chown -R duser:duser /opt/api/ \
    && chgrp -R 0 /opt/api && chmod -R g=u /opt/api

USER 1001


EXPOSE 8080

ENV PORT_OFFSET=0
ENV LOGGING_LEVEL=INFO

CMD java -jar /opt/api/api-swarm.jar \
    -Dswarm.port.offset=${PORT_OFFSET} \
    -Dswarm.logging=${LOGGING_LEVEL}
