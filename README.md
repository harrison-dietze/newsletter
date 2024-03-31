# Projeto Spring Boot - Newsletter

Este é um projeto Spring Boot que oferece uma API REST para gerenciar clientes, notícias e envio de e-mails para os clientes cadastrados. O envio de e-mails pode ser realizado por meio de uma requisição, além disso, o sistema possui um agendamento diário às 8h da manhã para o envio das notícias cadastradas. Para o envio de e-mails é necessário acessar o arquivo MailConfig.java e application.properties e alterar os dados do servidor SMTP. O sistema trabalha com banco de dados relacional em memória (H2 database) para facilitar a configuração do ambiente.

## Pré-requisitos:

- JDK 21 ou superior
- Maven
- IDE Java (opcional)

## Como rodar o projeto:

1. Navegue até o diretório do projeto:
    ```bash
    cd newsletter
    ```

2. Limpe as dependências:
    ```bash
    mvn clean
    ```

3. Realize o build:
    ```bash
    mvn build
    ```

4. Rode o projeto (também pode ser rodado pela IDE):
    ```bash
    mvn spring-boot:run
    ```

## Funcionalidades:

O sistema possui uma API Restful para cadastro de clientes (`/cliente`) e notícias (`/noticia`), ambas possuem um CRUD completo funcional e serão dados necessários para o envio dos e-mails.

### Modelo JSON de notícia:

```json
{
    "titulo": "Fiat Argo lidera vendas no último dia útil de março de 2024",
    "descricao": "O mercado automotivo brasileiro registrou 10.817 carros e comerciais leves emplacados em 28 de março de 2024, dos quais a liderança ficou com o Fiat Argo, com 873 emplacamentos.",
    "link": "https://www.car.blog.br/2024/03/fiat-argo-lidera-vendas-no-ultimo-dia.html#google_vignette"
}

```

### Modelo JSON de cliente:

```json
{
    "nome": "Carlos Eduardo Pereira",
    "email": "carlos_pereira@email.com",
    "data_nascimento": "2000-12-11"
}
```

### Envio de e-mails:

Para realizar o envio de e-mails, é possível realizar uma requisição GET para /email/enviar_noticias_diarias.
