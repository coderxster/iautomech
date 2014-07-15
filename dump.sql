-- MySQL dump 10.13  Distrib 5.5.28, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `manufacturer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20864 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (385,'Max','96082554','Dell',NULL),(2781,'Marcelo-33','555-33','Walbro-33',NULL),(2782,'Marcelo-34','555-34','Walbro-34',NULL),(2784,'Marcelo-36','555-36','Walbro-36',NULL),(2785,'Marcelo-37','555-37','Walbro-37',NULL),(2786,'Marcelo-38','555-38','Walbro-38',NULL),(2787,'Marcelo-39','555-39','Walbro-39',NULL),(2788,'Marcelo-40','555-40','Walbro-40',NULL),(2789,'Marcelo-41','555-41','Walbro-41',NULL),(2790,'Marcelo-42','555-42','Walbro-42',NULL),(2791,'Marcelo-43','555-43','Walbro-43',NULL),(2792,'Marcelo-44','555-44','Walbro-44',NULL),(2793,'Marcelo-45','555-45','Walbro-45',NULL),(2794,'Marcelo-46','555-46','Walbro-46',NULL),(2795,'Marcelo-47','555-47','Walbro-47',NULL),(2796,'Marcelo-48','555-48','Walbro-48',NULL),(2797,'Marcelo-49','555-49','Walbro-49',NULL),(2798,'Marcelo-50','555-50','Walbro-50',NULL),(2799,'Marcelo-51','555-51','Walbro-51',NULL),(2800,'Marcelo-52','555-52','Walbro-52',NULL),(2801,'Marcelo-53','555-53','Walbro-53',NULL),(2802,'Marcelo-54','555-54','Walbro-54',NULL),(2803,'Marcelo-55','555-55','Walbro-55',NULL),(2804,'Marcelo-56','555-56','Walbro-56',NULL),(2805,'Marcelo-57','555-57','Walbro-57',NULL),(2806,'Marcelo-58','555-58','Walbro-58',NULL),(2807,'Marcelo-59','555-59','Walbro-59',NULL),(2808,'Marcelo-60','555-60','Walbro-60',NULL),(2809,'Marcelo-61','555-61','Walbro-61',NULL),(2810,'Marcelo-62','555-62','Walbro-62',NULL),(2811,'Marcelo-63','555-63','Walbro-63',NULL),(2812,'Marcelo-64','555-64','Walbro-64',NULL),(2813,'Marcelo-65','555-65','Walbro-65',NULL),(2814,'Marcelo-66','555-66','Walbro-66',NULL),(2815,'Marcelo-67','555-67','Walbro-67',NULL),(2816,'Marcelo-68','555-68','Walbro-68',NULL),(2817,'Marcelo-69','555-69','Walbro-69',NULL),(2818,'Marcelo-70','555-70','Walbro-70',NULL),(2819,'Marcelo-71','555-71','Walbro-71',NULL),(2820,'Marcelo-72','555-72','Walbro-72',NULL),(2821,'Marcelo-73','555-73','Walbro-73',NULL),(2822,'Marcelo-74','555-74','Walbro-74',NULL),(2823,'Marcelo-75','555-75','Walbro-75',NULL),(2824,'Marcelo-76','555-76','Walbro-76',NULL),(2825,'Marcelo-77','555-77','Walbro-77',NULL),(2828,'Marcelo-80','555-80','Walbro-80',NULL),(2829,'Marcelo-81','555-81','Walbro-81',NULL),(2830,'Marcelo-82','555-82','Walbro-82',NULL),(2831,'Marcelo-83','555-83','Walbro-83',NULL),(2832,'Marcelo-84','555-84','Walbro-84',NULL),(2833,'Marcelo-85','555-85','Walbro-85',NULL),(2834,'Marcelo-86','555-86','Walbro-86',NULL),(2835,'Marcelo-87','555-87','Walbro-87',NULL),(2836,'Marcelo-88','555-88','Walbro-88',NULL),(2837,'Marcelo-89','555-89','Walbro-89',NULL),(2838,'Marcelo-90','555-90','Walbro-90',NULL),(2839,'Marcelo-91','555-91','Walbro-91',NULL),(2840,'Marcelo-92','555-92','Walbro-92',NULL),(2841,'Marcelo-93','555-93','Walbro-93',NULL),(2842,'Marcelo-94','555-94','Walbro-94',NULL),(2843,'Marcelo-95','555-95','Walbro-95',NULL),(2844,'Marcelo-96','555-96','Walbro-96',NULL),(2845,'Marcelo-97','555-97','Walbro-97',NULL),(2846,'Marcelo-98','555-98','Walbro-98',NULL),(2847,'Marcelo-99','555-99','Walbro-99',NULL),(2848,'Marcelo-100','555-100','Walbro-100',NULL),(2849,'Marcelo-101','555-101','Walbro-101',NULL),(2850,'Marcelo-102','555-102','Walbro-102',NULL),(2851,'Marcelo-103','555-103','Walbro-103',NULL),(2852,'Marcelo-104','555-104','Walbro-104',NULL),(2853,'Marcelo-105','555-105','Walbro-105',NULL),(2854,'Marcelo-106','555-106','Walbro-106',NULL),(2855,'Marcelo-107','555-107','Walbro-107',NULL),(2856,'Marcelo-108','555-108','Walbro-108',NULL),(2857,'Marcelo-109','555-109','Walbro-109',NULL),(2858,'Marcelo-110','555-110','Walbro-110',NULL),(2859,'Marcelo-111','555-111','Walbro-111',NULL),(2860,'Marcelo-112','555-112','Walbro-112',NULL),(2861,'Marcelo-113','555-113','Walbro-113',NULL),(2862,'Marcelo-114','555-114','Walbro-114',NULL),(2863,'Marcelo-115','555-115','Walbro-115',NULL),(2864,'Marcelo-116','555-116','Walbro-116',NULL),(2865,'Marcelo-117','555-117','Walbro-117',NULL),(2866,'Marcelo-118','555-118','Walbro-118',NULL),(2867,'Marcelo-119','555-119','Walbro-119',NULL),(2868,'Marcelo-120','555-120','Walbro-120',NULL),(2869,'Marcelo-121','555-121','Walbro-121',NULL),(2870,'Marcelo-122','555-122','Walbro-122',NULL),(2871,'Marcelo-123','555-123','Walbro-123',NULL),(2872,'Marcelo-124','555-124','Walbro-124',NULL),(2873,'Marcelo-125','555-125','Walbro-125',NULL),(2874,'Marcelo-126','555-126','Walbro-126',NULL),(2875,'Marcelo-127','555-127','Walbro-127',NULL),(2876,'Marcelo-128','555-128','Walbro-128',NULL),(2877,'Marcelo-129','555-129','Walbro-129',NULL),(2878,'Marcelo-130','555-130','Walbro-130',NULL),(2879,'Marcelo-131','555-131','Walbro-131',NULL),(2880,'Marcelo-132','555-132','Walbro-132',NULL),(2881,'Marcelo-133','555-133','Walbro-133',NULL),(2882,'Marcelo-134','555-134','Walbro-134',NULL),(2883,'Marcelo-135','555-135','Walbro-135',NULL),(2884,'Marcelo-136','555-136','Walbro-136',NULL),(2885,'Marcelo-137','555-137','Walbro-137',NULL),(2886,'Marcelo-138','555-138','Walbro-138',NULL),(2887,'Marcelo-139','555-139','Walbro-139',NULL),(2888,'Marcelo-140','555-140','Walbro-140',NULL),(2889,'Marcelo-141','555-141','Walbro-141',NULL),(2890,'Marcelo-142','555-142','Walbro-142',NULL),(2891,'Marcelo-143','555-143','Walbro-143',NULL),(2892,'Marcelo-144','555-144','Walbro-144',NULL),(2893,'Marcelo-145','555-145','Walbro-145',NULL),(2894,'Marcelo-146','555-146','Walbro-146',NULL),(2895,'Marcelo-147','555-147','Walbro-147',NULL),(2896,'Marcelo-148','555-148','Walbro-148',NULL),(2897,'Marcelo-149','555-149','Walbro-149',NULL),(2898,'Marcelo-150','555-150','Walbro-150',NULL),(2899,'Marcelo-151','555-151','Walbro-151',NULL),(2900,'Marcelo-152','555-152','Walbro-152',NULL),(2901,'Marcelo-153','555-153','Walbro-153',NULL),(2902,'Marcelo-154','555-154','Walbro-154',NULL),(2903,'Marcelo-155','555-155','Walbro-155',NULL),(2904,'Marcelo-156','555-156','Walbro-156',NULL),(2905,'Marcelo-157','555-157','Walbro-157',NULL),(2906,'Marcelo-158','555-158','Walbro-158',NULL),(2907,'Marcelo-159','555-159','Walbro-159',NULL),(2908,'Marcelo-160','555-160','Walbro-160',NULL),(2909,'Marcelo-161','555-161','Walbro-161',NULL),(2910,'Marcelo-162','555-162','Walbro-162',NULL),(2911,'Marcelo-163','555-163','Walbro-163',NULL),(2912,'Marcelo-164','555-164','Walbro-164',NULL),(2913,'Marcelo-165','555-165','Walbro-165',NULL),(2914,'Marcelo-166','555-166','Walbro-166',NULL),(2915,'Marcelo-167','555-167','Walbro-167',NULL),(2916,'Marcelo-168','555-168','Walbro-168',NULL),(2917,'Marcelo-169','555-169','Walbro-169',NULL),(2918,'Marcelo-170','555-170','Walbro-170',NULL),(2919,'Marcelo-171','555-171','Walbro-171',NULL),(2939,'Marcelo-191','555-191','Walbro-191',NULL),(2940,'Marcelo-192','555-192','Walbro-192',NULL),(2941,'Marcelo-193','555-193','Walbro-193',NULL),(2942,'Marcelo-194','555-194','Walbro-194',NULL),(2943,'Marcelo-195','555-195','Walbro-195',NULL),(2944,'Marcelo-196','555-196','Walbro-196',NULL),(2945,'Marcelo-197','555-197','Walbro-197',NULL),(2946,'Marcelo-198','555-198','Walbro-198',NULL),(2947,'Marcelo-199','555-199','Walbro-199',NULL),(17559,'testst','234234','tettes',NULL);
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `part_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manufacturer_id` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `sku` varchar(80) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model_no` varchar(255) DEFAULT NULL,
  `part_no` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`part_id`),
  KEY `manuf_idx` (`manufacturer_id`),
  CONSTRAINT `part_ibfk_1` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (170,2781,'Zama carb kit z14','SK32123','2014-07-07 11:41:56',NULL,NULL,NULL,NULL,NULL),(402,385,'asdfsa','asdfsadf','2014-07-14 16:57:01',NULL,NULL,NULL,NULL,NULL),(403,2785,'asdfsadf','sadf','2014-07-14 16:58:54',NULL,NULL,NULL,NULL,NULL),(404,385,'Gasket kit K-12','S521564','2014-07-15 09:33:25',NULL,NULL,NULL,NULL,NULL),(416,2786,'','','2014-07-15 10:23:36',NULL,NULL,'','',NULL),(453,385,'MyPart','Sku123','2014-07-15 11:50:00','This is a test',NULL,'333','243324',5),(454,385,'MyPart','Sku123','2014-07-15 11:50:25','This is a test',NULL,'333','243324',5),(455,385,'MyPart','Sku123','2014-07-15 11:50:30','This is a test',NULL,'333','243324',5);
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `selectedIds` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'last','mars','pass','mars',NULL),(2,'Admin','last','admin','admin',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK143BF46A4E31029B` (`role_id`),
  KEY `FK143BF46AF35BC67B` (`user_id`),
  CONSTRAINT `FK143BF46A4E31029B` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK143BF46AF35BC67B` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-15 12:06:21
