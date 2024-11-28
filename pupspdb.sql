-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: pupspdb
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cost` int DEFAULT NULL,
  `issueDate` date DEFAULT NULL,
  `expirationDate` date DEFAULT NULL,
  `payDone` int DEFAULT NULL,
  `users_id` int NOT NULL,
  `companyUtilities_id` int NOT NULL,
  `houses_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bills_users1_idx` (`users_id`),
  KEY `fk_bills_companyUtilities1_idx` (`companyUtilities_id`),
  KEY `fk_bills_houses1_idx` (`houses_id`),
  CONSTRAINT `fk_bills_companyUtilities1` FOREIGN KEY (`companyUtilities_id`) REFERENCES `companyutilities` (`id`),
  CONSTRAINT `fk_bills_houses1` FOREIGN KEY (`houses_id`) REFERENCES `houses` (`id`),
  CONSTRAINT `fk_bills_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (7,150000,'2024-08-15','2024-09-15',1,2,2,2),(8,80000,'2024-07-20','2024-08-20',1,3,3,3),(9,30000,'2024-09-10','2024-10-10',1,4,1,4),(10,200000,'2024-08-01','2024-08-31',1,5,2,5),(11,250000,'2024-11-25','2024-11-30',0,4,2,4),(12,250000,'2024-11-25','2024-11-30',1,4,1,4),(13,290000,'2024-11-27','2024-12-25',0,4,1,4),(14,1200000,'2024-11-27','2024-12-25',0,4,5,4);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyutilities`
--

DROP TABLE IF EXISTS `companyutilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companyutilities` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyutilities`
--

LOCK TABLES `companyutilities` WRITE;
/*!40000 ALTER TABLE `companyutilities` DISABLE KEYS */;
INSERT INTO `companyutilities` VALUES (1,'Aguas Metropolitanas'),(2,'Energía Cúcuta'),(3,'Gas Natural Cúcuta'),(4,'Internet Cúcuta'),(5,'Televisión Cúcuta');
/*!40000 ALTER TABLE `companyutilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `paymentDate` date DEFAULT NULL,
  `paymentmethod` varchar(45) DEFAULT NULL,
  `bills_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_history_bills1_idx` (`bills_id`),
  CONSTRAINT `fk_history_bills1` FOREIGN KEY (`bills_id`) REFERENCES `bills` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (2,'2024-09-17','Débito',7),(3,'2024-08-25','Transferencia',8),(4,'2024-10-01','Efectivo',9),(5,'2024-09-12','Tarjeta de débito',10),(16,'2024-11-28','Efectivo',12);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `houses`
--

DROP TABLE IF EXISTS `houses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `houses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adress` varchar(45) DEFAULT NULL,
  `municipio` varchar(100) DEFAULT 'Cucuta',
  `tipo` tinyint(1) NOT NULL DEFAULT '0',
  `users_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_houses_users_idx` (`users_id`),
  CONSTRAINT `fk_houses_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES (2,'San Martín, Calle 12a #8c-34','Cúcuta',0,2),(3,'El Prado, Manzana 18b #10a-57\n','Cúcuta',0,3),(4,'Montebello 1, Calle 13b #11a-47','Cúcuta',0,4),(5,'Villa Esperanza, Avenida 5d #6b-19','Cúcuta',0,5),(6,'Los Robles, Calle 9c #14a-76','Los Patios',0,1002133399),(7,'Popular, Avenida 12 #123-4','Cúcuta',1,1002133399);
/*!40000 ALTER TABLE `houses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `massage` varchar(255) DEFAULT NULL,
  `chipingDate` date DEFAULT NULL,
  `type` tinyint(1) NOT NULL,
  `users_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_notifications_users1_idx` (`users_id`),
  CONSTRAINT `fk_notifications_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'Tu factura de agua está lista para pagar','2024-09-01',0,1),(2,'Recuerda pagar tu recibo de energía antes del 15 de septiembre','2024-08-10',0,2),(3,'Nuevo recibo de gas disponible','2024-07-20',0,3),(4,'Notificación de vencimiento de factura de internet','2024-09-10',0,4),(5,'Tu recibo de televisión está por vencer','2024-08-01',0,5),(6,'Nueva factura creada con ID: 0 de la empresa: Televisión Cúcuta y con una fecha de vencimiento de 2024-12-25 ¡Revisala cuanto antes!','2024-11-27',1,4);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `lastName` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registerDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'juan','Pérez','juan.perez@example.com','password123','2024-11-27'),(2,'Ana','Gómez','ana.gomez@example.com','password456','2024-06-15'),(3,'Luis','Rodríguez','luis.rodriguez@example.com','password789','2024-07-10'),(4,'María','Díaz','maria.diaz@example.com','password012','2024-08-05'),(5,'Carlos','Martínez','carlos.martinez@example.com','password345','2024-08-20'),(123456789,'alberto','perez','poraqi@marpzon.com','12345678','2024-11-27'),(1002133399,'Bryan','Cortine','bryamcortine17@gmail.com','12345678','2024-11-24'),(1143234272,'Dilan','Cortine','correo@correo.com','12345678','2024-11-25');
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

-- Dump completed on 2024-11-28  0:02:06
