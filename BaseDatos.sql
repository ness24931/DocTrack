-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema doctrack
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema doctrack
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `doctrack` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `doctrack` ;

-- -----------------------------------------------------
-- Table `doctrack`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`hibernate_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_clients` (
  `CLIENT_ID` INT NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(50) NOT NULL,
  `FIRST_SURNAME` VARCHAR(50) NULL DEFAULT NULL,
  `SECOND_SURNAME` VARCHAR(50) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `TELEPHONE` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_jobs` (
  `JOB_ID` INT NOT NULL AUTO_INCREMENT,
  `JOB_TITLE` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`JOB_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_employees` (
  `EMPLOYEE_ID` INT NOT NULL AUTO_INCREMENT,
  `DNI` VARCHAR(20) NOT NULL,
  `FIRST_NAME` VARCHAR(50) NOT NULL,
  `FIRST_SURNAME` VARCHAR(50) NULL DEFAULT NULL,
  `SECOND_SURNAME` VARCHAR(50) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `TELEPHONE` VARCHAR(25) NOT NULL,
  `DEPARTMENT_ID` INT NOT NULL,
  `JOB_ID` INT NOT NULL,
  `STATUS` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  INDEX `FKax66pt022r9i3vnkraxd9hoiw` (`DEPARTMENT_ID` ASC) VISIBLE,
  INDEX `FKgbdeuicsu4o139h2lcvvpynh4` (`JOB_ID` ASC) VISIBLE,
  CONSTRAINT `FKax66pt022r9i3vnkraxd9hoiw`
    FOREIGN KEY (`DEPARTMENT_ID`)
    REFERENCES `doctrack`.`t_departments` (`DEPARTMENT_ID`),
  CONSTRAINT `FKgbdeuicsu4o139h2lcvvpynh4`
    FOREIGN KEY (`JOB_ID`)
    REFERENCES `doctrack`.`t_jobs` (`JOB_ID`),
  CONSTRAINT `t_employees_ibfk_1`
    FOREIGN KEY (`DEPARTMENT_ID`)
    REFERENCES `doctrack`.`t_departments` (`DEPARTMENT_ID`),
  CONSTRAINT `t_employees_ibfk_2`
    FOREIGN KEY (`JOB_ID`)
    REFERENCES `doctrack`.`t_jobs` (`JOB_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 91
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_departments` (
  `DEPARTMENT_ID` INT NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` VARCHAR(50) NOT NULL,
  `MANAGER_ID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  INDEX `FK16s3kb3vwmfslv5buxkoxh07f` (`MANAGER_ID` ASC) VISIBLE,
  CONSTRAINT `FK16s3kb3vwmfslv5buxkoxh07f`
    FOREIGN KEY (`MANAGER_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `t_departments_ibfk_1`
    FOREIGN KEY (`MANAGER_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_requests` (
  `REQUEST_ID` INT NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(250) NOT NULL,
  `DESCRIPTION` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`REQUEST_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 264
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_requirements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_requirements` (
  `REQUIREMENT_ID` INT NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(250) NOT NULL,
  `DESCRIPTION` VARCHAR(1000) NOT NULL,
  `request_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`REQUIREMENT_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_requests_requirements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_requests_requirements` (
  `REQUEST_REQUIREMENT_ID` INT NOT NULL AUTO_INCREMENT,
  `REQUEST_ID` INT NOT NULL,
  `REQUIREMENT_ID` INT NOT NULL,
  PRIMARY KEY (`REQUEST_REQUIREMENT_ID`),
  INDEX `FK5cl2o567quj2rjeg5kwkqviq2` (`REQUIREMENT_ID` ASC) VISIBLE,
  INDEX `FK4n8kficur3ye9kr335xe0i2gk` (`REQUEST_ID` ASC) VISIBLE,
  CONSTRAINT `FK4n8kficur3ye9kr335xe0i2gk`
    FOREIGN KEY (`REQUEST_ID`)
    REFERENCES `doctrack`.`t_requests` (`REQUEST_ID`),
  CONSTRAINT `FK5cl2o567quj2rjeg5kwkqviq2`
    FOREIGN KEY (`REQUIREMENT_ID`)
    REFERENCES `doctrack`.`t_requirements` (`REQUIREMENT_ID`),
  CONSTRAINT `t_requests_requirements_ibfk_1`
    FOREIGN KEY (`REQUEST_ID`)
    REFERENCES `doctrack`.`t_requests` (`REQUEST_ID`),
  CONSTRAINT `t_requests_requirements_ibfk_2`
    FOREIGN KEY (`REQUIREMENT_ID`)
    REFERENCES `doctrack`.`t_requirements` (`REQUIREMENT_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 74
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_tickets` (
  `TICKET_ID` INT NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(100) NOT NULL,
  `DESCRIPTION` VARCHAR(1000) NULL DEFAULT NULL,
  `REQUEST_ID` INT NOT NULL,
  `DEPARTMENT_ID` INT NOT NULL,
  `EMPLOYEE_ID` INT NOT NULL,
  `CLIENT_ID` INT NOT NULL,
  `ESTADO` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`TICKET_ID`),
  INDEX `FKpp69g8qa3n1se3xnwy60ecm62` (`CLIENT_ID` ASC) VISIBLE,
  INDEX `FK5yd0j898aug03vblodin30ta` (`EMPLOYEE_ID` ASC) VISIBLE,
  INDEX `FKf67wtrioa0an4ka1r476pi16g` (`REQUEST_ID` ASC) VISIBLE,
  CONSTRAINT `FK5yd0j898aug03vblodin30ta`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `FKf67wtrioa0an4ka1r476pi16g`
    FOREIGN KEY (`REQUEST_ID`)
    REFERENCES `doctrack`.`t_requests` (`REQUEST_ID`),
  CONSTRAINT `FKpp69g8qa3n1se3xnwy60ecm62`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `doctrack`.`t_clients` (`CLIENT_ID`),
  CONSTRAINT `t_tickets_ibfk_1`
    FOREIGN KEY (`REQUEST_ID`)
    REFERENCES `doctrack`.`t_requests` (`REQUEST_ID`),
  CONSTRAINT `t_tickets_ibfk_2`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `t_tickets_ibfk_3`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `doctrack`.`t_clients` (`CLIENT_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_resolutions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_resolutions` (
  `RESOLUTION_ID` INT NOT NULL AUTO_INCREMENT,
  `TICKET_ID` INT NOT NULL,
  `DESCRIPTION` VARCHAR(1000) NULL DEFAULT NULL,
  `EMPLOYEE_ID` INT NOT NULL,
  PRIMARY KEY (`RESOLUTION_ID`),
  INDEX `FKfwjvokorlv8w9mka1sxdeel17` (`EMPLOYEE_ID` ASC) VISIBLE,
  INDEX `FKoahd6490rd6y0wbkq4mg54epp` (`TICKET_ID` ASC) VISIBLE,
  CONSTRAINT `FKfwjvokorlv8w9mka1sxdeel17`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `FKoahd6490rd6y0wbkq4mg54epp`
    FOREIGN KEY (`TICKET_ID`)
    REFERENCES `doctrack`.`t_tickets` (`TICKET_ID`),
  CONSTRAINT `t_resolutions_ibfk_1`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `t_resolutions_ibfk_2`
    FOREIGN KEY (`TICKET_ID`)
    REFERENCES `doctrack`.`t_tickets` (`TICKET_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_roles` (
  `ROLE_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ROLE_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `doctrack`.`t_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `doctrack`.`t_users` (
  `USER_ID` INT NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(15) NOT NULL,
  `PASSWD` VARCHAR(50) NOT NULL,
  `ROLE_ID` INT NOT NULL,
  `EMPLOYEE_ID` INT NULL DEFAULT NULL,
  `CLIENT_ID` INT NULL DEFAULT NULL,
  `STATUS` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  INDEX `FKc0vgik3t6y8sqs1862l7he2ih` (`EMPLOYEE_ID` ASC) VISIBLE,
  INDEX `FKqv83xmq1wqpg9e1snck4lewvn` (`ROLE_ID` ASC) VISIBLE,
  INDEX `FKe39wdonje2ada18xf3aof55cc` (`CLIENT_ID` ASC) VISIBLE,
  CONSTRAINT `FKc0vgik3t6y8sqs1862l7he2ih`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `FKe39wdonje2ada18xf3aof55cc`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `doctrack`.`t_clients` (`CLIENT_ID`),
  CONSTRAINT `FKqv83xmq1wqpg9e1snck4lewvn`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `doctrack`.`t_roles` (`ROLE_ID`),
  CONSTRAINT `t_users_ibfk_1`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `doctrack`.`t_employees` (`EMPLOYEE_ID`),
  CONSTRAINT `t_users_ibfk_2`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `doctrack`.`t_roles` (`ROLE_ID`),
  CONSTRAINT `t_users_ibfk_3`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `doctrack`.`t_clients` (`CLIENT_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `doctrack` ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_DEPARTMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_DEPARTMENT`(pDEPARTMENT_ID int)
BEGIN
DELETE FROM T_DEPARTMENTS WHERE DEPARTMENT_ID = pDEPARTMENT_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_EMPLOYEE
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_EMPLOYEE`(pUSERNAME varchar(10))
BEGIN
DECLARE vEMPLOYEE_ID INT DEFAULT 0;
SELECT EMPLOYEE_ID INTO vEMPLOYEE_ID FROM T_USERS WHERE USERNAME = pUSERNAME;
UPDATE T_EMPLOYEES SET STATUS = 'DISABLED' WHERE EMPLOYEE_ID = vEMPLOYEE_ID;
UPDATE T_USERS SET STATUS = 'DISABLED' WHERE USERNAME = pUSERNAME;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_JOB
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_JOB`(pJOB_ID int)
BEGIN
DELETE FROM T_JOBS WHERE JOB_ID = pJOB_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_REQUEST
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_REQUEST`(pREQUEST_ID int)
BEGIN
DELETE FROM T_REQUIREMENTS WHERE REQUEST_ID = pREQUEST_ID;
DELETE FROM T_REQUEST_ID WHERE REQUEST_ID = pREQUEST_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_REQUESTS_REQUIREMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_REQUESTS_REQUIREMENTS`(pREQUEST_REQUIREMENT_ID int)
BEGIN
DELETE FROM T_REQUESTS_REQUIREMENTS WHERE REQUEST_REQUIREMENT_ID = pREQUEST_REQUIREMENT_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_DELETE_REQUIREMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DELETE_REQUIREMENT`(pREQUIREMENT_ID int)
BEGIN
DELETE FROM T_REQUIREMENTS WHERE REQUIREMENT_ID = pREQUIREMENT_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_DEPARTMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_DEPARTMENT`(pDEPARTMENT_NAME varchar(50))
BEGIN
INSERT INTO T_DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID) VALUES (0,pDEPARTMENT_NAME,null);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_EMPLOYEE
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_EMPLOYEE`(pDNI varchar(20),pFIRST_NAME varchar (50), pFIRST_SURNAME varchar(50), pSECOND_SURNAME varchar(50),
pEMAIL varchar(50),pTELEPHONE varchar(25), pDEPARTMENT_ID int,pJOB_ID int)
BEGIN
INSERT INTO T_EMPLOYEES (DNI,EMPLOYEE_ID,FIRST_NAME,FIRST_SURNAME,SECOND_SURNAME,EMAIL,TELEPHONE,DEPARTMENT_ID,JOB_ID,STATUS) 
VALUES (0,pDNI,pFIRST_NAME,pFIRST_SURNAME,pSECOND_SURNAME,pEMAIL,pTELEPHONE,pDEPARTMENT_ID,pJOB_ID,'ENABLED');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_JOB
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_JOB`(pJOB_TITLE varchar(50))
BEGIN
INSERT INTO T_JOBS (JOB_ID,JOB_TITLE) VALUES (0,pJOB_TITLE);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_REQUEST
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_REQUEST`(pTITLE varchar(250), pDESCRIPTION varchar(1000))
BEGIN
INSERT INTO T_REQUESTS (REQUEST_ID,TITLE,DESCRIPTION) 
VALUES (0,pTITLE,pDESCRIPTION);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_REQUESTS_REQUIREMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_REQUESTS_REQUIREMENTS`(pREQUEST_ID int,pREQUIREMENT_ID int)
BEGIN
INSERT INTO T_REQUESTS_REQUIREMENTS(T_REQUEST_REQUIREMENT,REQUEST_ID,REQUIREMENT_ID) VALUES (0,pREQUEST_ID,pREQUIREMENT_ID);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_INSERT_REQUIREMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_INSERT_REQUIREMENT`(pTITLE varchar(250),pDESCRIPTION varchar(1000))
BEGIN
INSERT INTO T_REQUIREMENTS(REQUIREMENT_ID,TITLE,DESCRIPTION) VALUES (0,pTITLE,pDESCRIPTION);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_DEPARTMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_DEPARTMENTS`()
BEGIN
    SELECT * 
    FROM T_DEPARTMENTS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_EMPLOYEES
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_EMPLOYEES`()
BEGIN
    SELECT * 
    FROM T_EMPLOYEES;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_EMPLOYEE_ID
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_EMPLOYEE_ID`(pID int)
BEGIN
    SELECT * 
    FROM EMPLOYEE
    WHERE EMPLOYEE_ID = pID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_JOB
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_JOB`()
BEGIN
    SELECT * 
    FROM JOBS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_JOBS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_JOBS`()
BEGIN
    SELECT * 
    FROM T_JOBS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_REQUESTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_REQUESTS`()
BEGIN
    SELECT * 
    FROM T_REQUESTS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_REQUESTS_REQUIREMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_REQUESTS_REQUIREMENTS`()
BEGIN
    SELECT * 
    FROM T_REQUESTS_REQUIREMENTS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_REQUEST_ID
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_REQUEST_ID`(pID int)
BEGIN
    SELECT * 
    FROM REQUESTS
    WHERE REQUEST_ID = pID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_REQUIREMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_REQUIREMENTS`()
BEGIN
    SELECT * 
    FROM T_REQUIREMENTS;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_LIST_REQUIREMENT_ID
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_LIST_REQUIREMENT_ID`(pID int)
BEGIN
    SELECT * 
    FROM REQUIREMENT
    WHERE REQUIREMENT_ID = pID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_DEPARTMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_DEPARTMENT`(pDEPARTMENT_ID int , pDEPARTMENT_NAME varchar(50))
BEGIN
UPDATE T_DEPARTMENTS SET DEPARTMENT_NAME=pDEPARTMENT_NAME WHERE DEPARTMENT_ID = PDEPARTMENT_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_EMPLOYEE
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_EMPLOYEE`(EMPLOYEE_ID int, pDNI varchar(20),pFIRST_NAME varchar (50), pFIRST_SURNAME varchar(50), pSECOND_SURNAME varchar(50),
pEMAIL varchar(50),pTELEPHONE varchar(25), pDEPARTMENT_ID int,pJOB_ID int,pSTATUS varchar(10))
BEGIN
UPDATE T_EMPLOYEES SET DNI = pDNI,FIRST_NAME=pFIRST_NAME,FIRST_SURNAME=pFIRST_SURNAME,SECOND_SURNAME=pSECOND_SURNAME,EMAIL=pEMAIL,TELEPHONE=pTELEPHONE,DEPARTMENT_ID=pDEPARTMENT_ID,JOB_ID=pJOB_ID,STATUS=pSTATUS
WHERE EMPLOYEE_ID = pEMPLOYEE_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_JOB
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_JOB`(pJOB_ID int , pJOB_TITLE varchar(50))
BEGIN
UPDATE T_JOBS SET JOB_TITLE=pJOB_TITLE WHERE JOB_ID = pJOB_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_REQUEST
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_REQUEST`(pREQUEST_ID int, pTITLE varchar(250), pDESCRIPTION varchar(1000))
BEGIN
UPDATE T_REQUEST SET TITLE=pTITLE, DESCRIPTION=pDESCRIPTION WHERE REQUEST_ID = pREQUEST_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_REQUESTS_REQUIREMENTS
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_REQUESTS_REQUIREMENTS`(pREQUEST_REQUIREMENT_ID int, pREQUEST_ID int,pREQUIREMENT_ID int)
BEGIN
UPDATE T_REQUESTS_REQUIREMENTS SET REQUEST_ID = pREQUEST_ID, REQUIREMENT_ID = pREQUIREMENT_ID WHERE REQUEST_REQUIREMENT_ID = pREQUEST_REQUIREMENT_ID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PROC_UPDATE_REQUIREMENT
-- -----------------------------------------------------

DELIMITER $$
USE `doctrack`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_UPDATE_REQUIREMENT`(pREQUIREMENT_ID int , pTITLE varchar(250),pDESCRIPTION varchar(1000))
BEGIN
UPDATE T_REQUIREMENTS SET TITLE=pTITLE,DESCRIPTION=pDESCRIPTION WHERE REQUIREMENT_ID = pREQUIREMENT_ID;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
