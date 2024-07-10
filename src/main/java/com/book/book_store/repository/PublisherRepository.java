package com.book.book_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.book_store.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
        Optional<Publisher> findByName(String name);

}
