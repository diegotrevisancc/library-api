package com.diego.library.domain.adress;

import jakarta.validation.constraints.NotNull;

public record CreateAdress(
        @NotNull
        String street,
        @NotNull
        String neighborhood,
        @NotNull
        String number,
        @NotNull
        String state,
        @NotNull
        String city) {
    public CreateAdress(Adress adress) {
        this(adress.getStreet(), adress.getNeighborhood(), adress.getNumber(), adress.getState(), adress.getCity());
    }
}
