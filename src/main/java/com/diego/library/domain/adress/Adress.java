package com.diego.library.domain.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter //lombok
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
public class Adress {
    private String street;
    private String neighborhood;
    private String number;
    private String state;
    private String city;

    public Adress(CreateAdress adress) {
        this.street = adress.street();
        this.neighborhood = adress.neighborhood();
        this.number = adress.number();
        this.state = adress.state();
        this.city = adress.city();
    }

}
