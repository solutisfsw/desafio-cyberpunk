FROM java:8
VOLUME /tmp
ADD desafio.jar desafio.jar
RUN bash -c 'touch /desafio.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/desafio.jar"]