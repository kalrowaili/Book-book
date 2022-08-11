package com.example.Book.Microservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "tesst",
        url = "https://gorest.co.in/public/v2",
        fallback = TodosFallback.class)

public interface TodosClient {
@RequestMapping(method = RequestMethod.GET,value = "/todos")
    List<Todos>getTodos();
}
