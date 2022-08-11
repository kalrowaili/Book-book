package com.example.Book.Microservice.Controllers;
import com.example.Book.Microservice.Dto.BookDto;
import com.example.Book.Microservice.Entites.Book;
import com.example.Book.Microservice.FeignClient.Comment;
import com.example.Book.Microservice.FeignClient.Todos;
import com.example.Book.Microservice.Mappers.BookMapper;
import com.example.Book.Microservice.Services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private BookService bookService;
    private BookMapper mapper = Mappers.getMapper(BookMapper.class);
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path="comments")
    public List<Comment> getComments(){
        return bookService.getComments() ;
    }
    @GetMapping(path="todos")
    public List<Todos> getTodos(){
        return bookService.getTodos() ;

    }
    @GetMapping
    @Operation(summary = "Get All books")
    public ResponseEntity<Object> getBooks() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
       return bookService.getBooks() ;
    }
    @GetMapping(path = "{bookId}")
    @Operation(summary = "Get a book by its id")
    public Optional<Book> getBook(@PathVariable(name = "bookId") Integer bookId) {
        Optional<Book> book = bookService.getBook(bookId);
        if (book.isPresent()) {
            return book;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "the book is not found"
            );
        }
    }
    @PostMapping
    @Operation(summary = "Save a book")
    ResponseEntity<BookDto> registerNewBook(@RequestBody Book book) {

        return bookService.addBook(book) ;
    }
    @DeleteMapping(path = "{bookId}")
    @Operation(summary = "Delete a book by its id")
    public ResponseEntity<BookDto> deleteBook(@PathVariable("bookId") Integer bookId) {
        return bookService.deleteBook(bookId) ;
      }
    @PutMapping (path = "{bookId}")
    ResponseEntity<BookDto> updateBook(@RequestBody Book book) {
      return bookService.putBook(book) ;
    }
}








