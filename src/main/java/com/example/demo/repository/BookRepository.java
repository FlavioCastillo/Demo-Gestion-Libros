package com.example.demo.repository;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book updateBook(String id, Book book);
}
