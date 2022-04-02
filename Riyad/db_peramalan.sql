-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_peramalan
CREATE DATABASE IF NOT EXISTS `db_peramalan` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_peramalan`;

-- Dumping structure for table db_peramalan.tbl_admin
CREATE TABLE IF NOT EXISTS `tbl_admin` (
  `id_admin` varchar(8) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_admin: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` (`id_admin`, `username`, `password`) VALUES
	('US001', 'admin', 'admin'),
	('US002', 'user', 'user'),
	('US003', 'moses', 'moses');
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_beli
CREATE TABLE IF NOT EXISTS `tbl_beli` (
  `kd_beli` varchar(8) NOT NULL,
  `kd_pemasok` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_beli` date NOT NULL,
  `jml_barang` int(9) NOT NULL,
  `harga` int(9) NOT NULL,
  PRIMARY KEY (`kd_beli`),
  KEY `kd_persediaan` (`kd_persediaan`),
  KEY `kd_pemasok` (`kd_pemasok`),
  CONSTRAINT `tbl_beli_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tbl_beli_ibfk_2` FOREIGN KEY (`kd_pemasok`) REFERENCES `tbl_pemasok` (`kd_pemasok`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_beli: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_beli` DISABLE KEYS */;
INSERT INTO `tbl_beli` (`kd_beli`, `kd_pemasok`, `kd_persediaan`, `tgl_beli`, `jml_barang`, `harga`) VALUES
	('B001', 'S001', 'K001', '2022-04-11', 20, 600000),
	('B002', 'S002', 'K003', '2022-05-12', 25, 55555),
	('B003', 'S001', 'K001', '2022-06-12', 30, 666),
	('B004', 'S003', 'K002', '2022-03-30', 12, 12000);
/*!40000 ALTER TABLE `tbl_beli` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_kategori
CREATE TABLE IF NOT EXISTS `tbl_kategori` (
  `kd_kategori` varchar(8) NOT NULL,
  `nama_kategori` varchar(25) NOT NULL,
  PRIMARY KEY (`kd_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_kategori: ~4 rows (approximately)
/*!40000 ALTER TABLE `tbl_kategori` DISABLE KEYS */;
INSERT INTO `tbl_kategori` (`kd_kategori`, `nama_kategori`) VALUES
	('J001', 'Semen 2 Roda'),
	('J002', 'Mahoni'),
	('J003', 'Bengkirai'),
	('J004', 'Semen 3 Roda');
/*!40000 ALTER TABLE `tbl_kategori` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_pakai
CREATE TABLE IF NOT EXISTS `tbl_pakai` (
  `kd_pakai` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_pakai` date NOT NULL,
  `jml_pakai` int(11) NOT NULL,
  PRIMARY KEY (`kd_pakai`),
  KEY `kd_persediaan` (`kd_persediaan`),
  CONSTRAINT `tbl_pakai_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_pakai: ~17 rows (approximately)
/*!40000 ALTER TABLE `tbl_pakai` DISABLE KEYS */;
INSERT INTO `tbl_pakai` (`kd_pakai`, `kd_persediaan`, `tgl_pakai`, `jml_pakai`) VALUES
	('P001', 'K001', '2021-05-01', 50),
	('P002', 'K001', '2021-06-01', 38),
	('P003', 'K001', '2021-07-01', 31),
	('P004', 'K001', '2021-08-01', 27),
	('P005', 'K001', '2021-09-01', 34),
	('P006', 'K001', '2021-10-01', 40),
	('P007', 'K001', '2021-11-01', 54),
	('P008', 'K001', '2021-12-01', 50),
	('P009', 'K001', '2022-01-01', 44),
	('P010', 'K001', '2022-02-01', 75),
	('P011', 'K001', '2022-03-01', 81),
	('P012', 'K001', '2022-04-01', 42),
	('P013', 'K002', '2022-04-01', 43),
	('P014', 'K002', '2022-05-01', 58),
	('P015', 'K002', '2022-06-01', 50),
	('P016', 'K002', '2022-07-01', 38),
	('P017', 'K002', '2022-08-01', 31);
/*!40000 ALTER TABLE `tbl_pakai` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_pemasok
CREATE TABLE IF NOT EXISTS `tbl_pemasok` (
  `kd_pemasok` varchar(8) NOT NULL,
  `nama_pemasok` varchar(25) NOT NULL,
  `alamat_pemasok` varchar(35) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `kota` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kd_pemasok`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_pemasok: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_pemasok` DISABLE KEYS */;
INSERT INTO `tbl_pemasok` (`kd_pemasok`, `nama_pemasok`, `alamat_pemasok`, `no_telepon`, `kota`) VALUES
	('S001', 'UD. Murah', 'Batang', '082138228410', 'Jakarta'),
	('S002', 'Nawa Raya', 'Pekalongan', '085728332525', 'Ambon'),
	('S003', 'PT. Riyad', 'Jalan Menuju Roma', 'Papua Barat', '081248666660');
/*!40000 ALTER TABLE `tbl_pemasok` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_peramalan
CREATE TABLE IF NOT EXISTS `tbl_peramalan` (
  `kd_peramalan` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_peramalan` date NOT NULL,
  `alpha` float NOT NULL,
  `mse` float NOT NULL,
  `hasil` int(8) NOT NULL,
  PRIMARY KEY (`kd_peramalan`),
  KEY `kd_persediaan` (`kd_persediaan`),
  CONSTRAINT `tbl_peramalan_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_peramalan: ~6 rows (approximately)
/*!40000 ALTER TABLE `tbl_peramalan` DISABLE KEYS */;
INSERT INTO `tbl_peramalan` (`kd_peramalan`, `kd_persediaan`, `tgl_peramalan`, `alpha`, `mse`, `hasil`) VALUES
	('F001', 'K001', '2022-03-10', 0.1, 267.833, 50),
	('F002', 'K001', '2022-04-11', 0.8, 249.833, 49),
	('F003', 'K001', '2022-05-17', 0.1, 267.833, 50),
	('F004', 'K001', '2022-05-18', 0.5, 242.583, 56),
	('F005', 'K001', '2022-05-22', 0.9, 253, 46),
	('F006', 'K002', '2022-06-04', 0.3, 107.4, 41);
/*!40000 ALTER TABLE `tbl_peramalan` ENABLE KEYS */;

-- Dumping structure for table db_peramalan.tbl_persediaan
CREATE TABLE IF NOT EXISTS `tbl_persediaan` (
  `kd_persediaan` varchar(8) NOT NULL,
  `kd_kategori` varchar(8) NOT NULL,
  `satuan` varchar(25) NOT NULL,
  `stok` int(8) NOT NULL,
  PRIMARY KEY (`kd_persediaan`),
  KEY `kd_kategori` (`kd_kategori`),
  CONSTRAINT `tbl_persediaan_ibfk_1` FOREIGN KEY (`kd_kategori`) REFERENCES `tbl_kategori` (`kd_kategori`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_peramalan.tbl_persediaan: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_persediaan` DISABLE KEYS */;
INSERT INTO `tbl_persediaan` (`kd_persediaan`, `kd_kategori`, `satuan`, `stok`) VALUES
	('K001', 'J001', '400x2x20cm', 43),
	('K002', 'J002', '400x4x12cm', 42),
	('K003', 'J003', '400x8x12cm', 40),
	('K004', 'J002', '12', 13);
/*!40000 ALTER TABLE `tbl_persediaan` ENABLE KEYS */;

-- Dumping structure for trigger db_peramalan.INPUT_BELI
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `INPUT_BELI` BEFORE INSERT ON `tbl_beli` FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok+NEW.jml_barang  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger db_peramalan.INPUT_PAKAI
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `INPUT_PAKAI` AFTER INSERT ON `tbl_pakai`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok-NEW.jml_pakai  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger db_peramalan.UPDATE_BELI
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `UPDATE_BELI` AFTER UPDATE ON `tbl_beli` FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok-(OLD.jml_barang-NEW.jml_barang)  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger db_peramalan.UPDATE_PAKAI
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `UPDATE_PAKAI` AFTER UPDATE ON `tbl_pakai`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok+(OLD.jml_pakai-NEW.jml_pakai)  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */