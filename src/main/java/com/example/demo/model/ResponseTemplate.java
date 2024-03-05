package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    List<Book> books;
    Book book;
    String message;
    Integer statusCode;
}
