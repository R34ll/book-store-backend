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

import com.book.book_store.dto.PublisherDto;
import com.book.book_store.entity.Publisher;
import com.book.book_store.repository.PublisherRepository;


@Service
public class PublisherService {
    @Autowired
    private PublisherRepository repository;
    
    @Autowired
    private BookService bookService;
    
    public List<PublisherDto> listAll(){
        List<Publisher> publishers = repository.findAll();
    
        return publishers.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public PublisherDto listById(@PathVariable long id){
        Optional<Publisher> publisher = repository.findById(id);

        return publisher.map(this::convertToDto).orElse(null);
    }


    public ResponseEntity<String> newPublisher(@RequestBody PublisherDto publisherDto){
        try {
            Publisher publisher = convertToPublisher(publisherDto);

            Publisher saved = repository.save(publisher);

            return new ResponseEntity<>("New publisher was saved.", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error while saving new publisher.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<String> updatePublisher(@PathVariable long id, @RequestBody PublisherDto dto){
        try{
                Publisher publisher = repository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found."));
                publisher.setName(dto.getName());
                repository.save(publisher);
                return new ResponseEntity<>("Publisher was updated.", HttpStatus.OK);
            
        }catch(Exception e){
            return new ResponseEntity<>("Error while updating publisher.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Publisher convertToPublisher(PublisherDto dto){

        Publisher publisher = new Publisher();
        publisher.setName(dto.getName());

        return publisher;
    }

    private PublisherDto convertToDto(Publisher publisher){
        PublisherDto dto = new PublisherDto();

        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        dto.setBooks(publisher.getBooks().stream().map(bookService::convertToDto).collect(Collectors.toList())); 
        
        return dto;
    }


    

}
