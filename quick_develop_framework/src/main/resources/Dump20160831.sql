-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 10.1.228.202    Database: devrdb21
-- ------------------------------------------------------
-- Server version	5.6.21-70.1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_route`
--

DROP TABLE IF EXISTS `sys_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requesttype` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `route` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_route`
--

LOCK TABLES `sys_route` WRITE;
/*!40000 ALTER TABLE `sys_route` DISABLE KEYS */;
INSERT INTO `sys_route` VALUES (1,'[]','/'),(2,'[]','/message'),(3,'[]','/index/abc'),(4,'[]','/index'),(5,'[]','/error'),(6,'[]','/error');
/*!40000 ALTER TABLE `sys_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_route_rule`
--

DROP TABLE IF EXISTS `sys_route_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_route_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `routename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) NOT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm0ah1rr3x1nwlyspog18q6pkr` (`route_id`),
  CONSTRAINT `FKm0ah1rr3x1nwlyspog18q6pkr` FOREIGN KEY (`route_id`) REFERENCES `sys_route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_route_rule`
--

LOCK TABLES `sys_route_rule` WRITE;
/*!40000 ALTER TABLE `sys_route_rule` DISABLE KEYS */;
INSERT INTO `sys_route_rule` VALUES (1,'index',2,1),(2,'msg',2,2);
/*!40000 ALTER TABLE `sys_route_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_route_rule_sys_role_list`
--

DROP TABLE IF EXISTS `sys_route_rule_sys_role_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_route_rule_sys_role_list` (
  `sys_route_rule_id` bigint(20) NOT NULL,
  `sys_role_list_id` bigint(20) NOT NULL,
  KEY `FKckh3foi612daxjuymqgwjvfie` (`sys_role_list_id`),
  KEY `FKrs587ix9v8n2a8cl9y91tsf8i` (`sys_route_rule_id`),
  CONSTRAINT `FKckh3foi612daxjuymqgwjvfie` FOREIGN KEY (`sys_role_list_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKrs587ix9v8n2a8cl9y91tsf8i` FOREIGN KEY (`sys_route_rule_id`) REFERENCES `sys_route_rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_route_rule_sys_role_list`
--

LOCK TABLES `sys_route_rule_sys_role_list` WRITE;
/*!40000 ALTER TABLE `sys_route_rule_sys_role_list` DISABLE KEYS */;
INSERT INTO `sys_route_rule_sys_role_list` VALUES (1,1),(2,1),(1,2);
/*!40000 ALTER TABLE `sys_route_rule_sys_role_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'hb','hb'),(2,'zzk','zzk');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  KEY `FKd0ut7sloes191bygyf7a3pk52` (`sys_user_id`),
  CONSTRAINT `FKd0ut7sloes191bygyf7a3pk52` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKdpvc6d7xqpqr43dfuk1s27cqh` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
INSERT INTO `sys_user_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 14:49:26
