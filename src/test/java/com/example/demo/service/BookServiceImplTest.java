package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.ResponseTemplate;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    BookRepository repository;
    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void createBook() {
        Book mockedBook = new Book();
        mockedBook.setAuthor("Autor");
        mockedBook.setTitle("Titulo");
        mockedBook.setBookGenre("Genero");
        mockedBook.setPublicationYear("2024");
        Mockito.when(repository.createBook(Mockito.any())).thenReturn(Optional.of(mockedBook));

        ResponseTemplate bookResponseService = bookService.createBook(mockedBook);

        assertEquals(mockedBook.getAuthor(), bookResponseService.getBook().getAuthor());
        assertEquals(mockedBook.getTitle(), bookResponseService.getBook().getTitle());
        assertEquals(mockedBook.getBookGenre(), bookResponseService.getBook().getBookGenre());
        assertEquals(mockedBook.getPublicationYear(), bookResponseService.getBook().getPublicationYear());
    }

    @Test
    void getAllBooks() {
        List<Book> mockedBookList = new ArrayList<>();
        Book bookMocked1 = new Book();
        bookMocked1.setAuthor("Autor");
        bookMocked1.setTitle("Titulo");
        bookMocked1.setBookGenre("Genero");
        bookMocked1.setPublicationYear("2024");
        Book bookMocked2 = new Book();
        bookMocked2.setAuthor("Autor2");
        bookMocked2.setTitle("Titulo2");
        bookMocked2.setBookGenre("Genero2");
        bookMocked2.setPublicationYear("2023");
        mockedBookList.add(bookMocked1);
        mockedBookList.add(bookMocked2);
        Mockito.when(repository.getAllBooks()).thenReturn(mockedBookList);

        ResponseTemplate responseService = bookService.getAllBooks();

        assertEquals(((long) responseService.getBooks().size()), 2);
    }

    @Test
    void getBookById() {
        Book bookMocked1 = new Book();
        bookMocked1.setId("probeId");
        bookMocked1.setAuthor("Autor");
        bookMocked1.setTitle("Titulo");
        bookMocked1.setBookGenre("Genero");
        bookMocked1.setPublicationYear("2024");
        Mockito.when(repository.getBookById(Mockito.any())).thenReturn(bookMocked1);

        ResponseTemplate responseService = bookService.getBookById("probeId");

        assertEquals(bookMocked1.getId(), responseService.getBook().getId());
        assertEquals(bookMocked1.getAuthor(), responseService.getBook().getAuthor());
        assertEquals(bookMocked1.getTitle(), responseService.getBook().getTitle());
        assertEquals(bookMocked1.getBookGenre(), responseService.getBook().getBookGenre());
        assertEquals(bookMocked1.getPublicationYear(), responseService.getBook().getPublicationYear());
    }

    @Test
    void updateBook() {
        Book bookMocked = new Book();
        bookMocked.setId("probeId");
        bookMocked.setAuthor("Autor");
        bookMocked.setTitle("Titulo2");
        bookMocked.setBookGenre("Genero");
        bookMocked.setPublicationYear("2024");
        Mockito.when(repository.updateBook(Mockito.any(), Mockito.any())).thenReturn(bookMocked);

        ResponseTemplate responseService = bookService.updateBook("probeId", bookMocked);

        assertEquals(bookMocked.getId(), responseService.getBook().getId());
        assertEquals(bookMocked.getAuthor(), responseService.getBook().getAuthor());
        assertEquals(bookMocked.getTitle(), responseService.getBook().getTitle());
        assertEquals(bookMocked.getBookGenre(), responseService.getBook().getBookGenre());
        assertEquals(bookMocked.getPublicationYear(), responseService.getBook().getPublicationYear());
    }
}