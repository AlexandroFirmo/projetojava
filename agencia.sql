-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Jun-2017 às 23:24
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agencia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pacote`
--

CREATE TABLE `pacote` (
  `idPacote` int(11) NOT NULL,
  `descPacote` varchar(100) DEFAULT NULL,
  `dataEmbarque` date NOT NULL,
  `dataRetorno` date NOT NULL,
  `custo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pacote`
--

INSERT INTO `pacote` (`idPacote`, `descPacote`, `dataEmbarque`, `dataRetorno`, `custo`) VALUES
(20, 'glob', '2002-01-29', '2002-01-29', 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `passeio`
--

CREATE TABLE `passeio` (
  `idPasseio` int(11) NOT NULL,
  `descPasseio` varchar(100) DEFAULT NULL,
  `localPasseio` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `passeio`
--

INSERT INTO `passeio` (`idPasseio`, `descPasseio`, `localPasseio`) VALUES
(1, 'praia', 'xx'),
(2, 'shoping', 'xx'),
(3, 'teste', 'xx');

-- --------------------------------------------------------

--
-- Estrutura da tabela `passeiopacote`
--

CREATE TABLE `passeiopacote` (
  `idPacote` int(11) NOT NULL,
  `idPasseio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `passeiopacote`
--

INSERT INTO `passeiopacote` (`idPacote`, `idPasseio`) VALUES
(20, 2),
(20, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pacote`
--
ALTER TABLE `pacote`
  ADD PRIMARY KEY (`idPacote`);

--
-- Indexes for table `passeio`
--
ALTER TABLE `passeio`
  ADD PRIMARY KEY (`idPasseio`);

--
-- Indexes for table `passeiopacote`
--
ALTER TABLE `passeiopacote`
  ADD PRIMARY KEY (`idPacote`,`idPasseio`),
  ADD KEY `idPasseio` (`idPasseio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pacote`
--
ALTER TABLE `pacote`
  MODIFY `idPacote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `passeio`
--
ALTER TABLE `passeio`
  MODIFY `idPasseio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `passeiopacote`
--
ALTER TABLE `passeiopacote`
  ADD CONSTRAINT `passeiopacote_ibfk_1` FOREIGN KEY (`idPacote`) REFERENCES `pacote` (`idPacote`),
  ADD CONSTRAINT `passeiopacote_ibfk_2` FOREIGN KEY (`idPasseio`) REFERENCES `passeio` (`idPasseio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
