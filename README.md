# API de Pagamentos

Este projeto é uma API de pagamentos construída em Java com SDK 17, utilizando o framework Spring Boot. O banco de dados utilizado é o H2 e a aplicação pode ser executada em um container Docker.

## Pré-requisitos
- Java SDK 17
- Maven
- Docker

## Motivação e Escolha do Spring Boot

A escolha do Spring Boot foi feita devido à sua robustez, facilidade de configuração e grande ecossistema de suporte. O Spring Boot oferece uma série de recursos prontos para uso, como o Spring Data JPA para acesso a dados, o Spring MVC para criação de APIs RESTful, e a integração perfeita com outras ferramentas Spring. Além disso, o Spring Boot simplifica a configuração do ambiente de desenvolvimento e produção, facilitando o processo de implantação da aplicação.

## Arquitetura

O projeto segue uma arquitetura de camadas, onde cada componente desempenha um papel específico:

- **Controller**: Responsável por expor os serviços através de uma API JSON REST. Os controladores recebem as requisições HTTP, delegam o processamento para os serviços e retornam as respostas adequadas.

- **Service**: Camada responsável por conter a lógica de negócio da aplicação. Aqui, são implementadas as regras de negócio e a lógica para manipulação dos dados. Os serviços se comunicam com os repositórios para persistir ou recuperar dados.

- **Repository**: Responsável por fornecer uma abstração sobre o acesso a dados. Utilizando recursos do Spring Data JPA, os repositórios facilitam a interação com o banco de dados, oferecendo métodos para realizar operações CRUD de forma simples e eficiente.

Essa arquitetura permite uma separação clara das responsabilidades e facilita a manutenção, testabilidade e escalabilidade do sistema.

## Dependências

### spring-boot-starter-data-jpa
Esta dependência fornece um conjunto de bibliotecas para integrar o Spring Boot com o Spring Data JPA. O Spring Data JPA simplifica a implementação de repositórios de dados baseados em JPA, permitindo a criação de consultas CRUD de forma simples e eficiente.

### spring-boot-starter-validation
Esta dependência adiciona suporte para validação de entrada nos controladores da aplicação. O Spring Boot Starter Validation utiliza o mecanismo de validação do Bean Validation para verificar a validade dos dados de entrada antes de processá-los.

### spring-boot-starter-web
Esta dependência fornece um conjunto de bibliotecas para criar aplicativos da web com o Spring Boot. Inclui o Spring MVC, que é o framework web principal do Spring, e outras bibliotecas relacionadas para lidar com solicitações HTTP, respostas, conversão de dados, etc.

### spring-boot-devtools
Esta dependência é uma ferramenta de desenvolvimento do Spring Boot que permite a reinicialização automática da aplicação quando os arquivos de código são alterados. Isso ajuda a acelerar o ciclo de desenvolvimento, eliminando a necessidade de reiniciar manualmente o servidor.

### spring-boot-starter-hateoas
Esta dependência adiciona suporte para HATEOAS (Hypertext As The Engine Of Application State) aos aplicativos Spring Boot. O HATEOAS é um estilo de arquitetura de API que fornece links hipermídia para navegar pelos recursos da API de forma dinâmica.

### springdoc-openapi-starter-webmvc-ui
Esta dependência adiciona suporte para a geração automática de documentação da API usando o OpenAPI (anteriormente conhecido como Swagger). Ele fornece uma interface web interativa (Swagger UI) para explorar e testar os endpoints da API.

### h2
Esta dependência é o banco de dados H2, que é um banco de dados relacional em memória. Ele é usado principalmente para desenvolvimento e testes, pois não requer configuração de banco de dados externo e pode ser facilmente integrado a aplicativos Spring Boot.

### spring-boot-starter-test
Esta dependência fornece um conjunto de bibliotecas para escrever e executar testes unitários e de integração em aplicativos Spring Boot. Inclui suporte para JUnit, Mockito e outras bibliotecas populares de teste.

### annotations (org.jetbrains)
Esta dependência fornece as anotações do IntelliJ IDEA para uso no código-fonte. Embora seja uma dependência opcional, as anotações do IntelliJ IDEA podem ser úteis para melhorar a compatibilidade do código-fonte com o IDE IntelliJ IDEA.

## Como executar
1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando `mvn clean package` para compilar o projeto e gerar o arquivo .jar
4. Execute o comando `docker build -t payments-spring-app .` para criar a imagem Docker
5. Execute o comando `docker run -p 8080:8080 payments-spring-app` para iniciar a aplicação

## Testes Unitários
Foram criados testes unitários para garantir a qualidade do código. Para executar os testes, utilize o comando `mvn test`.

## Endpoints
- POST   `/api/integrated_systems`: Cria um novo Sistema Integrado
- POST   `/api/pagamentos`: Cria um novo pagamento
- GET    `/api/pagamentos`: Retorna todos os pagamentos
- GET    `/api/pagamentos?statusPayment=A`: Retorna os pagamentos de acordo com o parametro passado para statusPayments onde que A pode ser TODOS, AGENDADO ou EFETUADO
- GET    `/api/pagamentos/{id}`: Retorna um pagamento específico pelo ID
- DELETE `/api/pagamentos/{id}`: Deleta um pagamento específico pelo ID
- PUT    `/api/pagamentos/{id}`: Edita um pagamento específico pelo ID
- PATCH  `/api/pagamentos/{id}`: Edita parcialmente um pagamento específico pelo ID
- GET    `/api/systems_notification/{id}`: Fornece informações de INCLUSAO, ALTERACAO ou EXCLUSAO de pagamentos por Sistema Integrado

## Documentação da API
A documentação da API pode ser acessada em `http://localhost:8080/swagger-ui.html`
