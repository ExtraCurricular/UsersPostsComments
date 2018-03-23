DROP TABLE IF EXISTS users;
CREATE TABLE users (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(30) UNIQUE,
username VARCHAR(20) UNIQUE
);

DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId INT,
title VARCHAR(50),
body VARCHAR(500),
FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS comments;
CREATE TABLE comments (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId INT,
postId INT,
body VARCHAR(500),
FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (postId) REFERENCES posts(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO users (id,username, email) VALUES (NULL, "John", "john@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John1", "john1@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John2", "john2@john.com");
INSERT INTO users (id,username, email) VALUES (NULL, "John3", "john3@john.com");


INSERT INTO posts (id, userId, title, body) VALUES (NULL, 1, "first title", "first post");
INSERT INTO posts (id, userId, title, body) VALUES (NULL, 2, "second title", "second post");
INSERT INTO posts (id, userId, title, body) VALUES (NULL, 3, "third title", "third post");
INSERT INTO posts (id, userId, title, body) VALUES (NULL, 3, "fourth title", "fourth post");

INSERT INTO comments (id, userId, postId, body) VALUES (NULL, 1, 1, "first comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (NULL, 1, 1, "second comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (NULL, 1, 1, "third comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (NULL, 1, 1, "fourth comment on the first post!");
