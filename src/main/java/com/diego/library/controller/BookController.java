package com.diego.library.controller;

import com.diego.library.domain.book.Book;
import com.diego.library.domain.book.BookDetails;
import com.diego.library.domain.book.BookRepository;
import com.diego.library.domain.book.CreateBook;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity postBook(@RequestBody @Valid CreateBook bookData, UriComponentsBuilder uriBuilder) {
        Book book = new Book(bookData);
        repository.save(book);
        URI location = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri(); //http://localhost:8080/book/id
        return ResponseEntity.created(location).body(new BookDetails(book));
    }
}
