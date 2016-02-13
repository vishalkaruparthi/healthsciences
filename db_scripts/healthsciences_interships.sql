# ************************************************************
# Sequel Pro SQL dump
# Version 4500
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.10)
# Database: healthsciences_interships
# Generation Time: 2016-02-13 13:13:10 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table academicperiod
# ------------------------------------------------------------

DROP TABLE IF EXISTS `academicperiod`;

CREATE TABLE `academicperiod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `academicperiod` WRITE;
/*!40000 ALTER TABLE `academicperiod` DISABLE KEYS */;

INSERT INTO `academicperiod` (`id`, `title`)
VALUES
	(1,'Fall'),
	(2,'Spring'),
	(3,'Summer');

/*!40000 ALTER TABLE `academicperiod` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table academicperiod_inernship
# ------------------------------------------------------------

DROP TABLE IF EXISTS `academicperiod_inernship`;

CREATE TABLE `academicperiod_inernship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acadID` int(11) NOT NULL,
  `internID` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`),
  KEY `internID` (`internID`),
  KEY `hoursID` (`acadID`),
  CONSTRAINT `academicperiod_inernship_ibfk_2` FOREIGN KEY (`internID`) REFERENCES `internship` (`id`),
  CONSTRAINT `academicperiod_inernship_ibfk_3` FOREIGN KEY (`acadID`) REFERENCES `academicperiod` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `academicperiod_inernship` WRITE;
/*!40000 ALTER TABLE `academicperiod_inernship` DISABLE KEYS */;

INSERT INTO `academicperiod_inernship` (`id`, `acadID`, `internID`)
VALUES
	(1,1,1),
	(2,2,1),
	(8,1,38),
	(9,2,38);

/*!40000 ALTER TABLE `academicperiod_inernship` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hourswork
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hourswork`;

CREATE TABLE `hourswork` (
  `Hours_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Hours_Week` varchar(11) DEFAULT NULL,
  `Total_Hours` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`Hours_ID`),
  KEY `Hours_ID` (`Hours_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `hourswork` WRITE;
/*!40000 ALTER TABLE `hourswork` DISABLE KEYS */;

INSERT INTO `hourswork` (`Hours_ID`, `Title`, `Hours_Week`, `Total_Hours`)
VALUES
	(1,'half time for one semester','15',230),
	(2,' full time for one semester','35',300),
	(3,'half time for two semesters','15',500);

/*!40000 ALTER TABLE `hourswork` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hourswork_intership
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hourswork_intership`;

CREATE TABLE `hourswork_intership` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoursID` int(11) NOT NULL,
  `internID` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`),
  KEY `hoursID` (`hoursID`),
  KEY `internID` (`internID`),
  CONSTRAINT `hourswork_intership_ibfk_1` FOREIGN KEY (`hoursID`) REFERENCES `hourswork` (`Hours_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hourswork_intership_ibfk_2` FOREIGN KEY (`internID`) REFERENCES `internship` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `hourswork_intership` WRITE;
/*!40000 ALTER TABLE `hourswork_intership` DISABLE KEYS */;

INSERT INTO `hourswork_intership` (`id`, `hoursID`, `internID`)
VALUES
	(1,1,1),
	(2,2,1),
	(7,1,38),
	(8,2,38);

/*!40000 ALTER TABLE `hourswork_intership` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table internship
# ------------------------------------------------------------

DROP TABLE IF EXISTS `internship`;

CREATE TABLE `internship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_Name` varchar(1000) DEFAULT NULL,
  `URL` varchar(1000) DEFAULT NULL,
  `Contact_Person_name` varchar(1000) DEFAULT NULL,
  `Phone_number` varchar(12) DEFAULT NULL,
  `Personal_Email` varchar(100) DEFAULT NULL,
  `Internship_Description` varchar(1000) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Zipcode` varchar(50) DEFAULT NULL,
  `Special_Skills` varchar(200) DEFAULT NULL,
  `PayType_ID` int(11) DEFAULT NULL,
  `PayAmount` varchar(200) DEFAULT NULL,
  `Posted_Date` timestamp NULL DEFAULT NULL,
  `State_ID` int(11) DEFAULT NULL,
  `Status` varchar(50) DEFAULT 'SUBMITTED',
  KEY `id` (`id`),
  KEY `State_ID` (`State_ID`),
  KEY `Pay_Type_ID` (`PayType_ID`),
  CONSTRAINT `internship_ibfk_2` FOREIGN KEY (`PayType_ID`) REFERENCES `paytype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `internship_ibfk_3` FOREIGN KEY (`State_ID`) REFERENCES `state` (`State_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `internship` WRITE;
/*!40000 ALTER TABLE `internship` DISABLE KEYS */;

