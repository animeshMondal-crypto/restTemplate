package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class BookClient {

    private final RestTemplate restTemplate;

    public BookClient(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public List<List<Book>> getBooks(){
        String uri = "http://localhost:8080/api/books";
        HttpHeaders header = new HttpHeaders();
        header.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Void> httpEntity = new HttpEntity<>(header);
        ResponseEntity<List<Book>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, List.class);

        return response.getBody();
    }
}
