package de.nastaranfazeli.tasting.repository;


import de.nastaranfazeli.tasting.model.Rating;
import de.nastaranfazeli.tasting.model.RatingIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, RatingIdentity> {
    List<Rating> findAllById_Tasting(String tasting);

    List<Rating> findAllById_TastingAndId_Drink(String tasting, String drink);
}
