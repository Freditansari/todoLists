package com.fredy.projectbackend.Models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private int numberOfPages;
    private String format;
    private String isbn;
    private double shippingWeight;

    private double ListPrice;
    private double ourPrice;

    private boolean isActive=true;

    @Column(columnDefinition = "text")
    private String description;
    private String inStockNumber;

    @Transient
    private MultipartFile bookImage;


}
