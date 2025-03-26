package org.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.best_of_the_year.classes.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MovieController {

    // lista dei movie, dichiarata una sola volta
    private List<Movie> movies = new ArrayList<>();

    // inizializzazione della lista dei movie nel costruttore
    public MovieController() {
        movies.add(new Movie(1, "Spiderman 1"));
        movies.add(new Movie(2, "Spiderman 2"));
        movies.add(new Movie(3, "Spiderman 3"));
    }

    @GetMapping("/movies")
    /* http://localhost:8080/movies */
    public String movies(Model model) {
        // Aggiungi la lista di movies al modello per visualizzarla nella vista
        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/movie/{id}")
    /* http://localhost:8080/movie/1 */
    public String movieById(Model model, @PathVariable("id") int id) {
        // Cerca il film con l'ID specificato
        Movie foundMovie = null;
        // ciclo forEach
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                foundMovie = movie;
                break; // Esce dal ciclo se trova il film
            }
        }

        // Se non trovi il film, puoi gestire il caso (esempio: mostrare un errore)
        if (foundMovie == null) {
            return "movieNotFound"; // Aggiungi una pagina per film non trovato
        }

        // Aggiungi il film trovato al modello per visualizzarlo nella vista
        model.addAttribute("movie", foundMovie);
        return "movieById";
    }
}
