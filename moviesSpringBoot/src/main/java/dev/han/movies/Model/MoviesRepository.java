package dev.han.movies.Model;
import dev.han.movies.View.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MoviesRepository extends MongoRepository<dev.han.movies.View.Movie, ObjectId> {
        Optional<Movie> findMovieByImdbId(String imdbId);
    }

