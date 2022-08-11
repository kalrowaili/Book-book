package com.example.Book.Microservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "testing",url="https://jsonplaceholder.typicode.com/todos", fallback=CommentFallback.class )
public interface CommentClient {
    @RequestMapping(method = RequestMethod.GET, value="comments")
    List<Comment> getComments() ;
}
