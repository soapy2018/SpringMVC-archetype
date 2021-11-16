FROM docker.nb.bluetron.cn/library/openjdk:8-jdk-alpine-bluetron
ENV TZ Asia/Shanghai
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-cp","app:app/lib/*", "com.bluetron.app.${rootArtifactId}-service.AppServiceApplication"]
