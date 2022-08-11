package com.example.Book.Microservice.FeignClient;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class TodosFallback implements TodosClient {

    @Override
    public List<Todos> getTodos() {
        return Collections.emptyList();
    }
}
