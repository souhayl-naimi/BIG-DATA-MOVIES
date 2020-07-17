package io.naimi.movies;

import io.naimi.movies.dao.MovieRepository;
import io.naimi.movies.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> categories = new ArrayList<String>();
        movieRepository.findAll().forEach(movie -> {
            String category = movie.getGenres();
            categories.add(category);
        });
        Set<String> uniqueCategories = new HashSet<>(categories);
        categories.clear();
        categories.addAll(uniqueCategories);
        double number = movieRepository.findByGenresContainsIgnoreCase("War").size();
        System.out.println(number);
        System.out.println(movieRepository.findAll().size());
        double percentage = (number / movieRepository.findAll().size())*100;
        System.out.println(percentage);

    }
}
