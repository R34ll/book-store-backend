package com.book.book_store.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_store.dto.BookDto;
import com.book.book_store.entity.Book;
import com.book.book_store.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    
    public List<BookDto> listAll(){
        List<Book> books = repository.findAll();

        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }
    // List<Book> listById(@PathVariable long id){}
    // Book newBook(){}
    // Book updateBook(@PathVariable long id){}
    // String removeBook(@PathVariable long id){} // Change return to Json


    private BookDto convertToDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setN_pages(book.getN_pages());
        dto.setPrice(book.getPrice());
        dto.setGenre(book.getGenre());
        dto.setLanguage(book.getLanguage());
        dto.setPublication_date(book.getPublicationDate());
        dto.setPublisher(book.getPublisher_id().getName());
        dto.setAuthor(book.getAuthor_id().getName());
        return dto;
    }


}


