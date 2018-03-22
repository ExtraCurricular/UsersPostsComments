package com.WebServices.PostService.controllers;

import com.WebServices.PostService.models.User;
import com.WebServices.PostService.repositories.PostRepository;
import com.WebServices.PostService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.WebServices.PostService.Exception404;
import com.WebServices.PostService.models.Comment;
import com.WebServices.PostService.repositories.CommentRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class CommentController {
    @Autowired
    CommentRepository commentRepository;
    UserRepository userRepository;
    PostRepository postRepository;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable(value = "id") Long commentsId) {
        return commentRepository.findById(commentsId).orElseThrow(() -> new Exception404("(GET) api/comments/id", commentsId));
    }

    @PostMapping("/comments")
    public Comment createComment(@Valid @RequestBody Comment comment, HttpServletResponse response) {
        response.addHeader("Location", "api/comments");
        response.setStatus(201);
        return commentRepository.save(comment);
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long commentId, @Valid @RequestBody Comment newComment) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new Exception404("(PUT) api/comments", commentId));

        comment.setBody(newComment.getBody());
        comment.setUserId(newComment.getUserId());
        comment.setPostId(newComment.getPostId());

        return commentRepository.save(comment);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new Exception404("(DELETE) api/comments/id", commentId));

        commentRepository.delete(comment);

        return ResponseEntity.ok().build();
    }
}