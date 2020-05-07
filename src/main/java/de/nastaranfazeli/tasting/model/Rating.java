package de.nastaranfazeli.tasting.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ratings")
public class Rating {
    @EmbeddedId
    private RatingIdentity id;
    private float rating;
}
