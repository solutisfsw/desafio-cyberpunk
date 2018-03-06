-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Mar-2018 às 03:35
-- Versão do servidor: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crud_solutis`
--
CREATE DATABASE IF NOT EXISTS crud_solutis;
USE crud_solutis;
-- --------------------------------------------------------

--
-- Estrutura da tabela `adicionais`
--

CREATE TABLE `adicionais` (
  `add_id` int(11) NOT NULL,
  `add_nome` varchar(30) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adicionais`
--

INSERT INTO `adicionais` (`add_id`, `add_nome`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Braço Mecânico', '2018-03-04 00:45:39', NULL, NULL),
(2, 'Esqueleto Reforçado', '2018-03-04 00:45:34', NULL, NULL),
(3, 'Sentidos Aguçados', '2018-03-04 00:45:27', NULL, NULL),
(4, 'Pele Adaptiva', '2018-03-04 00:45:21', NULL, NULL),
(5, 'Raio Laser', '2018-03-04 00:45:13', NULL, NULL),
(6, 'Braço Mecânico', '2018-03-04 00:43:33', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clones`
--

CREATE TABLE `clones` (
  `clo_id` int(11) NOT NULL,
  `clo_nome` varchar(7) NOT NULL,
  `clo_idade` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clones`
--

INSERT INTO `clones` (`clo_id`, `clo_nome`, `clo_idade`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'CLO0001', 10, '2018-03-04 06:54:52', '2018-03-04 06:54:52', NULL),
(2, 'CLO0002', 11, '2018-03-04 06:41:23', NULL, NULL),
(3, 'ROB0003', 12, '2018-03-04 06:38:43', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `melhorias`
--

CREATE TABLE `melhorias` (
  `clo_id` int(11) NOT NULL,
  `add_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adicionais`
--
ALTER TABLE `adicionais`
  ADD PRIMARY KEY (`add_id`);

--
-- Indexes for table `clones`
--
ALTER TABLE `clones`
  ADD PRIMARY KEY (`clo_id`),
  ADD UNIQUE KEY `clo_nome` (`clo_nome`);

--
-- Indexes for table `melhorias`
--
ALTER TABLE `melhorias`
  ADD KEY `clo_id` (`clo_id`),
  ADD KEY `add_id` (`add_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adicionais`
--
ALTER TABLE `adicionais`
  MODIFY `add_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `clones`
--
ALTER TABLE `clones`
  MODIFY `clo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `melhorias`
--
ALTER TABLE `melhorias`
  ADD CONSTRAINT `melhorias_ibfk_1` FOREIGN KEY (`clo_id`) REFERENCES `clones` (`clo_id`),
  ADD CONSTRAINT `melhorias_ibfk_2` FOREIGN KEY (`add_id`) REFERENCES `adicionais` (`add_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
