package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList=new ArrayList<>();

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    public User() {
        this.username=null;
        this.password=null;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}