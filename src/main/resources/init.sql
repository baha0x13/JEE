
CREATE DATABASE IF NOT EXISTS stockmaster;
USE stockmaster;

CREATE TABLE IF NOT EXISTS produits (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    prix DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT IGNORE INTO produits (nom, prix) VALUES ('Clavier', 25.0);
INSERT IGNORE INTO produits (nom, prix) VALUES ('Souris Logitech', 35.50);
INSERT IGNORE INTO produits (nom, prix) VALUES ('Écran 24 pouces', 350.00);

INSERT IGNORE INTO users (username, password) VALUES ('admin', '123');
