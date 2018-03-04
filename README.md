
# desafio-cyberpunk

Projeto utilizado como uma das etapas para a Solutis - Talent Sprint. A estrutura está dividida entre backend (pasta 'desafio') e frontend (pasta 'desafio-front'). As tecnologias utilizadas foram:

 - Spring Boot para o backend. Obs.: foi utilizado um banco de dados em memória, o H2 Database;
 - Angular 4 para o frontend.

## Instalação
Requisitos básicos:

 - JDK 8;
 - Node.js 8.*;
 - Maven.

Comandos para a instalação de pacotes do node.js utilizados no desenvolvimento: 
```sh
npm install -g @angular/cli
npm install -g http-server
```
## Build
### Backend
Dentro da pasta 'desafio', execute o seguinte comando:
```sh
 mvn install
```
### Frontend
Dentro da pasta 'desafio-front', execute o seguinte comando:
```sh
 ng build --prod
```
## Executando o Projeto
Após realizar o build, na pasta raiz do projeto, utilize os seguintes comandos para "subir" os servidores da API REST e do frontend (utilizei o módulo http-server somente para desenvolvimento), respectivamente:
 ```sh
 java -jar desafio/target/desafio-0.0.1-SNAPSHOT.jar
 http-server desafio-front/dist -p 8000
```
Com os dois servidores em execução, basta acessar o frontend da aplicação através do endereço: http://localhost:8000

## Meta
Seu Nome – [Antonio Carlos dos Santos Costa](linkedin.com/in/tonycosta10/) – tonyblack_si@yahoo.com.br

Distribuído sob a licença `MIT License`.
