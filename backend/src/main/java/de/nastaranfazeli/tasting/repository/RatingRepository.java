package de.nastaranfazeli.tasting.repository;


import de.nastaranfazeli.tasting.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.DoubleStream;

public interface RatingRepository extends JpaRepository<Rating, String> {
    List<Rating> findAllByTastingId(String tastingId);

    List<Rating> findAllByTastingIdAndUserId(String tastingId, String userId);
}
