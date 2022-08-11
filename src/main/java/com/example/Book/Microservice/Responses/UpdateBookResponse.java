package com.example.Book.Microservice.Responses;

import com.example.Book.Microservice.Entites.Book;

public class UpdateBookResponse {
    private String message ;
    private int status ;

    public UpdateBookResponse() {
    }

    public UpdateBookResponse(String message, int status, Book data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    private Book data ;

    public UpdateBookResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Book getData() {
        return data;
    }

    public void setData(Book data) {
        this.data = data;
    }
}
