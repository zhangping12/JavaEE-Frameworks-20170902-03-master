DROP DATABASE IF EXISTS db;
CREATE DATABASE db;

DROP TABLE IF EXISTS db.user;
CREATE TABLE db.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  username VARCHAR(255) NOT NULL UNIQUE
  COMMENT 'username NN UN',
  password VARCHAR(255) NOT NULL
  COMMENT 'password NN'
)
  COMMENT 'user table';

DROP TABLE IF EXISTS db.book;
CREATE TABLE db.book (
  id      BIGINT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  title   VARCHAR(255)  NOT NULL
  COMMENT 'title NN',
  price   DECIMAL(6, 2) NOT NULL
  COMMENT 'price NN',
  amount  INT           NOT NULL
  COMMENT 'amount NN',
  pubTime DATE          NOT NULL
  COMMENT 'publish time NN'
)
  COMMENT 'book table';

SELECT *
FROM db.user;

SELECT *
FROM db.book;

ALTER TABLE db.book
  AUTO_INCREMENT 2147483647; -- int max value

SELECT md5('123');