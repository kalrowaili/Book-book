package com.example.Book.Microservice.Exception;


import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddBookException extends RuntimeException {

    public AddBookException() {
        super();
    }
//part exception
    public AddBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddBookException(String message) {
        super(message);
    }

    public AddBookException(Throwable cause) {

        super(cause);
    }

}
