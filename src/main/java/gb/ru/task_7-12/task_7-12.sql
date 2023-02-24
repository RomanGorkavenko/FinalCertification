CREATE DATABASE human_friends;
USE human_friends;

CREATE TABLE pets
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_of_pet VARCHAR(45)
);

INSERT INTO pets(type_of_pet)
VALUES
	("cats"),
    ("dogs"),
    ("hamsters");
    
SELECT *
FROM pets;

CREATE TABLE pack_animals
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_of_pack_animals VARCHAR(45)
);

INSERT INTO pack_animals(type_of_pack_animals)
VALUES
	("horses"),
    ("camels"),
    ("donkeys");
    
SELECT *
FROM pack_animals;

CREATE TABLE horses
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO horses(`name`, command, date_of_birth, pack_animals_id)
VALUES
	("Berry", "Step", "2012-10-25", 1),
    ("Varangian", "Jog", "2016-05-04", 1),
    ("Burushka", "Gallop", "2010-01-15", 1);
    
SELECT *
FROM horses;

CREATE TABLE camels
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO camels(`name`, command, date_of_birth, pack_animals_id)
VALUES
	("Sahara", "Stand", "2016-11-25", 2),
    ("Bombay", "Lie", "2008-05-05", 2),
    ("Narsil", "Stand up", "2011-02-17", 2);
    
SELECT *
FROM camels;

CREATE TABLE donkeys
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO donkeys(`name`, command, date_of_birth, pack_animals_id)
VALUES
	("Diana", "Stand", "2015-09-08", 3),
    ("Boy", "Lie", "2009-07-08", 3),
    ("Gloria", "Stand up", "2014-03-19", 3);
    
SELECT *
FROM donkeys;

CREATE TABLE cats
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO cats(`name`, command, date_of_birth, pack_animals_id)
VALUES
	("Amanda", "Stand", "2015-09-08", 1),
    ("Liberty", "Lie", "2009-07-08", 1),
    ("Golden", "Eat", "2014-03-19", 1);
    
SELECT *
FROM cats;

CREATE TABLE dogs
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO dogs(`name`, command, date_of_birth, pack_animals_id)
VALUES
	("Duncan", "Stand", "2022-12-09", 2),
    ("Camellia", "Voice", "2010-08-09", 2),
    ("Amanda", "Eat", "2021-03-20", 2);
    
SELECT *
FROM dogs;

CREATE TABLE hamsres
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    command VARCHAR(45),
    date_of_birth DATE NOT NULL,
    pack_animals_id INT NOT NULL
);

INSERT INTO hamsres(`name`, date_of_birth, pack_animals_id)
VALUES
	("Vincent", "2020-12-10", 3),
    ("Grey", "2011-08-10", 3),
    ("Liberty", "2022-03-22", 3);
    
SELECT *
FROM hamsres;

DELETE FROM pack_animals
WHERE type_of_pack_animals="camels";

SELECT *
FROM pack_animals;

DROP TABLE camels;

SELECT *
FROM horses
UNION ALL
SELECT *
FROM donkeys;

CREATE TABLE young_animals
SELECT *
FROM horses
WHERE date_of_birth BETWEEN "2020-01-01" AND "2022-12-12"

UNION ALL

SELECT *
FROM donkeys
WHERE date_of_birth BETWEEN "2020-01-01" AND "2022-12-12"

UNION ALL

SELECT * 
FROM cats
WHERE date_of_birth BETWEEN "2020-01-01" AND "2022-12-12"

UNION ALL

SELECT * 
FROM dogs
WHERE date_of_birth BETWEEN "2020-01-01" AND "2022-12-12"

UNION ALL

SELECT * 
FROM hamsres
WHERE date_of_birth BETWEEN "2020-01-01" AND "2022-12-12";

SELECT *,
ROUND(DATEDIFF(NOW(), date_of_birth) / 12) as age_in_months
FROM young_animals;

SELECT *
FROM horses

UNION ALL

SELECT *
FROM donkeys

UNION ALL

SELECT * 
FROM cats

UNION ALL

SELECT * 
FROM dogs

UNION ALL

SELECT * 
FROM hamsres;
