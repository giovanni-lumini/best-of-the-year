package org.lessons.java.spring.best_of_the_year.classes;

import java.io.Serializable;

public class Movie implements Serializable {
    // variabili
    private int id;
    private String titolo;

    // costruttore vuoto
    public Movie() {
    }

    // costruttore con parametri
    public Movie(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    // getter e setter
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return String.format("%d, %s", id, titolo);
    }
}
