package com.twu28.biblioteca;

import com.twu28.biblioteca.library.Book;
import com.twu28.biblioteca.library.InvalidBookException;
import com.twu28.biblioteca.library.Library;
import org.junit.Test;

import static junit.framework.Assert.*;

public class LibraryTest {

    @Test
    public void testGetAllBook()
    {
        Library lib = new Library();
        assertNotNull(lib.getAllBooksAvailable());
    }

    @Test
    public void testBookCreation()
    {
        int id = 0;
        String name = "Book name";
        String description = "Book description";

        Book book = new Book(id, name, description);

        assertEquals(id, book.getId());
        assertEquals(name, book.getTitle());
        assertEquals(description, book.getAuthor());
    }

    @Test
    public void testLoadBooks()
    {
        Library lib = new Library();
        //l.loadBooks();
        //Coach Question: How to test private methods
    }

    @Test
    public void testReserveInvalidItemLibrary()
    {
        int bookId = -1023;

        try
        {
            Library lib = new Library();
            lib.reserveBook(bookId);
            fail();
        } catch (InvalidBookException e)
        {
        }
    }

    @Test
    public void testReserveValidBook()
    {
        int bookId = 1;

        Library lib = new Library();
        try {
            lib.reserveBook(bookId);
        } catch (InvalidBookException e) {
            fail();
        }
    }

    @Test
    public void testFindBookThatExists()
    {
        Library lib = new Library();

        assertNotNull(lib.findBookById(1));
    }

    @Test
    public void testFindBookThatNotExists()
    {
        Library lib = new Library();
        assertNull(lib.findBookById(-1111));
    }
}
