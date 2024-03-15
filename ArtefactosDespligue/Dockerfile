FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY applications/app-service/build/libs/*.jar Servicio.jar
ENV JAVA_OPTS=" -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar Servicio.jar --server.port=8092" ]
