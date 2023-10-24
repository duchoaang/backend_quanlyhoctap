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
-- Table structure for table `baitap`
--

DROP TABLE IF EXISTS `baitap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baitap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_bai_tap` varchar(255) NOT NULL,
  `noi_dung` varchar(255) NOT NULL,
  `dap_an` varchar(255) DEFAULT NULL,
  `monhoc_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `monhoc_id` (`monhoc_id`),
  CONSTRAINT `baitap_ibfk_1` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baitap`
--

LOCK TABLES `baitap` WRITE;
/*!40000 ALTER TABLE `baitap` DISABLE KEYS */;
INSERT INTO `baitap` VALUES (2,'Bài tập 1','Tìm số lớn nhất trong danh sách sau: [12, 34, 56, 78, 90].','90',1),(3,'Bài tập 2','Tính tổng của các số nguyên trong danh sách sau: [1, 2, 3, 4, 5].','15',1),(4,'Bài tập 3','Tìm số nhỏ nhất trong danh sách sau: [5, 2, 9, 8, 1]','1',2),(5,'Bài tập 4','Đảo ngược danh sách sau: [1, 2, 3, 4, 5].','[5, 4, 3, 2, 1]',2),(23,'Bài tập 5','Viết chương trình Java in ra các số nguyên từ 1 đến 20.','Bài toán yêu cầu viết chương trình Java để in ra các số từ 1 đến 20.',13),(24,'Bài tập 6','Viết chương trình C++ in ra bảng cửu chương 7.','Bài toán yêu cầu viết chương trình C++ để in ra bảng cửu chương của số 7.',14),(25,'Bài tập 7','Tính diện tích hình tròn có bán kính 5.','78.5',14),(26,'Bài tập 8','Viết chương trình Python kiểm tra số nguyên tố.','Bài toán yêu cầu viết chương trình Python để kiểm tra xem một số có phải là số nguyên tố hay không.',15),(27,'Bài tập 9','Viết chương trình Java sắp xếp một danh sách số nguyên theo thứ tự tăng dần.','Bài toán yêu cầu viết chương trình Java để sắp xếp một danh sách số nguyên theo thứ tự tăng dần.',16),(28,'Bài tập 10','Tìm giá trị lớn thứ hai trong một danh sách số nguyên.','Bài toán yêu cầu viết chương trình để tìm giá trị lớn thứ hai trong một danh sách số nguyên.',17),(29,'Bài tập 11','Tìm ước chung lớn nhất của hai số nguyên.','Bài toán yêu cầu viết chương trình để tìm ước chung lớn nhất của hai số nguyên.',18),(30,'Bài tập 12','Tìm bội chung nhỏ nhất của hai số nguyên.','Bài toán yêu cầu viết chương trình để tìm bội chung nhỏ nhất của hai số nguyên.',19),(31,'Bài tập 13','Viết chương trình Python tính tổng các số chẵn từ 1 đến n.','Bài toán yêu cầu viết chương trình Python để tính tổng các số chẵn từ 1 đến n.',20),(32,'Bài tập 14','Viết chương trình Java đảo ngược một chuỗi.','Bài toán yêu cầu viết chương trình Java để đảo ngược một chuỗi.',21),(33,'Bài tập 15','Viết chương trình C++ kiểm tra một số có phải là số Armstrong hay không.','Bài toán yêu cầu viết chương trình C++ để kiểm tra xem một số có phải là số Armstrong hay không.',21),(34,'Bài tập 16','Tính diện tích tam giác khi biết độ dài ba cạnh.','Bài toán yêu cầu tính diện tích tam giác dựa trên độ dài của ba cạnh.',22),(35,'Bài tập 17','Viết chương trình Python tìm số Fibonaci thứ n.','Bài toán yêu cầu viết chương trình Python để tìm số Fibonaci thứ n.',17),(36,'Bài tập 18','Viết chương trình Java tìm số nguyên tố thứ n.','Bài toán yêu cầu viết chương trình Java để tìm số nguyên tố thứ n.',16),(37,'123','Tìm số lớn thứ hai trong một danh sách số thực.','A',15),(50,'newq','123','123',17),(52,'Bài tập 19','What is your name?','Hoang',15),(54,'bam','new1','12',1),(55,'bam','new1','12',1),(57,'1231','1231','12123',19),(58,'Bai tap moi','1','123',14),(59,'Bai tap moi update','123','1',13),(60,'Bai tap moi','5s','1',20),(61,'Bai tap moi','123','123',1);
/*!40000 ALTER TABLE `baitap` ENABLE KEYS */;
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
