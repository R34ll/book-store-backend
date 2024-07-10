package com.book.book_store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.book.book_store.dto.AuthorDto;
import com.book.book_store.entity.Author;
import com.book.book_store.repository.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;
    
    @Autowired
    private BookService bookService;


    public ResponseEntity<List<AuthorDto>> listAll(){
        List<Author> author = repository.findAll();

        List<AuthorDto> dto =  author.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<AuthorDto> listById(@PathVariable long id){
        Optional<Author> author = repository.findById(id);

        AuthorDto dto = author.map(this::convertToDto).orElse(null);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    public ResponseEntity<String> newAuthor(@RequestBody AuthorDto authorDto){
        try {
            Author author = convertToAuthor(authorDto);
            author.setId(0);
            Author saved = repository.save(author);
            return new ResponseEntity<>("New Author was saved.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while saving new author.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable long id, @RequestBody AuthorDto authorDto){
        try {
            
            Author author = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found."));

            author.setName(authorDto.getName());
            
            AuthorDto updated = convertToDto(author);
            return ResponseEntity.ok(updated);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    private Author convertToAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        return author;
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
