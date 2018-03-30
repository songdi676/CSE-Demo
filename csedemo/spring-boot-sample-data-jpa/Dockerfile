FROM 100.125.0.198:20202/hwcse/dockerhub-java:8-jre-alpine

WORKDIR /home/apps/
ADD target/spring-boot-sample-data-jpa-0.0.1-SNAPSHOT.jar .
ADD target/lib ./lib
ADD start.sh .

ENTRYPOINT ["sh", "/home/apps/start.sh"]