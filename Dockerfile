FROM openjdk:8-jdk-alpine
LABEL maintainer="retoBCP"
ENV spring.application.name api-tipo-cambio-v1
COPY build/libs/api-tipo-cambio-*SNAPSHOT.jar /opt/api-tipo-cambio.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/api-tipo-cambio.jar"]