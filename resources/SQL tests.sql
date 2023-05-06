CREATE DATABASE fishky;

CREATE TABLE words
(
	-- word_id INT PRIMARY KEY AUTO_INCREMENT,
    word_id INT,
    eng_word VARCHAR(40),
    translation VARCHAR(400),
    part_of_speech VARCHAR(40),
    example_phrase_english VARCHAR(400),
    example_phrase_polish VARCHAR(400),
    example_sentence_english VARCHAR(4000),
    frequency_daily INT,
    frequency_IT INT,
    frequency_technical_engineering INT,
    duplicates CHAR(20),
    problematic CHAR(20),
    frequency_ranking_position CHAR(50),
    tag_1 CHAR(30),
    tag_2 CHAR(30),
    tag_3 CHAR(30),
    explanation VARCHAR(1000)
);

USE fastest_animals;
USE fishky;
DESC words;
DROP TABLE words;

LOAD DATA INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Fishky_database_work.csv'
INTO TABLE words
CHARACTER SET utf8
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

SELECT * FROM words
LIMIT 10;

SELECT * FROM fishky.words WHERE id = 666;

SELECT * from fishky.users;
DESC users;

UPDATE users SET permission_level = 1 WHERE id = 22;