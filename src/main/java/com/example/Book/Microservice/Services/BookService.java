package com.example.Book.Microservice.Services;

import com.example.Book.Microservice.Controllers.BookController;
import com.example.Book.Microservice.Dto.BookDto;
import com.example.Book.Microservice.Entites.Book ;
import com.example.Book.Microservice.Exception.AddBookException;
import com.example.Book.Microservice.FeignClient.Comment;
import com.example.Book.Microservice.FeignClient.CommentClient;
import com.example.Book.Microservice.FeignClient.Todos;
import com.example.Book.Microservice.FeignClient.TodosClient;
import com.example.Book.Microservice.Mappers.BookMapper;
import com.example.Book.Microservice.Repositories.BookRepository;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookRepository bookRepository;
    private BookMapper mapper = Mappers.getMapper(BookMapper.class);
    private CommentClient commentClient ;
    private TodosClient todosClient;
    @Autowired
    public BookService(BookRepository bookRepository, TodosClient todosClient) {
        this.bookRepository = bookRepository;
       // this.commentClient = commentClient ;
        this.todosClient= todosClient;
    }
    public ResponseEntity<Object> getBooks() {
        List<Book> list =  bookRepository.findAll() ;
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book b : list) {
            BookDto newDto = new BookDto();
            newDto.setId(b.getId());
            newDto.setTitle(b.getTitle());
            newDto.setGenre(b.getGenre());
            newDto.setAuthor(b.getAuthor());
            bookDtoList.add(newDto);
        }
        if(list != null) {
            return new ResponseEntity<Object>(bookDtoList, HttpStatus.OK);
        }else{
            return  new ResponseEntity<Object>(bookDtoList, HttpStatus.NOT_FOUND);
        }
    }
    public List<Comment> getComments(){
        return commentClient.getComments() ;
    }
    public List<Todos> getTodos(){
        return todosClient.getTodos() ;
    }
    public Optional<Book> getBook(Integer bookId) {
        return bookRepository.findById(bookId);
    }
    public ResponseEntity<BookDto> addBook(Book book) {
        Optional<Book> b = bookRepository.findById(book.getId());
        BookDto Dto = new BookDto();
        if (b.isPresent()) {
            Dto = mapper. bookToDTO(b.get());
            logger.error("Book Already exists");
            throw new AddBookException("Book Already exists") ;

           // return new ResponseEntity<>(Dto, HttpStatus.NOT_FOUND);
            //id
        } else {
            Dto = mapper. bookToDTO(book);
            bookRepository.save(book);
            return new ResponseEntity<>(Dto, HttpStatus.CREATED);
        }
    }
    public ResponseEntity<BookDto> putBook(Book book){
        Optional<Book> b = bookRepository.findById(book.getId()) ;
        BookDto bookDto = new BookDto();
        if (b.isPresent()) {
           bookRepository.save(book);
           bookDto = mapper. bookToDTO(b.get());
            return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
        } else {
            bookDto = mapper. bookToDTO(b.get());
            logger.error("Book not found");
            return new ResponseEntity<>(bookDto, HttpStatus.NOT_FOUND);

        }
    }
    public ResponseEntity<BookDto> deleteBook(Integer bookId) {
        Optional<Book> b = bookRepository.findById(bookId);
        BookDto bookDto = new BookDto();
        if (b.isPresent()) {
            bookDto = mapper. bookToDTO(b.get());
            bookRepository.deleteById(bookId);
            return new ResponseEntity<>
                    (bookDto, HttpStatus.OK);
        } else {
            logger.error("Book not found");
            return new ResponseEntity<>
                    (bookDto,HttpStatus.NOT_FOUND);
        }
    }
    public String getAuthor(Integer bookId) {
        Optional<Book> b = bookRepository.findById(bookId);
        if(b.isPresent()) {
            return b.get().getAuthor() ;
        }else{
            return "Author or book doesn't exist!" ;
        }
    }
    public void updateBook(Book book){
        bookRepository.save(book) ;
    }
}