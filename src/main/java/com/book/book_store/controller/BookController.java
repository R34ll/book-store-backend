package com.book.book_store.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_store.dto.BookDto;
import com.book.book_store.entity.Book;
import com.book.book_store.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired 
    private BookService service;


    @GetMapping("/")
    List<BookDto> listAll(){
        return service.listAll();
    }

    // @GetMapping("/{id}")
    // List<Book> listById(@PathVariable long id){}


    // @PutMapping("/new")
    // Book newBook(){}

    // @PutMapping("/update/{id}")
    // Book updateBook(@PathVariable long id){}

    // @DeleteMapping("/remove/{id}")
    // String removeBook(@PathVariable long id){} 


}





