# luteranos-raffle-ddd


Projeto desenvolvido por FredyHG [GitHub](https://github.com/FredyHG)

## Explanation
Sistema de gerenciamento e distribuição de rifas temáticas, integrado ao sistema de pagamento Mercado Pago, com o objetivo de arrecadar fundos para a igreja.

### Tecnologias Utilizadas
- **Java 17 e Spring Boot 3**: Desenvolvimento da aplicação web
- **Spring Security com JWT**: Garantia da segurança dos dados dos usuários.
- **PostgreSQL**: Armazenamento dos dados da aplicação.
- **Docker**: Criação e gerenciamento de contêineres para a aplicação.
- **AWS**: Hospedagem da API na nuvem


### Como Executar com Docker Compose

Para executar a aplicação usando Docker Compose, siga os passos abaixo:


1. **Inicie os containers usando Docker Compose**

Execute o comando abaixo para construir e iniciar os containers:

```sh
docker compose up --build
```

### Documentação da API

A API está documentada usando Swagger. Após iniciar a aplicação, você pode acessar a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

### Contato

Para mais informações, visite o [GitHub](https://github.com/FredyHG).