INSERT INTO `internship` (`id`, `organization_Name`, `URL`, `Contact_Person_name`, `Phone_number`, `Personal_Email`, `Internship_Description`, `City`, `Zipcode`, `Special_Skills`, `PayType_ID`, `PayAmount`, `Posted_Date`, `State_ID`, `Status`)
VALUES
	(1,'High Radius','www.highradius.com','Vishal','9963509735','vishal.karuparthi@live.com','Chill out','huntsville','77340','1. abc\n2. good communication skills',2,'40000',NULL,43,'APPROVED'),
	(38,'High Radius','www.highradius.com','Vishal','9963509735','vishal.karuparthi@live.com','Chill out','huntsville','77340','1. abc\n2. good communication skills',2,'40000',NULL,43,'APPROVED');

/*!40000 ALTER TABLE `internship` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table interntype
# ------------------------------------------------------------

DROP TABLE IF EXISTS `interntype`;

CREATE TABLE `interntype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `interntype` WRITE;
/*!40000 ALTER TABLE `interntype` DISABLE KEYS */;

INSERT INTO `interntype` (`id`, `title`)
VALUES
	(1,'Public Health/Health Promotion'),
	(2,'Health Care Administration'),
	(3,'Bilingiual Healthcare'),
	(4,'Wellness Management');

/*!40000 ALTER TABLE `interntype` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table interntype_internship
# ------------------------------------------------------------

DROP TABLE IF EXISTS `interntype_internship`;

CREATE TABLE `interntype_internship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interntypeID` int(11) NOT NULL,
  `internID` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`),
  KEY `hoursID` (`interntypeID`),
  KEY `internID` (`internID`),
  CONSTRAINT `interntype_internship_ibfk_1` FOREIGN KEY (`interntypeID`) REFERENCES `interntype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `interntype_internship_ibfk_2` FOREIGN KEY (`internID`) REFERENCES `internship` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `interntype_internship` WRITE;
/*!40000 ALTER TABLE `interntype_internship` DISABLE KEYS */;

INSERT INTO `interntype_internship` (`id`, `interntypeID`, `internID`)
VALUES
	(1,1,1),
	(2,2,1),
	(5,1,38),
	(6,2,38);

/*!40000 ALTER TABLE `interntype_internship` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table paytype
# ------------------------------------------------------------

DROP TABLE IF EXISTS `paytype`;

CREATE TABLE `paytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `Hours_ID` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `paytype` WRITE;
/*!40000 ALTER TABLE `paytype` DISABLE KEYS */;

INSERT INTO `paytype` (`id`, `title`)
VALUES
	(1,'No'),
	(2,'Stipend'),
	(3,'Wage'),
	(4,'To be determined');

/*!40000 ALTER TABLE `paytype` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table state
# ------------------------------------------------------------

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `State_ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`State_ID`),
  UNIQUE KEY `State_ID_UNIQUE` (`State_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;

INSERT INTO `state` (`State_ID`, `Name`)
VALUES
	(1,'Alabama'),
	(2,'Alaska'),
	(3,'Arizona'),
	(4,'Arkansas'),
	(5,'California'),
	(6,'Colorado'),
	(7,'Connecticut'),
	(8,'Delaware'),
	(9,'Florida'),
	(10,'Georgia'),
	(11,'Hawaii'),
	(12,'Idaho'),
	(13,'Illinois'),
	(14,'Indiana'),
	(15,'Iowa'),
	(16,'Kansas'),
	(17,'Kentucky'),
	(18,'Louisiana'),
	(19,'Maine'),
	(20,'Maryland'),
	(21,'Massachusetts'),
	(22,'Michigan'),
	(23,'Minnesota'),
	(24,'Mississippi'),
	(25,'Missouri'),
	(26,'Montana'),
	(27,'Nebraska'),
	(28,'Nevada'),
	(29,'New Hampshire'),
	(30,'New Jersey'),
	(31,'New Mexico'),
	(32,'New York'),
	(33,'North Carolina'),
	(34,'North Dakota'),
	(35,'Ohio'),
	(36,'Oklahoma'),
	(37,'Oregon'),
	(38,'Pennsylvania'),
	(39,'Rhode Island'),
	(40,'South Carolina'),
	(41,'South Dakota'),
	(42,'Tennessee'),
	(43,'Texas'),
	(44,'Utah'),
	(45,'Vermont'),
	(46,'Virginia'),
	(47,'Washington'),
	(48,'West Virginia'),
	(49,'Wisconsin'),
	(50,'Wyoming');

/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
