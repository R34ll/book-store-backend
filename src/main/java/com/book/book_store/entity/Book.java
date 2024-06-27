package com.book.book_store.entity;

import java.time.LocalDate;

import com.book.book_store.enums.Genre;
import com.book.book_store.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private int n_pages;
    private double price;

    @Enumerated(EnumType.STRING)
    private Genre  genre;

    @Enumerated(EnumType.STRING)
    private Language language;


    private LocalDate publicationDate;
    
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher_id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Publisher getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Publisher publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Author author_id) {
        this.author_id = author_id;
    }

    

}
