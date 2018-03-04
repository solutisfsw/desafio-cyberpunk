#!/bin/sh

echo "Parando containers \n"
docker stop $(docker ps -qa)

echo "Parando containers \n"
docker rm demo-mysql

echo "Subindo imagem mysql \n"
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=desafio_solutis -e MYSQL_USER=desafio_solutis -e MYSQL_PASSWORD=desafio -d mysql:5.6

echo "Contruindo projeto \n"
mvn clean package docker:build

docker rm demo-app

echo "Aplicacao!! \n "
docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql ehcoo/spring-boot-docker-mysql
