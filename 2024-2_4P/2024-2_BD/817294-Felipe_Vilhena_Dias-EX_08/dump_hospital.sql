/*!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.11.8-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Hospital
-- ------------------------------------------------------
-- Server version	10.11.8-MariaDB-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `Ambulatorios`
--

LOCK TABLES `Ambulatorios` WRITE;
/*!40000 ALTER TABLE `Ambulatorios` DISABLE KEYS */;
INSERT INTO `Ambulatorios` VALUES
(1,'Ambulatório 1'),
(2,'Ambulatório 2'),
(3,'Ambulatório 3'),
(4,'Ambulatório 4');
/*!40000 ALTER TABLE `Ambulatorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Consultas`
--

LOCK TABLES `Consultas` WRITE;
/*!40000 ALTER TABLE `Consultas` DISABLE KEYS */;
INSERT INTO `Consultas` VALUES
(1,1,1,'2024-10-24'),
(2,2,2,'2024-10-25'),
(3,3,1,'2024-10-26');
/*!40000 ALTER TABLE `Consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Medicos`
--

LOCK TABLES `Medicos` WRITE;
/*!40000 ALTER TABLE `Medicos` DISABLE KEYS */;
INSERT INTO `Medicos` VALUES
(1,'Dr. João','Cardiologia',3),
(2,'Dra. Maria','Pediatria',3),
(3,'Dr. Carlos','Ortopedia',3);
/*!40000 ALTER TABLE `Medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Pacientes`
--

LOCK TABLES `Pacientes` WRITE;
/*!40000 ALTER TABLE `Pacientes` DISABLE KEYS */;
INSERT INTO `Pacientes` VALUES
(1,'Pedro da Silva',30),
(2,'José Lima',45);
/*!40000 ALTER TABLE `Pacientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-24 21:15:02
