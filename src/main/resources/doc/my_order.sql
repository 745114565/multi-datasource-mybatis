/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.13-log : Database - my_order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`my_order` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `my_order`;

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(64) DEFAULT NULL,
  `order_num` varchar(64) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

insert  into `tb_order`(`id`,`user_id`,`order_num`,`product_name`) values (1,'23','we','wer'),(2,'23','23c','vvd');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
