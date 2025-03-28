package org.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class SongController {

    // lista dei movie, dichiarata una sola volta
    private List<Song> songs = new ArrayList<>();

    // inizializzazione della lista dei movie nel costruttore
    public SongController() {
        songs.add(new Song(1, "Battito"));
        songs.add(new Song(2, "Columbia"));
        songs.add(new Song(3, "Karma"));
    }

    @GetMapping("/songs")
    /* http://localhost:8080/songs */
    public String songs(Model model) {
        model.addAttribute("songs", songs);
        return "song";
    }

    @GetMapping("/song/{id}")
    /* http://localhost:8080/song/1 */
    public String songById(Model model, @PathVariable("id") int id) {
        // cerca il film con l'id specificato
        Song foundSong = null;
        // ciclo forEach
        for (Song song : songs) {
            if (song.getId() == id) {
                foundSong = song;
                break;
            }
        }

        // se non si trova il film
        if (foundSong == null) {
            return "notFound";
        }

        model.addAttribute("song", foundSong);
        return "songById";
    }
}
