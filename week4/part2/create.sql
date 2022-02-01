CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE books (
  book_id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NULL,
  author_id INT NOT NULL,
  price_id INT NOT NULL,
  genre_id INT NOT NULL,
  image_url TEXT NULL,
  pages_count INT NOT NULL,
  publish_year DATE NOT NULL,
  PRIMARY KEY (book_id));

CREATE TABLE employees (
  employee_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NULL,
  phone_number VARCHAR(45) NOT NULL,
  salary DOUBLE NOT NULL,
  PRIMARY KEY (employee_id));

CREATE TABLE earnings (
  earning_id INT NOT NULL AUTO_INCREMENT,
  price_id INT NOT NULL,
  genre_id INT NOT NULL,
  count INT NOT NULL,
  PRIMARY KEY (earning_id));

CREATE TABLE authors (
  author_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (author_id));

CREATE TABLE prices (
  price_id INT NOT NULL AUTO_INCREMENT,
  price_sale DOUBLE NOT NULL,
  PRIMARY KEY (price_id));

CREATE TABLE category (
  genre_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(120) NULL,
  PRIMARY KEY (genre_id));

CREATE TABLE customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (customer_id));


CREATE TABLE orders (
  order_id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  book_id INT NOT NULL,
  order_date DATE NOT NULL,
  earning_id INT NOT NULL,
  PRIMARY KEY (order_id));

CREATE TABLE storage (
  storage_id INT NOT NULL AUTO_INCREMENT,
  book_id INT NOT NULL,
  count INT NOT NULL,
  PRIMARY KEY (storage_id));

ALTER TABLE books ADD CONSTRAINT fk_author_id 
FOREIGN KEY (author_id) REFERENCES authors(author_id);
ALTER TABLE books ADD CONSTRAINT fk_price_id 
FOREIGN KEY (price_id) REFERENCES prices(price_id);
ALTER TABLE books ADD CONSTRAINT fk_genre_id 
FOREIGN KEY (genre_id) REFERENCES  category(genre_id);
 
ALTER TABLE earnings ADD CONSTRAINT price_id_fk 
FOREIGN KEY (price_id) REFERENCES prices(price_id);
ALTER TABLE earnings ADD CONSTRAINT genre_id_fk
FOREIGN KEY (genre_id) REFERENCES category(genre_id);

ALTER TABLE orders ADD CONSTRAINT fk_customer_id 
FOREIGN KEY (customer_id) REFERENCES customers(customer_id);
ALTER TABLE orders ADD CONSTRAINT fk_book_id 
FOREIGN KEY (book_id) REFERENCES books(book_id);
ALTER TABLE orders ADD CONSTRAINT fk_earning_id 
FOREIGN KEY (earning_id) REFERENCES earnings(earning_id);

ALTER TABLE storage ADD CONSTRAINT book_id_fk 
FOREIGN KEY (book_id) REFERENCES books(book_id);