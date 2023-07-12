package dev.han.movies.Controller;
import dev.han.movies.View.Movie;
import dev.han.movies.View.Review;
 import dev.han.movies.View.ReviewService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
  @RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    //public ResponseEntity<Review> getReviews(@RequestBody Map<String, String> payload) {
      //  return new ResponseEntity<Review>(service.getAllReviews("imdbId"),HttpStatus.OK);
    //}
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable String imdbId) {
        List<Review> reviews = service.findReviewsByImdbId(imdbId);
        return ResponseEntity.ok(reviews);
    }



}
