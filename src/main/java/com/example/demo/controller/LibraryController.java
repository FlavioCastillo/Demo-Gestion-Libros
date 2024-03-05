package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.ResponseTemplate;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    @Autowired
    BookService bookService;

    @PostMapping()
    public ResponseEntity<ResponseTemplate> createBook(@RequestBody Book book){
        ResponseTemplate response = bookService.createBook(book);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    @GetMapping()
    public ResponseEntity<ResponseTemplate> getAllBooks(){
        ResponseTemplate response = bookService.getAllBooks();
        return new ResponseEntity<>(response,HttpStatusCode.valueOf(response.getStatusCode()));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseTemplate> getBookById(@PathVariable String bookId){
        ResponseTemplate response = bookService.getBookById(bookId);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTemplate> updateBook(@PathVariable String id, @RequestBody Book book){
        ResponseTemplate response = bookService.updateBook(id, book);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }
}
