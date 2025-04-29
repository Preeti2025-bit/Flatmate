FROM --platform=arm64 openjdk:17-jdk-slim
WORKDIR /app
COPY /Applications/SpringProject/com/target/com-0.0.1-SNAPSHOT.jar.original /app
EXPOSE 3306
ENTRYPOINT [ "java","-jar","app.jar" ]