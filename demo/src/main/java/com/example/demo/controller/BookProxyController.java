package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookProxyController {

    private final BookClient bookClient;
    @Autowired
    public BookProxyController(BookClient bookClient){
        this.bookClient=bookClient;
    }

    @GetMapping("/client/books")
    public ResponseEntity<List<String>> getBooksFromApi() {
        List<String> books = bookClient.getBooks();
        return ResponseEntity.ok(books);
    }
}
