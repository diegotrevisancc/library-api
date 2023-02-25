package com.diego.library.domain.reader;

import com.diego.library.domain.adress.CreateAdress;

public record ReaderDetails(Long id, String name, String email, String telephoneNumber, CreateAdress adress) {
    public ReaderDetails(Reader reader) {
        this(reader.getId(), reader.getName(), reader.getEmail(), reader.getTelephoneNumber(), new CreateAdress(reader.getAdress()));
    }
}
