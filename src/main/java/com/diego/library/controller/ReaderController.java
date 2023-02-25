package com.diego.library.controller;

import com.diego.library.domain.reader.CreateReader;
import com.diego.library.domain.reader.Reader;
import com.diego.library.domain.reader.ReaderRepository;
import com.diego.library.domain.reader.UpdateReader;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    private ReaderRepository repository;

    @GetMapping
    public ResponseEntity<Page<CreateReader>> getReaders(@PageableDefault(size=10, page = 0, sort={"name"}) Pageable paginator) {
        Page<CreateReader> page = repository.findAllByActiveTrue(paginator).map(CreateReader::new);
        return ResponseEntity.ok(page);
    }
    @PostMapping
    @Transactional
    public ResponseEntity postReaders(@RequestBody @Valid CreateReader readerData, UriComponentsBuilder uriBuilder) {
        Reader reader = new Reader(readerData);
        repository.save(reader);
        var uri = uriBuilder.path("/readers/{id}").buildAndExpand(reader.getId()).toUri(); //creates http://localhost:8080/readers/id
        return ResponseEntity.created(uri).body(readerData);
    }

    @PutMapping
    @Transactional
    public ResponseEntity putReaders(@RequestBody UpdateReader readerData) {
        Reader reader = repository.getReferenceById(readerData.id());
        reader.updateReader(readerData);
        return ResponseEntity.ok(new CreateReader(reader));
    }
}
