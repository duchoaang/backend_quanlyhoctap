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
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ma_mon_hoc` varchar(255) NOT NULL,
  `ten_mon_hoc` varchar(255) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `so_tin_chi` varchar(255) NOT NULL,
  `giangvien_id` int DEFAULT NULL,
  `hoc_ki` bigint DEFAULT NULL,
  `nam_hoc` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `giangvien_id` (`giangvien_id`),
  CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`giangvien_id`) REFERENCES `giangvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'MATH101','Cơ sở dữ liệu',1,'3',1,1,2022),(2,'PHY101','Lập trình Java ',1,'4',2,1,2022),(13,'CHEM101','Hóa học cơ bản',1,'3',1,2,2022),(14,'BIO101','Sinh học 1',1,'3',2,2,2022),(15,'COMP101','Lập trình C++',1,'4',3,3,2022),(16,'ENG101','Tiếng Anh cơ bản',1,'2',4,3,2022),(17,'PHI101','Triết học',1,'3',5,1,2023),(18,'HIST101','Lịch sử thế giới',1,'3',6,1,2023),(19,'ART101','Nghệ thuật và thiết kế',1,'3',6,3,2023),(20,'PSYCH101','Tâm lý học cơ bản',0,'3',5,3,2023),(21,'SOC101','Xã hội học',1,'3',4,1,2023),(22,'ECON101','Kinh tế cơ bản',1,'3',3,1,2023);
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
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
