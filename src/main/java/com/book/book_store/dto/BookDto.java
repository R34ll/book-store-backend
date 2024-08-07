package com.book.book_store.dto;

import java.time.LocalDate;

import com.book.book_store.enums.Genre;
import com.book.book_store.enums.Language;

public class BookDto { // Book data transfer object (DTO)
    private Long id;
    private String title;
    private int n_pages;
    private double price;
    private Genre genre;
    private Language language;
    private LocalDate publication_date;
    private String publisher_id;
    private String author_id;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getN_pages() {
        return n_pages;
    }
    public void setN_pages(int n_pages) {
        this.n_pages = n_pages;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre2) {
        this.genre = genre2;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language2) {
        this.language = language2;
    }
    public LocalDate getPublication_date() {
        return publication_date;
    }
    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }
 
    public void setPublisher(String name) {
        this.publisher_id = name;
    }
    public void setAuthor(String name) {
        this.author_id = name;
    }
    public String getPublisher() {
        return this.publisher_id;
    }
    public String getAuthor() {
        return this.author_id;
    }
    
    
}