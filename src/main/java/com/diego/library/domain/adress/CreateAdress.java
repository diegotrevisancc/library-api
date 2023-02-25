package com.diego.library.domain.adress;

public record CreateAdress(String street, String neighborhood, String number, String state, String city) {
    public CreateAdress(Adress adress) {
        this(adress.getStreet(), adress.getNeighborhood(), adress.getNumber(), adress.getState(), adress.getCity());
    }
}
