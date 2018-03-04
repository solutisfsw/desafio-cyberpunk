-- CREATE DATABASE  IF NOT EXISTS `desafio_solutis` /*!40100 DEFAULT CHARACTER SET latin1 */;
-- USE `desafio_solutis`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: desafio_solutis
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adicional`
--

DROP TABLE IF EXISTS `adicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adicional` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `braco_mecanico` bit(1) DEFAULT NULL,
  `esqueleto_reforcado` bit(1) DEFAULT NULL,
  `sentidos_agucados` bit(1) DEFAULT NULL,
  `pele_adaptativa` bit(1) DEFAULT NULL,
  `raio_laser` bit(1) DEFAULT NULL,
  `id_clone` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `clone_adicional_id_clone` FOREIGN KEY (`id_clone`) REFERENCES `clone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adicional`
--

LOCK TABLES `adicional` WRITE;
/*!40000 ALTER TABLE `adicional` DISABLE KEYS */;
/*!40000 ALTER TABLE `adicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clone`
--

DROP TABLE IF EXISTS `clone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clone` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `idade` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_criacao` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clone`
--

LOCK TABLES `clone` WRITE;
/*!40000 ALTER TABLE `clone` DISABLE KEYS */;
--INSERT INTO `clone` VALUES (10,10,'teste1','2018-02-28'),(12,10,'teste','2018-02-28'),(13,10,'TES1234','2018-02-28');
/*!40000 ALTER TABLE `clone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'desafio_solutis'
--

--
-- Dumping routines for database 'desafio_solutis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-01 17:25:52

-- CREATE USER 'desafio_solutis'@'localhost';
-- GRANT ALL PRIVILEGES ON *.* TO 'desafio_solutis'@'localhost'
-- WITH GRANT OPTION;
-- SET PASSWORD FOR 'desafio_solutis'@'localhost' = PASSWORD ('desafio');
-- GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DROP, EVENT, EXECUTE, GRANT OPTION, INDEX, LOCK TABLES, REFERENCES, SHOW VIEW, TRIGGER ON selecao_fullstack.* TO 'desafio_solutis'@'localhost';

