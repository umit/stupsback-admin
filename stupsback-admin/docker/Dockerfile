FROM zalando/openjdk:8u45-b14-5

MAINTAINER Zalando SE

CMD java $(java-dynamic-memory-opts) -jar /stupsback-admin.jar

COPY scm-source.json /
COPY ${project.build.finalName}.jar /stupsback-admin.jar