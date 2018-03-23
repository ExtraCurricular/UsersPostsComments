Welcome to users, posts, comments api service!

docker-compose up -d
port: 80

Users endpoint:
api/users (POST) - in body - email(string), username(string)
api/users (GET) - no params
api/users/id (GET) - in url - id
api/users/id (DELETE) - in url - id
api/users/id (PUT) - in url - id - in body - email(string), username(string)

Posts endpoint:
api/posts (POST) - in body - userId(int), title(string), body(string)
api/posts (GET) - no params
api/posts/id (GET) - in url - id
api/posts/id (DELETE) - in url - id
api/posts/id (PUT) - in url - id - in body - userId(int), title(string), body(string)

Comments endpoint:
api/comments (POST) - in body - userId(int), postId(int), body(string)
api/comments (GET) - no params
api/comments/id (GET) - in url - id
api/comments/id (DELETE) - in url - id
api/comments/id (PUT) - in url - id - in body - userId(int), postId(int), body(string)
