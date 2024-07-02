package com.book.book_store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.book_store.dto.AuthorDto;
import com.book.book_store.entity.Author;
import com.book.book_store.repository.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;
    
    @Autowired
    private BookService bookService;


    public List<AuthorDto> listAll(){
        List<Author> author = repository.findAll();

        return author.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public AuthorDto listById(@PathVariable long id){
        Optional<Author> author = repository.findById(id);

        return author.map(this::convertToDto).orElse(null);
    }


    private AuthorDto convertToDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBooks(author.getBooks().stream()
        .map(bookService::convertToDto)
        .collect(Collectors.toList()));

        return dto;
    }


    
}
