package io.naimi.movies.web;

import io.naimi.movies.dao.MovieRepository;
import io.naimi.movies.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/admin", method = GET)
    public String admin() {
        return "admin";
    }
    @RequestMapping(value = "/movies", method = GET)
    public String movies(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "100") int size,
                         @RequestParam(name = "title", defaultValue = "") String title) {

        Page<Movie> moviePage = movieRepository.findByTitleContainsIgnoreCase(title,PageRequest.of(page,size));
        //Page<Movie> moviePage = movieRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("result", moviePage.getTotalElements());
        model.addAttribute("movieList", moviePage.getContent());
        model.addAttribute("pages", new int[moviePage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("title", title);
        model.addAttribute("size", size);
        return "movies";
    }

    @RequestMapping(value = "/deleteMovie", method = RequestMethod.POST)
    public String deleteCity(String id, int page, int size, String name) {
        movieRepository.deleteById(id);
        return "redirect:/movies?page=" + page + "&size=" + size + "&name=" + name + "";
    }

    @RequestMapping(value = "/formMovie", method = RequestMethod.GET)
    public String formMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "formMovie";
    }

    @RequestMapping(value = "editMovie", method = RequestMethod.GET)
    public String editMovie(Model model, String id) {
        Movie movie = movieRepository.findById(id).get();
        System.out.println(id);
        model.addAttribute("movie", movie);
        return "formMovie";
    }

    @PostMapping(value = "saveMovie")
    public String saveMovie(Movie movie, BindingResult bindingResult, Model model) {
        model.addAttribute("saved", movie);
        if (bindingResult.hasErrors()) return "formMovie";
        movieRepository.save(movie);
        return "confirmationMovie";

    }
}
