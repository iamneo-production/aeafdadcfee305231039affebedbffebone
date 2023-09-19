package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.BlogPost;
import com.examly.springapp.repository.BlogPostRepository;

@Service
public class BlogService {


    @Autowired
    private BlogPostRepository repo;

    public boolean addPost(BlogPost post)
    {
        return repo.save(post)!=null?true:false;

    }


    public  Optional<BlogPost> getPostById(int postId)
    {
        return repo.findById(postId);
    }

    public List <BlogPost> getAllBlogPosts()
    {
        return repo.findAll();
    }


    
}
