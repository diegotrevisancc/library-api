package com.diego.library.domain.reader;

import com.diego.library.domain.adress.UpdateAdress;
import jakarta.validation.constraints.NotNull;

public record UpdateReader(
        @NotNull
        Long id,
        String email,
        String telephoneNumber,
        UpdateAdress adress) {
}
