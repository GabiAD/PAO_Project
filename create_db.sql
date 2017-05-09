create database pao;

USE pao;

CREATE TABLE users ( 
  id INT NOT NULL AUTO_INCREMENT,  
  name VARCHAR(63) NOT NULL, 
  username VARCHAR(63) NOT NULL,
  password VARCHAR(63) NOT NULL,
  PRIMARY KEY ( id )
);

CREATE TABLE products ( 
  id INT NOT NULL AUTO_INCREMENT,  
  user_id INT NOT NULL, 

  name VARCHAR(63) NOT NULL,
  price INT NOT NULL,
  image_path VARCHAR(63),
  description TEXT,
  PRIMARY KEY ( id ),
  FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE licitations (   
  start_time DATETIME NOT NULL,
  product_id Int NOT NULL,
  price Int NOT NULL,
  user_id Int,
  PRIMARY KEY (product_id),
  FOREIGN KEY (product_id)
    REFERENCES products(id)
    ON DELETE CASCADE,
  FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE SET NULL
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
