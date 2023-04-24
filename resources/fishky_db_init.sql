use fishky;

DROP TABLE words;

CREATE TABLE fishky.words
(
	word_id INT PRIMARY KEY AUTO_INCREMENT,
    eng_word VARCHAR(45) NOT NULL,
	pol_word VARCHAR (225),
    part_of_speech VARCHAR(45)
);
-- nie wskazuję silnika składowania, więc podstawi się domyślny (innoDB)

LOAD DATA INFILE 'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_words.csv'
INTO TABLE fishky.words
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(@skip, eng_word, pol_word, part_of_speech);

-- naprawa buga, gdzie kolejne nadawane id przy autoinkrementacji wynosi 1024
ALTER TABLE fishky.words AUTO_INCREMENT = 998;

SELECT * FROM words;

INSERT INTO fishky.words (eng_word, pol_word, part_of_speech)
VALUES ('test', 'test', 'test');

DELETE FROM fishky.words WHERE word_id = 998;