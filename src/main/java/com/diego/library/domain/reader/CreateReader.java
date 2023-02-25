package com.diego.library.domain.reader;

import com.diego.library.domain.adress.CreateAdress;

public record CreateReader(String name, String email, String telephoneNumber, CreateAdress adress) {
    public CreateReader(Reader reader) {
        this(reader.getName(), reader.getEmail(), reader.getTelephoneNumber(), new CreateAdress(reader.getAdress()));
    }
}
