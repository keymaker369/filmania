SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `filmania` DEFAULT CHARACTER SET latin1 ;
USE `filmania` ;

-- -----------------------------------------------------
-- Table `filmania`.`GENRE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`GENRE` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `filmania`.`GENRE_MOVIE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`GENRE_MOVIE` (
  `GENRE_ID` BIGINT(20) NOT NULL ,
  `movies_id` BIGINT(20) NOT NULL ,
  INDEX `FK7EBFE53499CBBD4A` (`movies_id` ASC) ,
  INDEX `FK7EBFE534BF34FD5D` (`GENRE_ID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `filmania`.`MOVIE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`MOVIE` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `INPUT_DATE` DATETIME NULL DEFAULT NULL ,
  `NAME` VARCHAR(255) NULL DEFAULT NULL ,
  `RANK` DOUBLE NULL DEFAULT NULL ,
  `user_ID` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK462471012B1DEF7` (`user_ID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `filmania`.`MOVIE_GENRE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`MOVIE_GENRE` (
  `MOVIE_id` BIGINT(20) NOT NULL ,
  `genres_ID` BIGINT(20) NOT NULL ,
  INDEX `FK81DA2F744CFB823D` (`MOVIE_id` ASC) ,
  INDEX `FK81DA2F747935F070` (`genres_ID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `filmania`.`ROLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`ROLE` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `filmania`.`USER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `filmania`.`USER` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL ,
  `PASSWORD` VARCHAR(255) NULL DEFAULT NULL ,
  `USERNAME` VARCHAR(255) NULL DEFAULT NULL ,
  `role_ID` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK27E3CB6D871B17` (`role_ID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
