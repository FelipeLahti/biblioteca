package com.twu28.biblioteca.library;

import com.twu28.biblioteca.library.exceptions.AlreadyReservedBookException;
import com.twu28.biblioteca.library.exceptions.InvalidBookException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();
    private Map<Integer, ReservedBook> reservedBooks = new HashMap<Integer, ReservedBook>();

    public Library()
    {
        loadBooks();
        loadMovies();
    }

    private void loadMovies() {
        for(int i = 0; i < 14; i++)
        {
            movies.add(new Movie("Movie name", "Director " + i, i % 11));
        }

        movies.add(new Movie("Movie name - no rating", "Director"));
    }

    private void loadBooks() {
        for(int i = 0; i < 10; i++)
        {
            books.add(new Book(i, "Some book " + i, "Some author " + i));
        }
    }

    public List<Book> getAllBooksAvailable() {
        return books;
    }

    public void reserveBook(int bookId) throws InvalidBookException, AlreadyReservedBookException {
        Book book = findBookById(bookId);

        if ( book == null )
        {
            throw new InvalidBookException();
        }
        else if ( isBookReserved(book) )
        {
            throw new AlreadyReservedBookException();
        }
        else
        {
            reservedBooks.put(book.getId(), new ReservedBook(book.getId()));
        }
    }

    private boolean isBookReserved(Book book) {
        return reservedBooks.containsKey(book.getId());
    }

    public Book findBookById(int bookId) {
        for(Book book : books)
        {
            if ( book.hasId(bookId) )
                return book;
        }
        return null;
    }

    public List<Movie> getAllMoviesAvailable() {
        return movies;
    }
}
