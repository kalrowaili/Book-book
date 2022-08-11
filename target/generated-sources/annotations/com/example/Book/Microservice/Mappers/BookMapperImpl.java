package com.example.Book.Microservice.Mappers;

import com.example.Book.Microservice.Dto.BookDto;
import com.example.Book.Microservice.Entites.Book;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T19:00:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto bookToDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setGenre( book.getGenre() );
        bookDto.setAuthor( book.getAuthor() );

        return bookDto;
    }

    @Override
    public Book DtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setGenre( bookDto.getGenre() );
        book.setAuthor( bookDto.getAuthor() );

        return book;
    }
}
