package com.diego.library.controller;

import com.diego.library.domain.book.Book;
import com.diego.library.domain.book.BookDetails;
import com.diego.library.domain.book.BookRepository;
import com.diego.library.domain.book.CreateBook;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import java.net.URI;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<BookDetails> postBook(@RequestBody @Valid CreateBook bookData, UriComponentsBuilder uriBuilder) {
        Book book = new Book(bookData);
        repository.save(book);
        URI location = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri(); //http://localhost:8080/book/id
        return ResponseEntity.created(location).body(new BookDetails(book));
    }

    @GetMapping
    public ResponseEntity<Page<BookDetails>> getBook(@PageableDefault(size = 10, page=0,sort = {"title"}) Pageable paginator) {
        System.out.println(paginator.toString());
        Page<BookDetails> page = (Page<BookDetails>) repository.findAllByActiveTrue(paginator).map(BookDetails::new);
        return ResponseEntity.ok(page);
    }
}
