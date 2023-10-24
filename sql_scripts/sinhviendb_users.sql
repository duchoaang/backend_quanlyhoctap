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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mssv` bigint DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_role` varchar(255) NOT NULL,
  `ngay_tham_gia` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,2051052047,'hoang','hoangbrato@gmail.com',0,'hoang','$2a$10$EFy7Up7D5Yi8oGwGz1q6jeWpzLEXcAGQBr12ssijlvCDexLymxRhm','ADMIN','2023-10-06 15:20:14'),(2,2051052096,'phat','phat@gmail.com',1,'phat','$2a$10$EFy7Up7D5Yi8oGwGz1q6jeWpzLEXcAGQBr12ssijlvCDexLymxRhm','USER','2023-10-06 15:20:14'),(3,2051052022,'hoang 3','123132@gmail.com',1,'user3','$2a$10$EFy7Up7D5Yi8oGwGz1q6jeWpzLEXcAGQBr12ssijlvCDexLymxRhm','ADMIN','2023-10-09 15:54:23'),(4,2123,'hoang','hoang@gma',1,'hoangmm','$2a$10$XIh9ROrAD4VYTpAZ3bNbWerLiRf6ypBboN/joIchjdra3//el3bmi','USER','2023-10-13 22:24:20'),(5,123,'123','123@gmail.com',1,'123','$2a$10$S/ONT60nKakXkHbVcLt6JOAZDLi7EAcEEAQrIv2k3wt6MXgqTuKJe','USER','2023-10-13 22:29:24'),(6,123,'123','123@123',0,'user31','$2a$10$ZEjE9AYfygESPEGoS2A/.uGmoV5bfb0CXqmsMTmtmanip.VmxJV4G','USER','2023-10-13 22:42:37'),(7,123,'123','123@123',1,'user33','$2a$10$VdJPqU9Reu0u5zBWdYHUJudIfUSWUpE/o5t8tGLGRQMeRCSpgtc0S','USER','2023-10-13 23:01:40'),(8,205102,'Haong','new@gmail.com',1,'new123','$2a$10$1EzhNrM2LgN.r7XyahCHJuhtVR.z9Rq8WxmQQs8IDgTOnTI6BAf7y','USER','2023-10-22 11:18:49'),(9,205102,'Haong','new@gmail.com',1,'new123','$2a$10$oj3rbOtvfbFual8YPx789OzYngBtp0A3GZtTfbCL3fY1NgZ9xKYGa','USER','2023-10-22 11:18:50'),(10,2051021,'new2','new22@gmail.com',1,'new2','$2a$10$SBParJyutixZ06wIrn0bf.wKQ3KVSKqVTpqqPdeBfEnGCoMU/8ZsW','USER','2023-10-22 11:22:23'),(11,2051021,'new2','new22@gmail.com',1,'new2','$2a$10$TPoP8JaDgtXQoIoWXhd7ouZE9HOz52GwEQCngQB3iQ3Sn7IOeayxu','USER','2023-10-22 11:22:24'),(12,205102378,'phatnew','2051052096phat@ou.edu.vn',1,'phatnew3','$2a$10$kGqCfgJeCC6NIHFO58RTT.8v59gY1x6UVYHrWTEbAtzF2wjn9cFwK','USER','2023-10-22 11:24:36'),(13,20510520482,'Phát','2051052047hoangg@ou.edu.vn',1,'new4','$2a$10$jH461sOdTk6/dAqvyrpVcetorlKWgUv4Z4yn2ab5ubIYpFS5isM0W','USER','2023-10-22 11:27:31'),(14,205105204821,'1212','2051052047hoang11@ou.edu.vn',1,'new5','$2a$10$h/m1Fbg6dFnmBv8HSHxKheFM8c1NFrAA4MQR4v5BBQ8nZlk2hbWNK','USER','2023-10-22 14:17:53'),(15,2051052047,'hoang','hoangnew',1,'newqw','$2a$10$0ioQwN0lK892rMZ1fkFmE.m5CiMbLow84/f03IhiMj9rSmc5gnz5a','USER','2023-10-22 15:56:56'),(16,2051052048212,'Phát','2051052047hoang@ou.edu.vn',1,'user3a','$2a$10$hrvSJtOpmS.P/XruicECfOezOqiKnlno2EWbrrZc3jXFp4ihDo2US','USER','2023-10-23 10:10:05');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
