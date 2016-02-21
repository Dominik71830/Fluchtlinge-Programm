#DROP SCHEMA IF EXISTS `tempbaza` ;
CREATE SCHEMA IF NOT EXISTS `tempbaza` DEFAULT CHARACTER SET utf8 ;
USE `tempbaza` ;

DROP TABLE IF EXISTS `tempbaza`.`logi` ;
DROP TABLE IF EXISTS `tempbaza`.`miasta` ;
DROP TABLE IF EXISTS `tempbaza`.`uchodzcy` ;

CREATE TABLE IF NOT EXISTS `tempbaza`.`logi` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_obiektu` INT(11) NOT NULL references tempbaza.uchodzcy(id),
  `data_powstania` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `akcja` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `tempbaza`.`miasta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(30) NOT NULL,
  `kod_pocztowy` VARCHAR(30) NOT NULL,
  `liczba_uchodzcow` INT(11) NULL DEFAULT NULL,
  `czy_przyjmuje` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `tempbaza`.`uchodzcy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(15) NOT NULL,
  `nazwisko` VARCHAR(15) NOT NULL,
  `data_urodzenia` VARCHAR(10) NULL DEFAULT NULL,
  `plec` VARCHAR(15) NOT NULL,
  `kraj_pochodzenia` VARCHAR(30) NOT NULL,
  `zasilek` DOUBLE NULL DEFAULT NULL,
  `przydzielone_miasto` INT(11) NULL DEFAULT NULL references tempbaza.miasto(id),
  `data_przydzialu` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(1,'Berlin','10115–14199',4,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(2,'Hamburg','20095-21149',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(3,'Monachium','80331-81929',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(4,'Kolonia','50667–51149',0,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(5,'Frankfurt','60306–60599',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(6,'Stuttgart','70173–70619',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(7,'Dortmund','44135-44388',0,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(8,'Düsseldorf','40210–40721',2,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(9,'Essen','45001-45359',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(10,'Brema','28195 ',0,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(11,'Hanower','30159-30669',0,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(12,'Lipsk','04003-04358',3,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(13,'Drezno','01001–01328',0,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(14,'Norymberga','90402-90491',0,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(15,'Duisburg','47051-47279',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(16,'Bochum','44701-44894',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(17,'Wuppertal','42103-42399',1,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(18,'Bielefeld','33739',0,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(19,'Bonn','53229',0,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(20,'Mannheim','68159–68309',3,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(21,'Münster','48143',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(22,'Augsburg','86150–86199',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(23,'Akwizgran','52056-52080',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(24,'Kilonia','24103–24159',2,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(25,'Magdeburg','39130',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(26,'Kassel','37218',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(27,'Hagen','58135',3,0);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(28,'Leverkusen','51368-51381',1,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(29,'Poczdam','14461',3,1);
INSERT INTO `tempbaza`.`miasta` (`id`,`nazwa`,`kod_pocztowy`,`liczba_uchodzcow`,`czy_przyjmuje`)VALUES(30,'Wolfsburg','38442',1,0);




INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(1,'Abdul','Al-Churi','1990-04-12','Mężczyzna','Syria ',500,1,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(2,'Mahmud','Hariri','1987-04-10','Mężczyzna','Afganistan',1000,1,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(3,'Baszira','Haddad','2000-09-22','Kobieta','Erytrea',900,1,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(4,'Jasira','Haddad','1967-03-09','Kobieta','Pakistan',1300,1,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(5,'Abdul','Al-Churi','1969-01-31','Mężczyzna','Afganistan',500,2,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(6,'Jasira','Maluf','1978-11-21','Kobieta','Nigeria',600,2,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(7,'Fatima','Haddad','1954-12-10','Kobieta','Pakistan',600,3,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(8,'Mahmud','Al-Churi','2007-02-03','Mężczyzna','Afganistan',1100,5,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(9,'Raszida','Maluf','1991-08-25','Kobieta','Nigeria',800,6,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(10,'Jasira','Hariri','1974-07-27','Kobieta','Irak',900,6,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(11,'Abdul','Hariri','1998-05-04','Mężczyzna','Syria ',500,8,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(12,'Baszira','Maluf','1989-10-10','Kobieta','Irak',900,8,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(13,'Abdul','Al-Churi','2005-04-07','Mężczyzna','Pakistan',500,9,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(14,'Raszida','Maluf','1959-08-11','Kobieta','Afganistan',1200,9,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(15,'Jasira','Haddad','1994-09-25','Kobieta','Syria ',1100,12,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(16,'Abdul','Hariri','1988-03-21','Mężczyzna','Erytrea',800,12,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(17,'Fatima','Haddad','1990-05-15','Kobieta','Erytrea',800,12,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(18,'Mahmud','Al-Churi','1968-08-15','Mężczyzna','Syria ',1100,15,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(19,'Baszira','Hariri','1998-12-18','Kobieta','Nigeria',1200,16,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(20,'Mahmud','Maluf','1996-10-07','Mężczyzna','Irak',1300,17,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(21,'Fatima','Al-Churi','1977-05-09','Kobieta','Syria ',500,20,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(22,'Tajmullah','Maluf','1981-11-11','Mężczyzna','Pakistan',1300,20,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(23,'Hamid','Haddad','1986-04-26','Mężczyzna',' Kosowo',600,20,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(24,'Jasira','Maluf','1961-04-12','Kobieta','Afganistan',800,21,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(25,'Baszira','Haddad','1993-10-22','Kobieta','Erytrea',700,22,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(26,'Mahmud','Al-Churi','1982-12-19','Mężczyzna','Nigeria',800,22,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(27,'Tajmullah','Maluf','1999-09-08','Mężczyzna','Erytrea',1000,23,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(28,'Fatima','Hariri','1980-01-01','Kobieta','Syria ',1000,23,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(29,'Mahmud','Haddad','1993-03-06','Mężczyzna',' Kosowo',1200,24,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(30,'Raszida','Haddad','1964-01-10','Kobieta','Syria ',900,24,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(31,'Abdul','Maluf','1999-04-21','Mężczyzna','Pakistan',1000,25,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(32,'Hamid','Al-Churi','1979-09-26','Mężczyzna','Irak',600,26,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(33,'Baszira','Maluf','1992-07-18','Kobieta','Irak',700,27,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(34,'Tajmullah','Hariri','1991-11-19','Mężczyzna','Pakistan',1100,27,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(35,'Hamid','Al-Churi','1980-10-20','Mężczyzna','Irak',1200,27,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(36,'Raszida','Hariri','1995-03-26','Kobieta','Pakistan',700,28,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(37,'Fatima','Hariri','1995-06-11','Kobieta','Afganistan',900,29,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(38,'Hamid','Al-Churi','1998-10-18','Mężczyzna','Erytrea',700,29,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(39,'Abdul','Maluf','2001-01-22','Mężczyzna',' Kosowo',1100,29,'2015-12-14 17:04:18');
INSERT INTO `tempbaza`.`uchodzcy`(`id`,`imie`,`nazwisko`,`data_urodzenia`,`plec`,`kraj_pochodzenia`,`zasilek`,`przydzielone_miasto`,`data_przydzialu`)VALUES(40,'Tajmullah','Haddad','2004-06-04','Mężczyzna','Afganistan',1300,30,'2015-12-14 17:04:18');



