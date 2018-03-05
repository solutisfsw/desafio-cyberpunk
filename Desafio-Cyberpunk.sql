-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 04-Mar-2018 às 22:32
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `desafio-cyberpunk`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clone`
--

CREATE TABLE IF NOT EXISTS `clone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(7) NOT NULL,
  `idade` int(11) NOT NULL,
  `dataDeCriacao` date NOT NULL,
  `adicionais` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Extraindo dados da tabela `clone`
--

INSERT INTO `clone` (`id`, `nome`, `idade`, `dataDeCriacao`, `adicionais`) VALUES
(14, 'ABB1214', 18, '2018-03-01', 'braço mecânico,pele adaptativa'),
(17, 'QAW1234', 16, '2018-03-01', 'braço mecânico,esqueleto reforçado,sentidos aguçados,pele adaptativa,raio laser'),
(18, 'MNS1234', 16, '2018-03-01', 'braço mecânico,pele adaptativa'),
(19, 'AVC1212', 18, '2018-03-01', 'braço mecânico');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
