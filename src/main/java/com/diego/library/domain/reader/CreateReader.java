package com.diego.library.domain.reader;

import com.diego.library.domain.adress.CreateAdress;

public record CreateReader(String name, String email, String telephoneNumber, CreateAdress adress) {
}
