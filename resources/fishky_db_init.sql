use fishky;

DROP TABLE words;

CREATE TABLE fishky.words
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    eng_word VARCHAR(45) NOT NULL,
	pol_word VARCHAR (225),
    part_of_speech VARCHAR(45)
);
-- nie wskazuję silnika składowania, więc podstawi się domyślny (innoDB)

LOAD DATA INFILE 
'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_words.csv'
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

-- ----------------------------------------------------------------------------------------------

CREATE TABLE fishky.explanation
(
	word_id INT NOT NULL UNIQUE,
    eng_phrase VARCHAR(495),
    pol_phrase VARCHAR(495),
    eng_sentence VARCHAR(495),
    eng_explanation VARCHAR(4050),
    PRIMARY KEY (word_id),
    CONSTRAINT FK_word_explanation FOREIGN KEY (word_id)
    REFERENCES fishky.words(id)
);

LOAD DATA INFILE 
'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_explanation.csv'
INTO TABLE fishky.explanation
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(word_id, @var1, @var2, @var3, @var4)
SET eng_phrase = NULLIF(@var1, ''), 
	pol_phrase = NULLIF(@var2, ''), 
    eng_sentence = NULLIF(@var3, ''), 
    eng_explanation = NULLIF(@var4, '');


SELECT * FROM explanation;

INSERT INTO explanation (word_id, eng_phrase)
VALUES (997, 'test');

DROP TABLE explanation;
    