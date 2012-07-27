package com.twu28.biblioteca;

import com.twu28.biblioteca.library.Movie;
import com.twu28.biblioteca.library.exceptions.*;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    private final String name = "Movie name";
    private final String director = "Director name";
    private final int validRating = 5;
    private final int invalidRating = 15;

    public MovieTest() {
    }

    @Test
    public void testMovieCreationWithRating() {

        Movie movie = new Movie(name, director, validRating);

        try {
            Assert.assertEquals(validRating, movie.getRating());
        } catch (NoRatingSetException e) {
            Assert.fail();
        }
    }

    @Test
    public void testMovieCreationWithoutRating() {

        Movie movie = new Movie(name, director);

        try {
            movie.getRating();
            Assert.fail();
        } catch (NoRatingSetException e) {

        }
    }

    @Test
    public void testFormattedStringWithRating()
    {
        Movie movie = new Movie(name, director, validRating);

        assertTrue(movie.toFormattedString().contains(String.valueOf(validRating)));
    }

    @Test
    public void testFormattedStringWithoutRating()
    {
        Movie movie = new Movie(name, director);

        assertEquals(true, movie.toFormattedString().contains("N/A"));
    }
}