package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String author;
    private String publicationYear;
    private String bookGenre;

}
