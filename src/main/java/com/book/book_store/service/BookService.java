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
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.book_store.dto.BookDto;
import com.book.book_store.entity.Author;
import com.book.book_store.entity.Book;
import com.book.book_store.entity.Publisher;
import com.book.book_store.repository.AuthorRepository;
import com.book.book_store.repository.BookRepository;
import com.book.book_store.repository.PublisherRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    public ResponseEntity<List<BookDto>> listAll(){
        List<Book> books = repository.findAll();

        List<BookDto> dto = books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
    public ResponseEntity<BookDto> listById(@PathVariable long id){
        Optional<Book> book = repository.findById(id);

        BookDto dto = book
            .map(this::convertToDto)
            .orElse(null);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    public ResponseEntity<String> removeBook(@PathVariable long id){
    
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<>("Book successfully deleted.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<String> newBook(@RequestBody BookDto newBook){
        try{
            Book book = convertToBook(newBook);
            book.setId(0);
            Book savedBook = repository.save(book);
            return new ResponseEntity<>("New book was saved",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error while saving new book.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<BookDto> updateBook(@PathVariable long id, @RequestBody BookDto bookDto){

        try {
            Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

            book.setTitle(bookDto.getTitle());
            book.setN_pages(bookDto.getN_pages());
            book.setPrice(bookDto.getPrice());
            book.setGenre(bookDto.getGenre());
            book.setLanguage(bookDto.getLanguage());
            book.setPublicationDate(bookDto.getPublication_date());


            String publisherName = bookDto.getPublisher();
            Publisher publisher = publisherRepository.findByName(publisherName)
                    .orElseThrow(() -> new RuntimeException("Publisher not found"));
            book.setPublisher_id(publisher);

            // Find the author by name
            String authorName = bookDto.getAuthor();
            Author author = authorRepository.findByName(authorName)
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor_id(author);

            Book updatedBook = repository.save(book);

            BookDto updatedDto = convertToDto(updatedBook);
            return ResponseEntity.ok(updatedDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }


    public Book convertToBook(BookDto bookDto){
        Book book = new Book();

        if(bookDto.getId() != null){
            book.setId(bookDto.getId());
        }

        book.setTitle(bookDto.getTitle());
        book.setN_pages(bookDto.getN_pages());
        book.setPrice(bookDto.getPrice());
        book.setGenre(bookDto.getGenre());
        book.setLanguage(bookDto.getLanguage());
        book.setPublicationDate(bookDto.getPublication_date());

        String publisherName = bookDto.getPublisher();
        Publisher publisher = publisherRepository.findByName(publisherName)
            .orElseThrow(() -> new RuntimeException("Publisher not found"));

        book.setPublisher_id(publisher);

        String authorName = bookDto.getAuthor();
        Author author = authorRepository.findByName(authorName)
            .orElseThrow(() -> new RuntimeException("Publisher not found"));

        book.setAuthor_id(author);

        return book;
    }

    public BookDto convertToDto(Book book) {
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


