FROM openjdk:8
COPY ./ /tmp
WORKDIR /tmp
RUN ./export.sh -v src/main/java/resources/config.xml
