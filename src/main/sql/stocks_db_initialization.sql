/** create the stocks database */

DROP TABLE IF EXISTS stocks.quotes CASCADE;
CREATE TABLE stocks.quotes(
   ID INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS stocks.person CASCADE;
CREATE TABLE stocks.person(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(256) NOT NULL,
    last_name VARCHAR(256) NOT NULL,
    birth_date DATETIME NOT NULL
);

DROP TABLE IF EXISTS stocks.person_quote CASCADE;
CREATE TABLE stocks.person_quote
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  quote_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID),
  FOREIGN KEY (quote_id) REFERENCES hobbies (ID)
);


INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');

INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Sundar', 'Pichai', '1972-6-10');
INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Tim', 'Cook', '1960-11-1');
INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Jeff', 'Bezos', '1964-1-12-');

INSERT INTO stocks.person_quote (person_id, quote_id) value (1, 1);
INSERT INTO stocks.person_quote (person_id, quote_id) value (1, 2);
INSERT INTO stocks.person_quote (person_id, quote_id) value (2, 3);
INSERT INTO stocks.person_quote (person_id, quote_id) value (3, 4);
INSERT INTO stocks.person_quote (person_id, quote_id) value (4, 1);
INSERT INTO stocks.person_quote (person_id, quote_id) value (4, 2);
INSERT INTO stocks.person_quote (person_id, quote_id) value (4, 3);
INSERT INTO stocks.person_quote (person_id, quote_id) value (4, 4);