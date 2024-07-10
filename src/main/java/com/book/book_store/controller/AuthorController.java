package com.book.book_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_store.dto.AuthorDto;
import com.book.book_store.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping("/")
    ResponseEntity<List<AuthorDto>> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<AuthorDto> listById(@PathVariable long id){
        return service.listById(id);
    }

    @PostMapping("/")
    ResponseEntity<String> newAuthor(@RequestBody AuthorDto author){
        return service.newAuthor(author);   
    }

    @PutMapping("/{id}")
    ResponseEntity<AuthorDto> updateAuthor(@PathVariable long id, @RequestBody AuthorDto author){
        return service.updateAuthor(id, author);
    }

}
