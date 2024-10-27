# trabalho_api_gp4

Este projeto é um sistema de gestão de um Aeroporto desenvolvido utilizando o framework Spring Boot. Ele permite o gerenciamento do aeroporto, funcionário, cliente, categoria, produto e a compra de passagens, além de fornecer autenticação e autorização básica para os usuários.

## Funcionalidades Principais

- *Endereço*: Criação de endereços, atualização, visualização de todos os endereços ou pelo ID e deletar endereços.
- *Gerenciamento do Aeroporto*: Criação e armazenamento de dados de aeroporto, atualização, visualização e deletar aeroporto.
- *Roles*: Criação das roles "ROLE_ADMIN" e/ou "ROLE_USER".
- *Cadastro de Funcionário e/ou Clientes*: Criação com foto, visualização de todos ou pelo ID, atualização de informações e deletar cadastro.
- *Login*: Login em algum cadastro e visualização de foto do usuário.
- *Categoria*: Criação das categorias, atualização, visualização de todas ou pelo ID, deletar categorias.
- *Produto*: Criação dos produtos, atualização, visualização de todos ou pelo ID e deletar produtos.
- *Compra de passagem ou Pedido*: Comprar, atualizar, visualizar compra e deletar/cancelar compra.

## Estrutura do Banco de Dados

O banco de dados possui as seguintes tabelas principais:

[Imagem](https://github.com/lucasarasa/G4_trabalho_api/blob/main/BancoGP4.png)

1. *Endereco*: Armazena informações de endereço.
2. *Aeroporto*: Guarda informações do aeroporto.
3. *Roles*: Define os papéis dos usuários no sistema (ADMIN e/ou USER).
4. *Users*: Armazena informações dos usuários, incluindo nome de usuário, e-mail e senha.
5. *Funcionário e Cliente* Armazena informações dos cadastrados.
6. *Categoria*: Armazena as categorias dos produtos.
7. *Produto*: Armazena as informações dos produtos registrados.
8. *Pedido*: Armazena as compras feitas pelos usuários, incluindo a quantidade de ingressos e o status da compra.

Explicação das Relações:

Nesse projeto, temos a relação de um endereço com nosso único aeroporto, e esse único aeroporto tem ligação com muitos usuários. Cada usuário está ligado a um cliente ou a um funcionário, e também temos uma foto para cada usuário. Cada cliente está ligado a muitos pedidos, e muitos pedidos estão ligados a muitos produtos. Muitos produtos podem ter a mesma categoria, mas cada produto tem seu próprio endereço, e muitos produtos podem ser alterados por muitos funcionários. 

## Dependências Principais

O projeto foi desenvolvido com as seguintes dependências principais:

- *Spring Boot*: Framework para construção do backend.
- *Spring Data JPA*: Para interação com o banco de dados.
- *Spring Security*: Para autenticação e autorização de usuários.
- *PostgreSQL*: Banco de dados utilizado no projeto.

## Tecnologias utilizadas

- [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring tool Suite 4](https://spring.io/tools)
- [DBeaver](https://dbeaver.io/download/)
- [Swagger](http://localhost:8000/carcontrol/swagger-ui/index.html#/)
- [Postman](https://www.postman.com/)
- [Trello](https://trello.com/pt-BR)

## Autores

- [Ana Luísa Fortuna](https://github.com/anafortuna)
- [Bruna Coelho](https://github.com/brunacmedeiros)
- [Diogo Portella](https://github.com/Dgporte)
- [Gabriel Couto](https://github.com/Yzmael14)
- [João Gabriel Wermelinger:](https://github.com/joaocfw)
- [Lucas Sarasa](https://github.com/lucasarasa)