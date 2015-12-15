-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 12 Décembre 2015 à 14:59
-- Version du serveur: 5.5.46-0ubuntu0.14.04.2
-- Version de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `m903083`
--

-- --------------------------------------------------------

--
-- Structure de la table `Group_`
--

CREATE TABLE IF NOT EXISTS `Group_` (
  `groupID` bigint(20) NOT NULL,
  `groupe` varchar(200) NOT NULL,
  PRIMARY KEY (`groupID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Group_`
--

INSERT INTO `Group_` (`groupID`, `groupe`) VALUES
(1, 'Groupe A'),
(2, 'Groupe B'),
(3, 'Groupe C'),
(4, 'Groupe D'),
(5, 'Groupe E');

-- --------------------------------------------------------

--
-- Structure de la table `OPENJPA_SEQUENCE_TABLE`
--

CREATE TABLE IF NOT EXISTS `OPENJPA_SEQUENCE_TABLE` (
  `ID` tinyint(4) NOT NULL,
  `SEQUENCE_VALUE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Person`
--

CREATE TABLE IF NOT EXISTS `Person` (
  `id` bigint(20) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `website` varchar(100) NOT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Person`
--

INSERT INTO `Person` (`id`, `birthdate`, `email`, `firstname`, `lastname`, `password`, `website`, `group_id`) VALUES
(1, '1990-08-25', 'mdjassiri.amirdine@gmail.com', 'Amirdine', 'MDJASSIRI', 'd8gfh', 'http://amirdine.mdjassiri.etu.perso.luminy.univ-amu.fr/', 1),
(2, '1992-12-10', 'charly.celereau@gmail.com', 'Charly', 'CELERAU', 'pass', 'http://charly.celerau.etu.perso.luminy.univ-amu.fr', 1),
(3, '1989-10-14', 'sissoko_o@yahoo.fr', 'Oumar', 'SiSSIKO', 'password', 'http://sissoko.perso.ml', 2),
(4, '1989-08-10', 'bahsaikou10@gmail.com', 'Saïkou', 'BAH', 'test', 'http:/bahsaikou10.perso.net', 2),
(5, '1993-02-05', 'guillaumebroc@free.fr', 'Guillaume', 'BROC', 'root', 'http://guillaume.broc.etu.perso.luminy.univ-amu.fr', 3);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Person`
--
ALTER TABLE `Person`
  ADD CONSTRAINT `Person_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `Group_` (`groupID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
