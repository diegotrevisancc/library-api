package com.diego.library.domain.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "Book")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Genre genre;
    private String length;
    private boolean active = true;
    public Book(CreateBook book) {
        this.title = book.title();
        this.author = book.author();
        this.genre = book.genre();
        this.length = book.length();
    }
}
