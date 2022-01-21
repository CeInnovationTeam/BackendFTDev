FROM ghcr.io/graalvm/graalvm-ce:latest
WORKDIR /app
COPY . /app
EXPOSE 8081
CMD ["java","-javaagent:./oracle-apm-agent/bootstrap/ApmAgent.jar","-jar","./target/ftShopCart-0.0.1-SNAPSHOT.jar"]