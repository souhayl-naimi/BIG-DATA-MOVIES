package io.naimi.movies.dao;

import io.naimi.movies.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
        public Page<Movie> findByTitleContainsIgnoreCase(String title, Pageable pageable);
        public Page<Movie> findMoviesByTitle(String title, Pageable pageable);

}
