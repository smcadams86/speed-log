FROM openjdk:8-jre-alpine
VOLUME /tmp

RUN apk add --update curl python && \
    rm -rf /var/cache/apk/*
RUN mkdir -p /data/speed-log && chmod -R 777 /data/speed-log
RUN curl -o /usr/local/bin/jq -L https://github.com/stedolan/jq/releases/download/jq-1.5/jq-linux64 && \
  chmod +x /usr/local/bin/jq
RUN curl -Lo /data/speed-log/speedtest-cli https://raw.githubusercontent.com/sivel/speedtest-cli/master/speedtest.py && \
    chmod +x /data/speed-log/speedtest-cli
RUN echo '{"log": []}' > /data/speed-log/log.json
ADD speedtest.sh /data/speed-log/speedtest.sh

ADD speed-log-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
