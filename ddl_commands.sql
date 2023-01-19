DROP DATABASE IF EXISTS `Друзья человека`;
CREATE DATABASE `Друзья человека`; 

USE `Друзья человека`;

# Создать таблицы с иерархией из диаграммы в БД

DROP TABLE IF EXISTS animal_types;
CREATE TABLE IF NOT EXISTS animal_types (
  type_id INT UNSIGNED UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS animal_species;
CREATE TABLE IF NOT EXISTS animal_species (
  specie_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_specie VARCHAR(45) UNIQUE NOT NULL,
  animal_type_id INT UNSIGNED NOT NULL,
  CONSTRAINT animal_type_id_FK FOREIGN KEY (animal_type_id) REFERENCES animal_types (type_id)
);

DROP TABLE IF EXISTS animals;
CREATE TABLE IF NOT EXISTS animals (
  animal_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_specie_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  date_of_birth DATE NOT NULL,
  command VARCHAR(45),
  CONSTRAINT animal_specie_id_FK FOREIGN KEY (animal_specie_id) REFERENCES animal_species (specie_id)
);