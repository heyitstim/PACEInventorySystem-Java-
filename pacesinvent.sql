-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: pacesinvent
-- ------------------------------------------------------
-- Server version	10.1.22-MariaDB-

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `e_name` varchar(80) DEFAULT NULL,
  `e_type` varchar(80) DEFAULT NULL,
  `e_pass` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('Elnathan Timothy dela Cruz','admin','YcTzyF85dJyqsnPUVrWR1w=='),('administrator','admin','YcTzyF85dJyqsnPUVrWR1w==');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_logs`
--

DROP TABLE IF EXISTS `s_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_logs` (
  `action` varchar(80) DEFAULT NULL,
  `s_name` varchar(80) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_logs`
--

LOCK TABLES `s_logs` WRITE;
/*!40000 ALTER TABLE `s_logs` DISABLE KEYS */;
INSERT INTO `s_logs` VALUES ('INSERT','English',3,'2017-11-28 15:50:30'),('INSERT','English',4,'2017-11-28 15:56:14'),('INSERT','English',4,'2017-11-28 15:56:24'),('INSERT','English',4,'2017-11-28 15:56:58'),('INSERT','English',4,'2017-11-28 18:26:21'),('INSERT','English',4,'2017-11-28 18:26:25'),('INSERT','English',4,'2017-11-28 18:32:34'),('INSERT','English',3,'2017-11-28 18:38:07'),('INSERT','English',3,'2017-11-28 18:38:11'),('INSERT','English',3,'2017-11-28 18:38:15'),('INSERT','English',3,'2017-11-28 18:38:18'),('INSERT','English',3,'2017-11-28 18:38:22');
/*!40000 ALTER TABLE `s_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subj_English`
--

DROP TABLE IF EXISTS `subj_English`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_English` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_English`
--

LOCK TABLES `subj_English` WRITE;
/*!40000 ALTER TABLE `subj_English` DISABLE KEYS */;
INSERT INTO `subj_English` VALUES (1000,4),(1001,1),(1002,3),(1003,3),(1004,0),(1005,2),(1006,3),(1007,4),(1008,4),(1009,4),(1010,4),(1011,4),(1012,3),(1013,3),(1014,3),(1015,3),(1016,3);
/*!40000 ALTER TABLE `subj_English` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ai_subs AFTER INSERT ON subj_English
FOR EACH ROW
BEGIN
INSERT INTO s_logs(action,s_name,s_quan,date)
VALUES ('INSERT','English',NEW.s_quan,NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subj_Filipino`
--

DROP TABLE IF EXISTS `subj_Filipino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_Filipino` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_Filipino`
--

LOCK TABLES `subj_Filipino` WRITE;
/*!40000 ALTER TABLE `subj_Filipino` DISABLE KEYS */;
/*!40000 ALTER TABLE `subj_Filipino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subj_Math`
--

DROP TABLE IF EXISTS `subj_Math`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_Math` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_Math`
--

LOCK TABLES `subj_Math` WRITE;
/*!40000 ALTER TABLE `subj_Math` DISABLE KEYS */;
INSERT INTO `subj_Math` VALUES (1000,2);
/*!40000 ALTER TABLE `subj_Math` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subj_Science`
--

DROP TABLE IF EXISTS `subj_Science`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_Science` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_Science`
--

LOCK TABLES `subj_Science` WRITE;
/*!40000 ALTER TABLE `subj_Science` DISABLE KEYS */;
/*!40000 ALTER TABLE `subj_Science` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subj_SocialS`
--

DROP TABLE IF EXISTS `subj_SocialS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_SocialS` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_SocialS`
--

LOCK TABLES `subj_SocialS` WRITE;
/*!40000 ALTER TABLE `subj_SocialS` DISABLE KEYS */;
/*!40000 ALTER TABLE `subj_SocialS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subj_WordB`
--

DROP TABLE IF EXISTS `subj_WordB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subj_WordB` (
  `s_num` int(11) DEFAULT NULL,
  `s_quan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subj_WordB`
--

LOCK TABLES `subj_WordB` WRITE;
/*!40000 ALTER TABLE `subj_WordB` DISABLE KEYS */;
/*!40000 ALTER TABLE `subj_WordB` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-01 10:10:59
