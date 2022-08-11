package com.example.Book.Microservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {
    private int id;
    private String title;
    private String genre;
    private String author;
}
