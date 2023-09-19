package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.BlogPost;
import com.examly.springapp.service.BlogService;

@RestController
public class BlogController {

@Autowired
private BlogService service;

@PostMapping("/posts")
public boolean addPost(@RequestBody BlogPost blogpost)
{
    return service.addPost(blogpost);
}


@GetMapping("/posts/getall")
public List <BlogPost> getAllBlogPosts()
{
    return service.getAllBlogPosts();
}

@GetMapping("/posts/{postId}")
public Optional<BlogPost> getPostById(@PathVariable int postId)
{
    return service.getPostById(postId);
}


    
}
