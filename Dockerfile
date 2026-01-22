FROM eclipse-temurin:25-jre
LABEL authors="Porado"

RUN mkdr "/worduel"
RUN cd "/worduel"
COPY "" ""

ENTRYPOINT ["top", "-b"]