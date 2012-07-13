package com.twu28.biblioteca.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<Book>();

    public Library()
    {
        loadBooks();
    }

    private void loadBooks() {
        //TODO: Load xml books
        for(int i = 0; i < 10; i++)
        {
            books.add(new Book(i, "Some book " + i, "Some description " + i));
        }
    }

    public List<Book> getAllBooksAvailable() {
        return books;
    }

    public void reserveBook(int bookId) throws InvalidBookException {
        Book book = findBookById(bookId);

        if ( book == null )
        {
            throw new InvalidBookException();
        }
    }

    public Book findBookById(int bookId) {
        for(Book book : books)
        {
            if ( book.getId() == bookId )
                return book;
        }
        return null;
    }
}
