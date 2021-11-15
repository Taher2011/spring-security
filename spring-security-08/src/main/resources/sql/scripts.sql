create database bank_spring_security;

use bank_spring_security;

CREATE TABLE bank_spring_security.users (
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
enabled INT NOT NULL,
PRIMARY KEY (id));


INSERT INTO bank_spring_security.users
(id,username,password,enabled)
VALUES(1,'bank-db','12345',1);

CREATE TABLE authorities (
username varchar(45) NOT NULL,
authority varchar(45) NOT NULL
);

INSERT INTO bank_spring_security.authorities (username,authority)
VALUES('bank-db','admin');
