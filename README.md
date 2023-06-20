# Transaction Service

O Transaction Service é responsável pelo histórico de transações financeiras.

## Descrição

O Transaction Service é um microserviço independente que oferece funcionalidades de criação, consulta e processamento de transações financeiras.

## Requisitos do Sistema

- Java 17: [Instalar Java 17](https://www.oracle.com/java/technologies/downloads/)
- Maven: [Instalar Maven](https://maven.apache.org/install.html)
- Docker: [Instalar Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Instalar Docker Compose](https://docs.docker.com/compose/install/)

Certifique-se de ter os requisitos acima instalados e configurados corretamente em seu ambiente.

## Integrações

O Transaction Service se integra com os seguintes serviços:

- Account Management Service: responsável pelo gerenciamento de contas de usuários.
- Payment Service: responsável pelo processamento de pagamentos e recebimentos.

## Construindo o Projeto

Para construir o microserviço Transaction, siga as etapas abaixo:

1. Certifique-se de ter o Java 17 e o Maven instalados e configurados corretamente em seu ambiente.
2. Navegue até a raiz do projeto.
3. Execute o seguinte comando para construir o projeto:

   ```bash
   mvn clean package
   ```

    ```bash
   docker build -t transaction-management .
   ```

## Documentação do Swagger

A documentação do Swagger para o Transaction Service pode ser encontrada em [http://localhost/transaction/swagger-ui.html](http://localhost/transaction/swagger-ui.html). Certifique-se de que o serviço esteja em execução para acessar a documentação.

## Funcionalidades Principais

- Criação de novas transações financeiras.
- Consulta de transações por número de conta.
- Processamento de transações financeiras.

## Exemplos de Uso (Curl)

Aqui estão alguns exemplos de como usar as funcionalidades do Transaction Service com CURL:

- Consultar transações:

  ```bash
  curl -X GET "http://localhost/transaction/api/transactions?accountNumber=d5fe117d-8fa9-49b8-80bd-fb7b509847b6&pageNumber=0&size=4" -H "accept: */*"
  ```
