package com.book.book_store.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_store.dto.BookDto;
import com.book.book_store.entity.Book;
import com.book.book_store.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired 
    private BookService service;

    /*
     * Retrive from database all books.
     */
    @GetMapping("/")
    ResponseEntity<List<BookDto>> listAll(){
        return service.listAll();
    }
    /*
     * Add new book to database.
     */

    @PostMapping("/")
    ResponseEntity<String> newBook(@RequestBody BookDto bookDto){
        return service.newBook(bookDto);
    }


    /*
     * Retrive from database the book associated with given ID.
     */
    @GetMapping("/{id}")
    ResponseEntity<BookDto> listById(@PathVariable long id){
        return service.listById(id);
    }


    /*
     * Delete from database the book associated with given ID.
     */

    @DeleteMapping("/{id}")
    ResponseEntity<String> removeBook(@PathVariable long id){
        return service.removeBook(id);
    }

    /*
     * Update information about a book associated with the given ID.
     */

    @PutMapping("/{id}")
    ResponseEntity<BookDto> updateBook(@PathVariable long id, @RequestBody BookDto bookDto){
        return service.updateBook(id, bookDto);
    }


}





