package com.WebServices.PostService.controllers;

import com.WebServices.PostService.models.User;
import com.WebServices.PostService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.WebServices.PostService.Exception404;
import com.WebServices.PostService.models.Post;
import com.WebServices.PostService.repositories.PostRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class PostController {
    @Autowired
    PostRepository postRepository;
    UserRepository userRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable(value = "id") Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new Exception404("(GET) api/posts/id", postId));
    }

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post, HttpServletResponse response) {
        //userRepository.findById((long)post.getUserId()).orElseThrow(() -> new Exception404("No User api/users/id", post.getUserId()));
        response.addHeader("Location", "api/posts");
        response.setStatus(201);
        return postRepository.save(post);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable(value = "id") Long postId, @Valid @RequestBody Post newPost) {
        userRepository.findById((long)newPost.getUserId()).orElseThrow(() -> new Exception404("No User api/users/id", newPost.getUserId()));
        Post post = postRepository.findById(postId).orElseThrow(() -> new Exception404("(PUT) api/posts", postId));
        post.setTitle(newPost.getTitle());
        post.setBody(newPost.getBody());
        post.setUserId(newPost.getUserId());

        return postRepository.save(post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new Exception404("(DELETE) api/posts/id", postId));

        postRepository.delete(post);

        return ResponseEntity.ok().build();
    }
}