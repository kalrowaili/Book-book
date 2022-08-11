package com.example.Book.Microservice.FeignClient;

import java.util.Collections;
import java.util.List;

public class CommentFallback implements CommentClient {
    @Override
    public List<Comment> getComments() {
        return Collections.emptyList();
    }
}
