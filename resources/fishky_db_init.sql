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
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(@skip, eng_word, pol_word, part_of_speech);

-- naprawa buga, gdzie kolejne nadawane id przy autoinkrementacji wynosi 1024
ALTER TABLE fishky.words AUTO_INCREMENT = 998;

INSERT INTO fishky.words (eng_word, pol_word, part_of_speech)
VALUES ('test', 'test', 'test');

SELECT * FROM words;

DELETE FROM fishky.words WHERE id = 998;

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
CHARACTER SET utf8mb4
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

-- ----------------------------------------------------------------------------------------------

CREATE TABLE fishky.frequency
(
	word_id INT NOT NULL UNIQUE,
    ranking_position INT,
    frequency_daily INT,
	frequency_IT INT,
    frequency_engineering INT,
    PRIMARY KEY (word_id),
    CONSTRAINT FK_word_frequency FOREIGN KEY (word_id)
    REFERENCES fishky.words(id)
);

LOAD DATA INFILE 
'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_frequency.csv'
INTO TABLE fishky.frequency
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(word_id, @var1, @var2, @var3, @var4)
SET ranking_position = NULLIF(@var1, ''), 
	frequency_daily = NULLIF(@var2, ''), 
    frequency_IT = NULLIF(@var3, ''), 
    frequency_engineering = NULLIF(@var4, '');


SELECT * FROM frequency;

INSERT INTO frequency (word_id, ranking_position)
VALUES (997, 'test');

DROP TABLE frequency;

-- -----------------------------------------------------------------------------------------------

CREATE TABLE fishky.tags
(
	word_id INT PRIMARY KEY UNIQUE,
    tag_1 VARCHAR(45),
    tag_2 VARCHAR(45),
    tag_3 VARCHAR(45),
    CONSTRAINT FK_word_tags FOREIGN KEY (word_id)
    REFERENCES fishky.words(id)
);

LOAD DATA INFILE
'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_tags.csv'
INTO TABLE fishky.tags
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(word_id, @var1, @var2, @var3)
SET	tag_1 = NULLIF(@var1, ''),
    tag_2 = NULLIF(@var2, ''),
    tag_3 = NULLIF(@var3, '');
    
SELECT * FROM tags;
DROP TABLE tags;

-- ---------------------------------------------------------------------------------------------

CREATE TABLE fishky.word_attributes
(
	word_id INT PRIMARY KEY UNIQUE,
    is_duplicated BOOLEAN,
    is_very_common BOOLEAN,
	CONSTRAINT FK_word_attributes FOREIGN KEY (word_id)
    REFERENCES fishky.words(id)
);

LOAD DATA INFILE
'C:\\Users\\adamg\\Desktop\\Java_learning\\Fishky\\resources\\fishky_db_word_attributes.csv'
INTO TABLE fishky.word_attributes
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(word_id, is_duplicated, @skip);

SELECT * FROM word_attributes;

DROP TABLE word_attributes;

-- ---------------------------------------------------------------------------------------------

CREATE TABLE fishky.users
(
	id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    email VARCHAR(90) UNIQUE,
    passwd VARCHAR(45),
	nickname VARCHAR(45) UNIQUE,
    permission_level INT GENERATED ALWAYS AS (0)
);

DROP TABLE fishky.users;

-- ---------------------------------------------------------------------------------------------

CREATE TABLE fishky.user_attributes
(
	user_id INT PRIMARY KEY,
    word_id INT,
    is_problematic BOOLEAN,
    CONSTRAINT FK_user_attributes FOREIGN KEY (user_id)
    REFERENCES fishky.users(id),
    CONSTRAINT FK_user_words_attributes FOREIGN KEY (word_id)
    REFERENCES fishky.words(id)
);
    