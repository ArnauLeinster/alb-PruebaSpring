DROP DATABASE IF EXISTS prueba;
CREATE DATABASE prueba;
USE prueba;

DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS parties;
DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
acc_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
username varchar(50) DEFAULT NULL,
password varchar(50) DEFAULT NULL,
email varchar(50) DEFAULT NULL
);

CREATE TABLE games (
game_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
game_name varchar(50) DEFAULT NULL,
description varchar(50) DEFAULT NULL
);

CREATE TABLE parties (
party_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
party_name varchar(50) DEFAULT NULL,
acc_id int DEFAULT NULL,
CONSTRAINT user_FK FOREIGN KEY (acc_id) REFERENCES accounts (acc_id),
game_id int DEFAULT NULL,
CONSTRAINT game_FK FOREIGN KEY (game_id) REFERENCES games (game_id) 
);


CREATE TABLE messages (
message_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
content varchar(100) DEFAULT NULL,
date date DEFAULT NULL,
acc_id int DEFAULT NULL,
party_id int DEFAULT NULL,
CONSTRAINT account_message_FK FOREIGN KEY (acc_id) REFERENCES accounts (acc_id),
CONSTRAINT party_message_FK FOREIGN KEY (party_id) REFERENCES parties (party_id) 
 );
 
INSERT INTO accounts (username, password, email) VALUES
('user1', 'password1', 'user1@gmail.com');
INSERT INTO accounts (username, password, email) VALUES
('user2', 'password2', 'user2@gmail.com');
INSERT INTO accounts (username, password, email) VALUES
('user3', 'password3', 'user3@gmail.com');



INSERT INTO games (game_name, description) VALUES
('game1', 'description1');
INSERT INTO games (game_name, description) VALUES
('game2', 'description2');
INSERT INTO games (game_name, description) VALUES
('game3', 'description3');

INSERT INTO parties (party_name, acc_id, game_id) VALUES
('name1', 1,1 );
INSERT INTO parties (party_name, acc_id, game_id) VALUES
('name1', 2, 2);
INSERT INTO parties (party_name, acc_id, game_id) VALUES
('name1', 3, 3);

INSERT INTO messages (content, date, acc_id, party_id) VALUES
('message content 1', '2021-01-01', 1, 1);
INSERT INTO messages (content, date, acc_id, party_id) VALUES
('message content 2', '2022-02-02', 2, 1);
INSERT INTO messages (content, date, acc_id, party_id) VALUES
('message content 3', '2023-03-03', 2, 2);