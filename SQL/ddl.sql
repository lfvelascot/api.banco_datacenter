CREATE SCHEMA IF NOT EXISTS `datacenter` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `datacenter`.`ciudad` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `datacenter`.`tipo_transaccion` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `datacenter`.`cuenta` (
  `num` INT(6) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  PRIMARY KEY (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `datacenter`.`auditoria` (
  `id` INT(6) NOT NULL,
  `valor` DOUBLE ZEROFILL NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` INT(6) NOT NULL,
  `cuenta` INT(6) NOT NULL,
  `ciudad` INT(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transaccion_tipo_transaccion_idx2` (`tipo` ASC),
  INDEX `fk_transaccion_cuenta1_idx2` (`cuenta` ASC) ,
  INDEX `fk_auditoria_ciudad1_idx2` (`ciudad` ASC),
  CONSTRAINT `fk_transaccion_tipo_transaccion2`
    FOREIGN KEY (`tipo`)
    REFERENCES `datacenter`.`tipo_transaccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaccion_cuenta2`
    FOREIGN KEY (`cuenta`)
    REFERENCES `datacenter`.`cuenta` (`num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auditoria_ciudad2`
    FOREIGN KEY (`ciudad`)
    REFERENCES `datacenter`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE SCHEMA IF NOT EXISTS `banco_bogota` DEFAULT CHARACTER SET utf8 ;
USE `banco_bogota` ;

-- -----------------------------------------------------
-- Table `banco_bogota`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_bogota`.`ciudad` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_bogota`.`tipo_transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_bogota`.`tipo_transaccion` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `banco_bogota`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_bogota`.`cuenta` (
  `num` INT(6) NOT NULL,
  `cedula` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `ciudad` INT(6) NOT NULL,
  PRIMARY KEY (`num`),
  INDEX `fk_cuenta_ciudad1_idx` (`ciudad` ASC) ,
  CONSTRAINT `fk_cuenta_ciudad1`
    FOREIGN KEY (`ciudad`)
    REFERENCES `banco_bogota`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_bogota`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_bogota`.`transaccion` (
  `id` INT(6) NOT NULL,
  `valor` DOUBLE ZEROFILL NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` INT(6) NOT NULL,
  `cuenta` INT(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transaccion_tipo_transaccion_idx` (`tipo` ASC) ,
  INDEX `fk_transaccion_cuenta1_idx` (`cuenta` ASC) ,
  CONSTRAINT `fk_transaccion_tipo_transaccion`
    FOREIGN KEY (`tipo`)
    REFERENCES `banco_bogota`.`tipo_transaccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaccion_cuenta`
    FOREIGN KEY (`cuenta`)
    REFERENCES `banco_bogota`.`cuenta` (`num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE SCHEMA IF NOT EXISTS `banco_medellin` DEFAULT CHARACTER SET utf8 ;
USE `banco_medellin` ;

-- -----------------------------------------------------
-- Table `banco_medellin`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_medellin`.`ciudad` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_medellin`.`tipo_transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_medellin`.`tipo_transaccion` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_medellin`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_medellin`.`cuenta` (
  `num` INT(6) NOT NULL,
  `cedula` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `ciudad` INT(6) NOT NULL,
  PRIMARY KEY (`num`),
  INDEX `fk_cuenta_ciudad1_idx` (`ciudad` ASC) ,
  CONSTRAINT `fk_cuenta_ciudad1`
    FOREIGN KEY (`ciudad`)
    REFERENCES `banco_medellin`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_medellin`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_medellin`.`transaccion` (
  `id` INT(6) NOT NULL,
  `valor` DOUBLE ZEROFILL NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` INT(6) NOT NULL,
  `cuenta` INT(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transaccion_tipo_transaccion_idx` (`tipo` ASC) ,
  INDEX `fk_transaccion_cuenta1_idx` (`cuenta` ASC) ,
  CONSTRAINT `fk_transaccion_tipo_transaccion`
    FOREIGN KEY (`tipo`)
    REFERENCES `banco_medellin`.`tipo_transaccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaccion_cuenta`
    FOREIGN KEY (`cuenta`)
        REFERENCES `banco_medellin`.`cuenta` (`num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
