package dev.han.movies.View;

import dev.han.movies.Model.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

        @Autowired
        private MoviesRepository moviesRepository;

        private MovieService movieService;
        public List<Movie> allMovies(){
            return moviesRepository.findAll();
        }
        public ResponseEntity<List<Movie>> getAllMovies(String imdbId){
            return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
        }

        public Optional<Movie> findMovieByImdbId(String imdbId){
            return moviesRepository.findMovieByImdbId(imdbId);
        }


    }
