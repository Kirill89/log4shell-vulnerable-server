FROM openjdk:8u111

WORKDIR /server

COPY gradle /server/gradle/
COPY gradlew /server/
COPY settings.gradle /server/

RUN ./gradlew
COPY app /server/app/
RUN ./gradlew check

EXPOSE 8000
CMD ./gradlew run
