package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    private String dimensions;

    private String description;

    @JoinColumn
    @ManyToOne
    private Blog blog;

    public Image(String dimensions, String description , Blog blog) {
        this.dimensions = dimensions;
        this.description = description;
        this.blog = blog;
    }

    public Image() {
        this.dimensions=null;
        this.description=null;
        this.blog=null;
    }

    public Integer getImageId() {
        return imageId;
    }

    public String getDimension() {
        return dimensions;
    }

    public void setDimension(String dimension) {
        this.dimensions = dimension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}