# ProjetoLivrariaRest# Livraria Rest 

Sistema criado para uma livraria fictícia no BootCamp Java Backend da Alura, desenvolvido em Java com o framework Spring Boot focado apenas no backend.

# Features
* Cadastrar
* Listar
* Relatorio de livros publicados(Nova)
* Dados persistidos em BD mysql através do JPA e Flyway.(Nova)


# Requisitos
* Necessário utilizar o Postman para testar os métodos Get e Post da aplicação.
* Alguma IDE para inicializar a aplicação Java, fui utilizada nesse projeto o Eclipse.

# Modo de usar

1. Faça o clone desse repositório e importe em sua IDE, a que foi utilizada nesse projeto foi o Eclipse.
2. Configure a sua conexão com o Banco de dados com as suas credenciais no arquivo "application.properties".
3. Rode a classe LivrariaRestApplication.java dentro do pacote br.com.alura.livrariaRestpara inicializar o Spring.
4. Abra o Postman, caso não tenha faça o download nesse [link](https://www.postman.com/downloads/)
5. Com o projeto inicializado vá no Postman e teste os métodos Get e Post com os recursos livros e autores, como foi realizado no gif abaixo.
6. Para testar o novo recurso de relatório de livros publicados por autor utilize a uri "http://localhost:8080/relatorios/livros-publicados".




![Alt Text](http://g.recordit.co/wpSYGsrjfh.gif)
