CREATE SCHEMA IF NOT EXISTS `SOLUTIS` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SOLUTIS` ;



CREATE TABLE IF NOT EXISTS `SOLUTIS`.`CLONE` (
idClone int unsigned not null auto_increment primary key COMMENT '',
nome varchar (45) not null COMMENT '',
skill varchar (45) not null COMMENT '',
idade int not null COMMENT '',
criacao date not null COMMENT '',
genero varchar (45) not null COMMENT '',
especial varchar (45) not null COMMENT ''


);

