package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookRepositoryImpl implements BookRepository{
    private final List<Book> books = new ArrayList<>();

    @Override
    public Optional<Book> createBook(Book book) {
        books.add(book);
        return books.stream().filter(b -> b.getId().equalsIgnoreCase(book.getId())).findFirst();
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(String id) {
        return books.stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst().orElse(new Book());
    }

    @Override
    public Book updateBook(String id, Book book) {
        int bookIndex = books.stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst().map(books::indexOf).orElse(-1);
        String bookId = books.get(bookIndex).getId();
        book.setId(bookId);
        books.set(bookIndex, book);
        return books.stream().filter(b -> b.getId().equalsIgnoreCase(bookId)).findFirst().orElse(new Book());
    }
}
