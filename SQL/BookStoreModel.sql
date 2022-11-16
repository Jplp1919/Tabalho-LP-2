
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bookStoreDb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bookStoreDb` ;

-- -----------------------------------------------------
-- Schema bookStoreDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookStoreDb` DEFAULT CHARACTER SET utf8 ;
USE `bookStoreDb` ;

-- -----------------------------------------------------
-- Table `bookStoreDb`.`Escritor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookStoreDb`.`Escritor` (
  `idEscritor` INT NOT NULL,
  `primeiroNome` VARCHAR(45) NULL,
  `sobrenome` VARCHAR(45) NULL,
  PRIMARY KEY (`idEscritor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookStoreDb`.`livros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookStoreDb`.`livros` (
  `idlivros` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `ISBN` VARCHAR(17) NULL,
  `preco` DOUBLE NULL,
  `idEscritor` INT NOT NULL,
  PRIMARY KEY (`idlivros`, `idEscritor`),
  INDEX `fk_livros_Escritor1_idx` (`idEscritor` ASC) VISIBLE,
  CONSTRAINT `fk_livros_Escritor1`
    FOREIGN KEY (`idEscritor`)
    REFERENCES `bookStoreDb`.`Escritor` (`idEscritor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookStoreDb`.`inventorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookStoreDb`.`inventorio` (
  `idlivros` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NULL,
  PRIMARY KEY (`idlivros`),
  CONSTRAINT `fk_inventorio_livros`
    FOREIGN KEY (`idlivros`)
    REFERENCES `bookStoreDb`.`livros` (`idlivros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookStoreDb`.`vendaItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookStoreDb`.`vendaItem` (
  `idvendaItem` INT NOT NULL AUTO_INCREMENT,
  `idlivros` INT NOT NULL,
  `quantidade` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idvendaItem`, `idlivros`),
  INDEX `fk_venda_livros1_idx` (`idlivros` ASC) VISIBLE,
  CONSTRAINT `fk_venda_livros1`
    FOREIGN KEY (`idlivros`)
    REFERENCES `bookStoreDb`.`livros` (`idlivros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookStoreDb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookStoreDb`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `dataVenda` DATE NULL,
  `total` DOUBLE NULL,
  `idvendaItem` INT NOT NULL,
  `idlivros` INT NOT NULL,
  PRIMARY KEY (`idvenda`, `idvendaItem`, `idlivros`),
  INDEX `fk_venda_vendaItem1_idx` (`idvendaItem` ASC, `idlivros` ASC) VISIBLE,
  CONSTRAINT `fk_venda_vendaItem1`
    FOREIGN KEY (`idvendaItem` , `idlivros`)
    REFERENCES `bookStoreDb`.`vendaItem` (`idvendaItem` , `idlivros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
