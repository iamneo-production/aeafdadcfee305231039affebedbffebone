package com.examly.springapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogPost {

@Id
private int postId;
private String title;
private String content;
private String author;
private Date timestamp;

   
public BlogPost() {
}



public BlogPost(int postId, String title, String content, String author, Date timestamp) {
    this.postId = postId;
    this.title = title;
    this.content = content;
    this.author = author;
    this.timestamp = timestamp;
}



public int getPostId() {
    return postId;
}
public void setPostId(int postId) {
    this.postId = postId;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
public Date getTimestamp() {
    return timestamp;
}
public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
}

   


    
}
