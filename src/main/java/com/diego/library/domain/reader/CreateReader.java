package com.diego.library.domain.reader;

import com.diego.library.domain.adress.CreateAdress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateReader(
        @NotNull
        String name,
        @NotNull @Email
        String email,
        @NotNull
        String telephoneNumber,
        @NotNull @Valid
        CreateAdress adress) {
    public CreateReader(Reader reader) {
        this(reader.getName(), reader.getEmail(), reader.getTelephoneNumber(), new CreateAdress(reader.getAdress()));
    }
}
