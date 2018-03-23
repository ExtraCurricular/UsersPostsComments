DROP TABLE IF EXISTS users;
CREATE TABLE users (
id INcommentsT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(30) UNIQUE,
username VARCHAR(20) UNIQUE
);

DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId BIGINT(20),
title VARCHAR(50),
body VARCHAR(500)
);

DROP TABLE IF EXISTS comments;
CREATE TABLE comments (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId BIGINT(20),
postId BIGINT(20),
body VARCHAR(500)
);

INSERT INTO users (id,username, email) VALUES (1, "John", "john@john.com");
INSERT INTO users (id,username, email) VALUES (2, "John1", "john1@john.com");
INSERT INTO users (id,username, email) VALUES (3, "John2", "john2@john.com");
INSERT INTO users (id,username, email) VALUES (4, "John3", "john3@john.com");

INSERT INTO posts (id, userId, title, body) VALUES (1, 1, "first title", "first post");
INSERT INTO posts (id, userId, title, body) VALUES (2, 2, "second title", "second post");
INSERT INTO posts (id, userId, title, body) VALUES (3, 3, "third title", "third post");
INSERT INTO posts (id, userId, title, body) VALUES (4, 3, "fourth title", "fourth post");

INSERT INTO comments (id, userId, postId, body) VALUES (1, 1, 1, "first comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (2, 1, 1, "second comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (3, 1, 1, "third comment on the first post!");
INSERT INTO comments (id, userId, postId, body) VALUES (4, 1, 1, "fourth comment on the first post!");