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
    private Long publisher_id;
    private Long author_id;

    
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
    public Long getPublisher_id() {
        return publisher_id;
    }
    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }
    public Long getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
    
    
}