-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `demo_article`
--

DROP TABLE IF EXISTS `demo_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo_article` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(30) NOT NULL,
  `headline` varchar(255) NOT NULL,
  `overview` varchar(255) NOT NULL,
  `conclusion` varchar(255) NOT NULL,
  `status` enum('active','inactive','deleted') DEFAULT 'active',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  `visited` bigint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo_article`
--

LOCK TABLES `demo_article` WRITE;
/*!40000 ALTER TABLE `demo_article` DISABLE KEYS */;
INSERT INTO `demo_article` VALUES (62,'1638446768584','How to configure Spring Boot Application with very less configuration','Generally Spring Boot application need an extra class to initialise all static bean in application. Here I am going to explain how to remove this extra class and do same thing in main class.','Here I have tryied to exlain in a very neat and clean way, how to remove extra class for beans initialization and do samething in main class.','active','2021-12-02 12:06:09',NULL,'2021-12-02 12:06:29',NULL,6);
/*!40000 ALTER TABLE `demo_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo_article_body`
--

DROP TABLE IF EXISTS `demo_article_body`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo_article_body` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `statement` text NOT NULL,
  `article_id` bigint unsigned DEFAULT NULL,
  `article_order` bigint unsigned DEFAULT NULL,
  `status` enum('active','inactive','deleted') DEFAULT 'active',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `demo_article_body_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `demo_article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo_article_body`
--

LOCK TABLES `demo_article_body` WRITE;
/*!40000 ALTER TABLE `demo_article_body` DISABLE KEYS */;
INSERT INTO `demo_article_body` VALUES (80,'Create Spring Boot Main Class','Every Spring Boot application have main class. This is the entry point for whole application.','public class Application {\n\n    public static void main(String[] args) {\n        SpringApplication.run(Application.class, args);\n    }\n}',62,0,'active','2021-12-02 12:06:09',NULL,'2021-12-02 12:06:08',NULL),(81,'Add annotation to scan Base Package and Entity Package','Base package inform Spring Boot to locate and register all the Spring components in the package like Service and Repository. The Base Package should cover all you application, if you have multiple base package then add all with comma separate. Entity package inform Spring boot to locate and register all the database entity model.','@EntityScan(basePackages = {\"com.spring.demo.model\"})\n@SpringBootApplication(scanBasePackages = { \"com.spring.demo\"})\npublic class Application {\n\n    public static void main(String[] args) {\n        SpringApplication.run(Application.class, args);\n    }\n}',62,1,'active','2021-12-02 12:06:09',NULL,'2021-12-02 12:06:08',NULL);
/*!40000 ALTER TABLE `demo_article_body` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo_config`
--

DROP TABLE IF EXISTS `demo_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo_config` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `status` enum('active','inactive','deleted') DEFAULT 'active',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo_config`
--

LOCK TABLES `demo_config` WRITE;
/*!40000 ALTER TABLE `demo_config` DISABLE KEYS */;
INSERT INTO `demo_config` VALUES (1,'INTERNAL_AUTH_KEY_SYSTEM','qwertyuioplkjhgfdsazxcvbnm','active','2021-11-06 14:24:00','sandeshk','2021-11-06 14:24:00','sandeshk'),(2,'USERNAME_SYSTEM','sandesku','active','2021-11-23 04:10:25','sandeshk','2021-11-23 04:10:25','sandeshk'),(3,'PASSWORD_SYSTEM','7e0630c4113148e7446a4345a2d7ecf9d2d7d13eaaec785a611a7fd12592276c','active','2021-11-23 04:10:26','sandeshk','2021-11-24 12:24:11','sandeshk');
/*!40000 ALTER TABLE `demo_config` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-02 17:36:46
