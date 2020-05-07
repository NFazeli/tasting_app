package de.nastaranfazeli.tasting.model;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Embeddable
public class RatingIdentity implements Serializable {
    @NotNull
    private String tasting;

    @NotNull
    private String person;

    @NotNull
    private String drink;
}
