# Clone Project

Esta é uma aplicação que utiliza os frameworks: Angular e Spring Boot de forma a criar um CRUD de clones. A aplicação dispõe da parte frontend e backend. 

## Instalação
Linux & Windows
   Instalar NPM:
     apt install build-essential libssl-dev
     npm install express
     npm install
     npm buid

   Inicializador do Spring Boot:
     https://start.spring.io/

   Instalar Angular:
     sudo npm install -g @angular/cli

   Banco de dados:
     apt-get update && apt-get upgrade -y
     apt-get install mongodb
     systemctl start mongodb

## Configuração
 - CRUD com nome e idade do Clone;
 - "+" Adiciona um novo clone;
 - "Show detail": Mostra detalhes do clone, tem Opção de editar e deletar o clone;
 - Tecnologias: Angular 5, REST, SpringBoot, MongoDB

## Execução
  Dentro da pasta do projeto Clone, através da linha de comando do terminal, executar da seguinte forma:
    ./gradlew bootRun

  O projeto pode ser acessado através da seguinte url:
    http://localhost:8080/

## Author
Thiago – Thiago Neri Ramos – thiagoneriramos79@gmail.com
