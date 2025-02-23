-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: note_finder
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `musical_scale_intervals`
--

DROP TABLE IF EXISTS `musical_scale_intervals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musical_scale_intervals` (
  `scale_id` int NOT NULL AUTO_INCREMENT,
  `scale_name` varchar(50) NOT NULL,
  `root_interval` tinyint unsigned NOT NULL,
  `second_interval` tinyint unsigned NOT NULL,
  `third_interval` tinyint unsigned NOT NULL,
  `fourth_interval` tinyint unsigned NOT NULL,
  `fifth_interval` tinyint unsigned NOT NULL,
  `sixth_interval` tinyint unsigned NOT NULL,
  `seventh_interval` tinyint unsigned NOT NULL,
  PRIMARY KEY (`scale_id`),
  UNIQUE KEY `unique_name` (`scale_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musical_scale_intervals`
--

LOCK TABLES `musical_scale_intervals` WRITE;
/*!40000 ALTER TABLE `musical_scale_intervals` DISABLE KEYS */;
INSERT INTO `musical_scale_intervals` (`scale_id`, `scale_name`, `root_interval`, `second_interval`, `third_interval`, `fourth_interval`, `fifth_interval`, `sixth_interval`, `seventh_interval`) VALUES (1,'Natural Minor',0,2,3,5,7,8,10),(4,'Natural Major',0,2,4,5,7,9,11),(5,'Hungarian Minor',0,2,3,6,7,8,11);
/*!40000 ALTER TABLE `musical_scale_intervals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-22 20:34:06
