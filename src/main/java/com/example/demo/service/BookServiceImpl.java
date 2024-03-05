package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.ResponseTemplate;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public ResponseTemplate createBook(Book book) {
        ResponseTemplate response = new ResponseTemplate();
        try{
            String responseErrorMessage = this.validationMessage(book);
            response.setMessage(responseErrorMessage);
            response.setStatusCode(400);
            if(response.getMessage().isBlank()){
                Book bookToCreate = new Book();
                bookToCreate.setAuthor(book.getAuthor());
                bookToCreate.setTitle(book.getTitle());
                bookToCreate.setPublicationYear(book.getPublicationYear());
                bookToCreate.setBookGenre(book.getBookGenre());
                bookRepository.createBook(bookToCreate);
                response.setStatusCode(200);
                response.setBook(bookToCreate);
            }
        }catch(Exception e){
            response.setMessage("Error en el servidor, vuelve a intentarlo");
            response.setStatusCode(500);
        }
        return response;
    }

    @Override
    public ResponseTemplate getAllBooks() {
        ResponseTemplate response = new ResponseTemplate();
        try{
            response.setBooks(bookRepository.getAllBooks());
            response.setStatusCode(200);
        }catch(Exception e){
            response.setMessage("Error en el servidor, vuelve a intentarlo");
            response.setStatusCode(500);
        }
        return response;
    }

    @Override
    public ResponseTemplate getBookById(String id) {
        ResponseTemplate response = new ResponseTemplate();
        try{
            response.setBook(bookRepository.getBookById(id));
            response.setStatusCode(200);
        }catch (Exception e){
            response.setMessage("Error en el servidor, vuelve a intentarlo");
            response.setStatusCode(500);
        }
        return response;
    }

    @Override
    public ResponseTemplate updateBook(String id, Book book) {
        ResponseTemplate response = new ResponseTemplate();
        try{
            String responseErrorMessage = this.validationMessage(book);
            response.setMessage(responseErrorMessage);
            response.setStatusCode(400);
            if(response.getMessage().isBlank()){
                response.setBook(bookRepository.updateBook(id, book));
                response.setStatusCode(200);
            }
        }catch (Exception e){
            response.setMessage("Error en el servidor, vuelve a intentarlo");
            response.setStatusCode(500);
        }
        return response;
    }
    private String validationMessage(Book book){
        String response = "";
        if(book.getAuthor() == null || book.getAuthor().isBlank()){
            response = "El libro debe contener un autor";
        }
        if(book.getTitle() == null || book.getTitle().isBlank()){
            response = "El libro debe contener un título";
        }
        return response;
    }
}
