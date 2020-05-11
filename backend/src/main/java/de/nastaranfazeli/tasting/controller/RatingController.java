package de.nastaranfazeli.tasting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.nastaranfazeli.tasting.model.Rating;
import de.nastaranfazeli.tasting.model.RatingRequest;
import de.nastaranfazeli.tasting.repository.RatingRepository;

@RestController
public class RatingController {

    @Autowired
    private final RatingRepository ratingRepository;

    RatingController(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PutMapping("/rating")
    @ResponseStatus(HttpStatus.CREATED)
    Rating publishRating(
            @RequestBody
            final
            RatingRequest ratingRequest) {
        return ratingRepository.findAllByTastingIdAndUserId(ratingRequest.getTastingId(), ratingRequest.getUserId())
                               .stream().findFirst()
                               .map(r -> {
                                   r.setRating(ratingRequest.getRating());
                                   return ratingRepository.save(r);
                               }).orElseGet(() -> {
                    final Rating rating = Rating.builder()
                                                .tastingId(ratingRequest.getTastingId())
                                                .userId(ratingRequest.getUserId())
                                                .rating(ratingRequest.getRating())
                                                .build();
                    return ratingRepository.save(rating);
                });
    }

    @GetMapping("/ratings")
    List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/average-rating")
    double getRatings(
            @RequestParam
            final
            String tastingId) {
        return ratingRepository.findAllByTastingId(tastingId).stream()
                               .mapToDouble(r -> r.getRating()).average().orElse(0.0);
    }
}
