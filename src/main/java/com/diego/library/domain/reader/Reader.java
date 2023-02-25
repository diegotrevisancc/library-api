package com.diego.library.domain.reader;

import com.diego.library.domain.adress.Adress;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "readers")
@Entity(name = "Reader")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reader {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    @Embedded
    private Adress adress;

    private boolean active;

    public Reader(CreateReader reader) {
        this.name = reader.name();
        this.email = reader.email();
        this.telephoneNumber = reader.telephoneNumber();
        this.adress = new Adress(reader.adress());
    }
}
