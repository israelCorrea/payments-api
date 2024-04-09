# Define a imagem base do Java
FROM openjdk:17-jdk-alpine

# Define o diretorio de trabalho no container
WORKDIR /app

# Copia o arquivo JAR do projeto para o container
COPY target/payments-0.0.1-SNAPSHOT.jar /app/payments-spring-app.jar

# Define o comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "payments-spring-app.jar"]