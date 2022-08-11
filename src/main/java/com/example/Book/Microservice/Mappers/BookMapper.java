package com.example.Book.Microservice.Mappers;

import com.example.Book.Microservice.Dto.BookDto;
import com.example.Book.Microservice.Entites.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

   BookDto bookToDTO(Book book);
    Book DtoToBook(BookDto bookDto);

}


