create database pao;

USE pao;

CREATE TABLE users ( 
  id INT NOT NULL AUTO_INCREMENT,  
  name VARCHAR(127) NOT NULL, 
  username VARCHAR(63) NOT NULL,
  password VARCHAR(63) NOT NULL,
  PRIMARY KEY ( id )
);

CREATE TABLE products ( 
  id INT NOT NULL AUTO_INCREMENT,  
  title VARCHAR(127) NOT NULL,
  owner_name VARCHAR(127) NOT NULL,
  starting_price INT NOT NULL DEFAULT 0,
  image_path VARCHAR(255) NOT NULL,
  description TEXT DEFAULT '',
  PRIMARY KEY ( id )
);

CREATE TABLE licitations (   
  product_id Int NOT NULL,
  start_time DATETIME NOT NULL,
  last_licitation_time DATETIME NOT NULL,
  last_licitation_price Int NOT NULL,
  winner_name VARCHAR(127),
  PRIMARY KEY (product_id),
  FOREIGN KEY (product_id)
    REFERENCES products(id)
    ON DELETE CASCADE
);


INSERT INTO users
     (name, username, password)
     VALUES
     ("Test User1", "test1", "test1");
INSERT INTO users
     (name, username, password)
     VALUES
     ("Test User2", "test2", "test3");
INSERT INTO users
     (name, username, password)
     VALUES
     ("Test User3", "test2", "test3");
