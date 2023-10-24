-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: sinhviendb
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.23.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `diem_baitap`
--

DROP TABLE IF EXISTS `diem_baitap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem_baitap` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `baitap_id` int DEFAULT NULL,
  `diem` float DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `baitap_id` (`baitap_id`),
  CONSTRAINT `diem_baitap_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `diem_baitap_ibfk_2` FOREIGN KEY (`baitap_id`) REFERENCES `baitap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem_baitap`
--

LOCK TABLES `diem_baitap` WRITE;
/*!40000 ALTER TABLE `diem_baitap` DISABLE KEYS */;
INSERT INTO `diem_baitap` VALUES (17,1,2,8.5,'2023-10-11 00:00:00.000000'),(18,1,3,9,'2023-06-11 00:00:00.000000'),(19,2,2,7.5,'2023-07-11 00:00:00.000000'),(20,2,3,8,'2023-07-19 00:00:00.000000'),(21,1,2,8.5,'2023-10-11 00:00:00.000000'),(22,3,2,8.5,'2023-09-11 10:00:00.000000'),(24,3,2,7.5,'2023-01-11 10:00:00.000000'),(26,3,2,10,'2023-10-12 22:15:59.912945'),(27,3,2,10,'2023-10-13 01:40:45.287375'),(28,3,3,10,'2023-10-13 02:03:17.721296'),(29,3,4,10,'2023-10-13 02:04:23.327365'),(30,3,2,10,'2023-10-14 08:10:38.174406'),(31,3,25,10,'2023-10-14 18:26:50.132725'),(32,3,5,10,'2023-10-14 18:27:42.561213');
/*!40000 ALTER TABLE `diem_baitap` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-24 23:05:46
