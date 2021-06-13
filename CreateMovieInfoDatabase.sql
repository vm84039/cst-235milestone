CREATE DATABASE  IF NOT EXISTS `MovieInfo`;
USE `MovieInfo`;

DROP TABLE IF EXISTS `Movies`;
CREATE TABLE `Movies` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
   `TITLE` varchar(30) NOT NULL, 
   `RYEAR` int(4) NOT NULL, 
   `GENRE` varchar(30), 
   `STAR` varchar(40) NOT NULL, 
   `STUDIO` varchar(30), 
   `DIRECTOR` varchar(30), 
   `LENGTH` int(4) NOT NULL, 
   `RENTAL` float NOT NULL,
   `COST` varchar(20), 
   `REVENUE` varchar(20),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
