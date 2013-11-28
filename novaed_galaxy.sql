-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.0.27-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for novaed_galaxy
DROP DATABASE IF EXISTS `novaed_galaxy`;
CREATE DATABASE IF NOT EXISTS `novaed_galaxy` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `novaed_galaxy`;


-- Dumping structure for table novaed_galaxy.login
DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '0',
  `password` varchar(50) NOT NULL default '0',
  `user_type` varchar(50) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table novaed_galaxy.login: ~6 rows (approximately)
DELETE FROM `login`;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`id`, `username`, `password`, `user_type`) VALUES
	(1, '00196', '00196', 'student'),
	(2, '00260', '00260', 'student'),
	(3, '00120', '00120', 'student'),
	(4, 'administrator', 'adminadmin', 'admin'),
	(5, 'newadmin', 'newadmin', 'admin'),
	(6, 'robert.baratheon', 'oursisthefury', 'admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


-- Dumping structure for table novaed_galaxy.personal_info
DROP TABLE IF EXISTS `personal_info`;
CREATE TABLE IF NOT EXISTS `personal_info` (
  `id` int(10) NOT NULL auto_increment,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `school` varchar(255) default NULL,
  `login_id` int(10) default NULL,
  `contact_number` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `login_id` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table novaed_galaxy.personal_info: ~1 rows (approximately)
DELETE FROM `personal_info`;
/*!40000 ALTER TABLE `personal_info` DISABLE KEYS */;
INSERT INTO `personal_info` (`id`, `first_name`, `last_name`, `school`, `login_id`, `contact_number`) VALUES
	(1, 'Robert', 'Baratheon', 'Storm\'s End', 6, '12412293');
/*!40000 ALTER TABLE `personal_info` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
login