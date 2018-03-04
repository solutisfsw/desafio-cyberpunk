#!/bin/sh

echo "Parando containers "
docker stop $(docker ps -qa)

echo "Excluído nome da imagem caso exista "
docker rm db-mysql

echo "Subindo imagem mysql "
docker run --name db-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=desafio_solutis -e MYSQL_USER=desafio_solutis -e MYSQL_PASSWORD=desafio -d mysql:5.6

echo "Contruindo projeto "
mvn clean package docker:build

echo "Excluído nome da imagem caso exista do app "
docker rm app

echo " Subindo Aplicacao "
docker run -p 8080:8080 --name app --link db-mysql:mysql -d ehcoo/spring-boot-docker-mysql

echo "Aplicação no ar \o/ "

port="8080"
b=$(docker-machine ip)
echo "docker machine ip = "$b

echo "Rotas do servico:"
echo "GET    "$b":"$port"/clones "
echo "GET    "$b":"$port"/clones/{id} "
echo "PUT    "$b":"$port"/clones/{id} "
echo "POST   "$b":"$port"/clones/add "
echo "DELETE "$b":"$port"/clones/{id} "

