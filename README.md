# API de Pagamentos

Este projeto é uma API de pagamentos construída em Java com SDK 17, utilizando o framework Spring Boot. O banco de dados utilizado é o H2 e a aplicação pode ser executada em um container Docker.

## Pré-requisitos
- Java SDK 17
- Maven
- Docker

## Como executar
1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando `mvn clean package` para compilar o projeto e gerar o arquivo .jar
4. Execute o comando `docker build -t payments-spring-app .` para criar a imagem Docker
5. Execute o comando `docker run -p 8080:8080 payments-spring-app` para iniciar a aplicação

## Testes Unitários
Foram criados testes unitários para garantir a qualidade do código. Para executar os testes, utilize o comando `mvn test`.

## Endpoints
- GET    `/api/pagamentos`: Retorna todos os pagamentos
- GET    `/api/pagamentos/{id}`: Retorna um pagamento específico pelo ID
- POST   `/api/pagamentos`: Cria um novo pagamento
- DELETE `/api/pagamentos/{id}`: Deleta um pagamento específico pelo ID
- PUT    `/api/pagamentos/{id}`: Edita um pagamento específico pelo ID

## Documentação da API
A documentação da API pode ser acessada em `http://localhost:8080/swagger-ui.html`