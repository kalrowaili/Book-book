package com.example.Book.Microservice.Entites;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private String author;
}
