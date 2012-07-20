package com.twu28.biblioteca;

import com.twu28.biblioteca.library.Book;
import com.twu28.biblioteca.library.exceptions.InvalidBookException;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.exceptions.AlreadyReservedBookException;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

public class LibraryTest {

    @Test
    public void testGetAllBook()
    {
        Library lib = new Library();
        List<Book> books = lib.getAllBooksAvailable();

        assertEquals(10, books.size());
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
        } catch (AlreadyReservedBookException e) {
            fail();
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
        } catch (AlreadyReservedBookException e) {
            fail();
        }
    }

    @Test
    public void testReservedBook()
    {
        int bookId = 1;

        Library lib = new Library();
        try {
            lib.reserveBook(bookId);
            lib.reserveBook(bookId);
            fail();
        } catch (InvalidBookException e) {
            fail();
        } catch (AlreadyReservedBookException e2)
        {

        }
    }

    @Test
    public void testFindBookThatExists()
    {
        Library lib = new Library();

        assertEquals(1, lib.findBookById(1).getId());
    }

    @Test
    public void testFindBookThatNotExists()
    {
        Library lib = new Library();

        assertNull(lib.findBookById(-1111));
    }
}
