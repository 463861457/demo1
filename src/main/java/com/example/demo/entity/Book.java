package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2022-07-17 16:14:42
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -90738284880291054L;
    
    private Integer id;
    /**
     * 图书名称
     */
    private String name;
    
    private String isbn;
    
    private String categoryName;
    
    private String author;
    
    private String publisherName;
    
    private Double price;
    
    private String location;
    
    private String description;
    
    private Integer leftNumber;
    
    private Integer totalNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLeftNumber() {
        return leftNumber;
    }

    public void setLeftNumber(Integer leftNumber) {
        this.leftNumber = leftNumber;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", author='" + author + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", leftNumber=" + leftNumber +
                ", totalNumber=" + totalNumber +
                '}';
    }
}

