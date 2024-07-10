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

import com.book.book_store.dto.PublisherDto;
import com.book.book_store.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping("/")
    ResponseEntity<List<PublisherDto>> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<PublisherDto> listById(@PathVariable long id){
        return service.listById(id);
    }


    @PostMapping("/")
    ResponseEntity<String> newPublisher(@RequestBody PublisherDto dto){
        return service.newPublisher(dto);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updatePublisher(@PathVariable long id,  @RequestBody PublisherDto dto){
        return service.updatePublisher(id, dto);
    }


}
