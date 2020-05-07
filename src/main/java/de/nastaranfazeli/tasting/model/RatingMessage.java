package de.nastaranfazeli.tasting.model;

import lombok.Data;

@Data
public class RatingMessage {
    private String tasting;
    private String person;
    private String drink;
    private float rating;
}
