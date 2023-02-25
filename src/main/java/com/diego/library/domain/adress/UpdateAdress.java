package com.diego.library.domain.adress;

import jakarta.validation.constraints.NotNull;

public record UpdateAdress(
        String street,
        String neighborhood,
        String number,
        String state,
        String city
) {
}
