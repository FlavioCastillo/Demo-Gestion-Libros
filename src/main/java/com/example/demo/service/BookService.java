package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.ResponseTemplate;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseTemplate createBook(Book book);
    ResponseTemplate getAllBooks();
    ResponseTemplate getBookById(String id);
    ResponseTemplate updateBook(String id, Book book);

}
