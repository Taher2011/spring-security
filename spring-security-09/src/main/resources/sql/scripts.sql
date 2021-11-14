create database bank_spring_security;

use bank_spring_security;

CREATE TABLE bank_spring_security.customer (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  pwd varchar(45) NOT NULL,
  role varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);



INSERT INTO bank_spring_security.customer
(id,email,pwd,role)
VALUES(1,'taher@gmail.com','12345','admin');