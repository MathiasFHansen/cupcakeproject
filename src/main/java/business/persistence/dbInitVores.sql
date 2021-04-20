-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`cupcake_bund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`cupcake_bund` (
                                                        `cupcake_bund_id` INT NOT NULL,
                                                        `name` VARCHAR(20) NOT NULL,
                                                        `price` INT NOT NULL,
                                                        PRIMARY KEY (`cupcake_bund_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`cupcake_top`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`cupcake_top` (
                                                       `cupcake_top_id` INT NOT NULL,
                                                       `name` VARCHAR(20) NOT NULL,
                                                       `price` INT NOT NULL,
                                                       PRIMARY KEY (`cupcake_top_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`users` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `email` VARCHAR(90) NOT NULL,
                                                 `password` VARCHAR(45) NOT NULL,
                                                 `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
                                                 `balance` INT NULL DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cupcake`.`orderline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderline` (
                                                     `orderline_id` INT NOT NULL,
                                                     `quantity` INT NOT NULL,
                                                     `cupcake_bund_id` INT NOT NULL,
                                                     `cupcake_top_id` INT NOT NULL,
                                                     `user_id` INT NOT NULL,
                                                     PRIMARY KEY (`orderline_id`),
                                                     INDEX `fk_orderline_cupcake_bund_idx` (`cupcake_bund_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_cupcake_top1_idx` (`cupcake_top_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_users1_idx` (`user_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_orderline_cupcake_bund`
                                                         FOREIGN KEY (`cupcake_bund_id`)
                                                             REFERENCES `cupcake`.`cupcake_bund` (`cupcake_bund_id`),
                                                     CONSTRAINT `fk_orderline_cupcake_top1`
                                                         FOREIGN KEY (`cupcake_top_id`)
                                                             REFERENCES `cupcake`.`cupcake_top` (`cupcake_top_id`),
                                                     CONSTRAINT `fk_orderline_users1`
                                                         FOREIGN KEY (`user_id`)
                                                             REFERENCES `cupcake`.`users` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
