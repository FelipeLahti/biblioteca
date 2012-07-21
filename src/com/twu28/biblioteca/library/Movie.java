package com.twu28.biblioteca.library;

import com.twu28.biblioteca.library.exceptions.*;

public class Movie {
    private String name;
    private String director;
    private int rating = -1;

    public Movie(String name, String director, int rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() throws NoRatingSetException {
        if ( rating == -1 )
            throw new NoRatingSetException();
        return rating;
    }

    public String toFormattedString()
    {
        try
        {
            return String.format("%s %s %d", name, director, getRating());
        } catch (NoRatingSetException e) {
            return String.format("%s %s N/A", name, director);
        }
    }
}
