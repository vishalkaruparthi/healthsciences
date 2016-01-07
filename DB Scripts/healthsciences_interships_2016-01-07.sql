# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.28)
# Database: healthsciences_interships
# Generation Time: 1937-10-17 13:54:17 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table hours_work
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hours_work`;

CREATE TABLE `hours_work` (
  `Hours_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Hours_Week` varchar(11) DEFAULT NULL,
  `Total_Hours` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`Hours_ID`),
  KEY `Hours_ID` (`Hours_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `hours_work` WRITE;
/*!40000 ALTER TABLE `hours_work` DISABLE KEYS */;

INSERT INTO `hours_work` (`Hours_ID`, `Title`, `Hours_Week`, `Total_Hours`)
VALUES
	(1,'half time for one semester','15',230),
	(2,' full time for one semester','35',300),
	(3,' quarter time for two semester','10',400),
	(4,'half time for two semesters','15',500);

/*!40000 ALTER TABLE `hours_work` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table internship_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `internship_details`;

CREATE TABLE `internship_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_Name` varchar(1000) DEFAULT NULL,
  `URL` varchar(1000) DEFAULT NULL,
  `Contact_Person_name` varchar(1000) DEFAULT NULL,
  `Phone_number` varchar(12) DEFAULT NULL,
  `Personal_Email` varchar(100) DEFAULT NULL,
  `Internship_Type_ID` varchar(50) DEFAULT NULL,
  `Internship_Description` varchar(1000) DEFAULT NULL,
  `Hours_ID` int(11) NOT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `Zipcode` int(11) DEFAULT NULL,
  `Special_Skills` varchar(200) DEFAULT NULL,
  `Pay_Type` varchar(200) DEFAULT NULL,
  `Pay_Amount` varchar(200) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_internship_details_hours_work` (`Hours_ID`),
  CONSTRAINT `FK_internship_details_hours_work` FOREIGN KEY (`Hours_ID`) REFERENCES `hours_work` (`Hours_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `internship_details` WRITE;
/*!40000 ALTER TABLE `internship_details` DISABLE KEYS */;

INSERT INTO `internship_details` (`id`, `organization_Name`, `URL`, `Contact_Person_name`, `Phone_number`, `Personal_Email`, `Internship_Type_ID`, `Internship_Description`, `Hours_ID`, `City`, `State`, `Zipcode`, `Special_Skills`, `Pay_Type`, `Pay_Amount`)
VALUES
	(1,'GOOGLE','www.google.com','raja','5558885454','rpk003@shsu.edu','Int1','xxyy',1,'Seatle','WA',54845,'Wen services','stipend','15'),
	(2,'GOOGLE','www.google.com','Vishal','3489528934','rpk003@shsu.edu','Int2','xxyy',3,'Seatle','WA',54845,'Wen services','stipend','15'),
	(3,'GOOGLE','www.google.com','Dad','3489528934','rpk003@shsu.edu','Int2','xxyy',1,'Seatle','WA',54845,'Wen services','stipend','15');

/*!40000 ALTER TABLE `internship_details` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
