package com.diego.library.controller;

import com.diego.library.domain.reader.CreateReader;
import com.diego.library.domain.reader.Reader;
import com.diego.library.domain.reader.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
