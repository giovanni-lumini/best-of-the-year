package org.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class SongController {

    @GetMapping("/songs")
    /* http://localhost:8080/songs */
    public String songs(Model model) {
        // creo nuovi movies
        Song battito = new Song(1, "Battito");
        Song columbia = new Song(2, "Columbia");
        Song karma = new Song(3, "Karma");

        // creo un ArrayList
        ArrayList<Song> songs = new ArrayList<>();
        // aggiungo i nuovi movies all'ArrayList
        songs.add(battito);
        songs.add(columbia);
        songs.add(karma);

        model.addAttribute("songs", songs);

        return "song";
    }
}
