-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema teste_JDBC
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teste_JDBC` ;

-- -----------------------------------------------------
-- Schema teste_JDBC
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teste_JDBC` DEFAULT CHARACTER SET utf8 ;
USE `teste_JDBC` ;

-- -----------------------------------------------------
-- Table `teste_JDBC`.`contato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_JDBC`.`contato` ;

CREATE TABLE IF NOT EXISTS `teste_JDBC`.`contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `email` VARCHAR(45) NULL,
  `endereco` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`idContato`))
ENGINE = InnoDB;

CREATE INDEX `nome` ON `teste_JDBC`.`contato` (`nome` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `teste_JDBC`.`contato`
-- -----------------------------------------------------
START TRANSACTION;
USE `teste_JDBC`;
INSERT INTO `teste_JDBC`.`contato` (`idContato`, `nome`, `email`, `endereco`) VALUES (01, 'Paulo Eduardo Costa', 'p.eduardo.32@gmail.com', 'Passagem Euquido Sales');

COMMIT;

