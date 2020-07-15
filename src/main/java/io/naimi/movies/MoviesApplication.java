package io.naimi.movies;

import io.naimi.movies.dao.MovieRepository;
import io.naimi.movies.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
