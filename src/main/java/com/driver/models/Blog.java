package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;

    private String title;

    private String content;

    @JoinColumn
    @ManyToOne
    private User user;

    public Blog(String title,String content,User user){
        this.title=title;
        this.content=content;
        this.user=user;
    }

    public Blog(){
        this.title=null;
        this.content=null;
        this.user=null;
    }

    public Integer getBlogId() {
        return blogId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}