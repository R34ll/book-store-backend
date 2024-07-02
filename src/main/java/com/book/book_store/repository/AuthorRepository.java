package com.book.book_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.book_store.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

    Optional<Author> findByName(String name);

}
