package com.diego.library.controller;

import com.diego.library.domain.reader.Reader;
import com.diego.library.domain.reader.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderRepository repository;
}
