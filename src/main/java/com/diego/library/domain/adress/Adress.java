package com.diego.library.domain.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.Update;

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

    public void update(UpdateAdress adress) {
        if (adress.city() != null) {
            this.city = adress.city();
        }
        if(adress.state() != null) {
            this.state = adress.state();
        }
        if(adress.number() != null) {
            this.number = adress.number();
        }
        if(adress.street() != null) {
            this.state = adress.state();
        }
        if(adress.neighborhood() != null) {
            this.neighborhood = adress.neighborhood();
        }
    }

}
