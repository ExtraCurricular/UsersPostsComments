set @@sql_mode = '';

DROP TABLE IF EXISTS users;
CREATE TABLE users (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(30) NOT NULL UNIQUE,
username VARCHAR(20) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId INT NOT NULL,
title VARCHAR(50) NOT NULL,
body VARCHAR(500) NOT NULL,
FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS comments;
CREATE TABLE comments (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId INT NOT NULL,
postId INT NOT NULL,
body VARCHAR(500) NOT NULL,
FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (postId) REFERENCES posts(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO users (id,username, email) VALUES (NULL, "John", "john@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John1", "john1@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John2", "john2@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John3", "john3@john.com");