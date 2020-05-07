package de.nastaranfazeli.tasting.controller;

import de.nastaranfazeli.tasting.model.Rating;
import de.nastaranfazeli.tasting.model.RatingIdentity;
import de.nastaranfazeli.tasting.model.RatingMessage;
import de.nastaranfazeli.tasting.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private final RatingRepository ratingRepository;

    RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PutMapping("/rating")
    Rating publishRating(@RequestBody RatingMessage ratingMessage) {
        RatingIdentity ratingIdentity = new RatingIdentity();
        ratingIdentity.setPerson(ratingMessage.getPerson());
        ratingIdentity.setTasting(ratingMessage.getTasting());
        ratingIdentity.setDrink(ratingMessage.getDrink());
        System.out.println(ratingIdentity);
        Rating rating = new Rating();
        rating.setId(ratingIdentity);
        rating.setRating(ratingMessage.getRating());
        System.out.println(rating);
        return ratingRepository.save(rating);
    }

    @GetMapping("/ratings")
    List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/average-rating")
    double getRatings(@RequestParam String tasting, @RequestParam String drink) {
        return ratingRepository.findAllById_TastingAndId_Drink(tasting, drink).stream()
                .mapToDouble(r -> r.getRating()).average().orElse(0.0);
    }
}
