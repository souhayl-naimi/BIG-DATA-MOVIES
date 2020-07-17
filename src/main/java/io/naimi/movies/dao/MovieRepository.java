package io.naimi.movies.dao;

import io.naimi.movies.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface MovieRepository extends MongoRepository<Movie, String> {
        public Page<Movie> findByTitleContainsIgnoreCase(String title, Pageable pageable);
        public ArrayList<String> findByGenresContainsIgnoreCase(String cat);
        public ArrayList<String> findByGenres(String cat);


}
