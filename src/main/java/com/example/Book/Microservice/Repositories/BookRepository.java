package com.example.Book.Microservice.Repositories;

import com.example.Book.Microservice.Entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {
}






