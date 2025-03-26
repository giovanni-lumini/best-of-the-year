package org.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.spring.best_of_the_year.classes.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class MovieController {

    @GetMapping("/movies")
    /* http://localhost:8080/movies */
    public String movies(Model model) {
        // creo nuovi movies
        Movie spidermanUno = new Movie(1, "Spiderman 1");
        Movie spidermanDue = new Movie(2, "Spiderman 2");
        Movie spidermanTre = new Movie(3, "Spiderman 3");

        // creo un ArrayList
        ArrayList<Movie> movies = new ArrayList<>();
        // aggiungo i nuovi movies all'ArrayList
        movies.add(spidermanUno);
        movies.add(spidermanDue);
        movies.add(spidermanTre);

        model.addAttribute("movies", movies);

        return "movie";
    }

    @GetMapping("/movie/{id}")
    /* http://localhost:8080/movie/1 */
    public String movieById(Model model, @PathVariable("id") String id) {
        model.addAttribute("id", id);
        return "movieById";
    }
}
