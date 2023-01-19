USE `Друзья человека`;

# Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 

DELETE FROM animals a
WHERE a.animal_specie_id = (
	SELECT specie_id 
	FROM animal_species an
	WHERE an.animal_specie = 'верблюд')
	
# Объединить таблицы лошади, и ослы в одну таблицу.
	
DROP TABLE IF EXISTS `лошади и ослы`;
CREATE TABLE `лошади и ослы` (
  animal_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_specie_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  date_of_birth DATE NOT NULL,
  command VARCHAR(45),
  CONSTRAINT had_specie_id_FK FOREIGN KEY (animal_specie_id) REFERENCES animal_species (specie_id)
);

INSERT INTO `лошади и ослы`
SELECT * FROM animals 
WHERE animal_specie_id = (SELECT specie_id FROM animal_species WHERE animal_specie = 'лошадь')
OR animal_specie_id = (SELECT specie_id FROM animal_species WHERE animal_specie = 'осел')

/*
Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице	
*/

DROP TABLE IF EXISTS `молодые животные`;
CREATE TABLE `молодые животные` (
  animal_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_specie_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  date_of_birth DATE NOT NULL,
  command VARCHAR(45),
  months_old INT NOT NULL,
  CONSTRAINT young_specie_id_FK FOREIGN KEY (animal_specie_id) REFERENCES animal_species (specie_id)
);

INSERT INTO `молодые животные`
SELECT a.*, PERIOD_DIFF(DATE_FORMAT(CURRENT_DATE, '%y%m'), DATE_FORMAT(date_of_birth, '%y%m')) - 
	(DATE_FORMAT(CURRENT_DATE, '%d') < DATE_FORMAT(date_of_birth, '%d'))
	AS months
FROM animals a 
WHERE TIMESTAMPDIFF(MONTH, date_of_birth, now()) > 12
AND TIMESTAMPDIFF(MONTH, date_of_birth, now()) <= 36;

# Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

DROP TABLE IF EXISTS `общая таблица`;
CREATE TABLE `общая таблица` (
  animal_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_specie_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  date_of_birth DATE NOT NULL,
  command VARCHAR(45),
  months_old INT NOT NULL,
  table_name VARCHAR(100) NOT NULL,
  CONSTRAINT comb_specie_id_FK FOREIGN KEY (animal_specie_id) REFERENCES animal_species (specie_id)
);

INSERT INTO `общая таблица` (animal_name, date_of_birth, animal_specie_id, command, months_old, table_name)
SELECT 
	animal_name, 
	date_of_birth, 
	animal_specie_id, 
	command,
	TIMESTAMPDIFF(MONTH, date_of_birth, now()) AS months_old, 
	'animals' AS table_name FROM `animals` 
UNION ALL
SELECT 
	animal_name, 
	date_of_birth, 
	animal_specie_id, 
	command,
	TIMESTAMPDIFF(MONTH, date_of_birth, now()) AS months_old, 
	'лошади и ослы' AS table_name FROM `лошади и ослы`
UNION ALL
SELECT 
	animal_name, 
	date_of_birth, 
	animal_specie_id, 
	command,
	TIMESTAMPDIFF(MONTH, date_of_birth, now()) AS months_old, 
	'молодые животные' AS table_name FROM `молодые животные`
































