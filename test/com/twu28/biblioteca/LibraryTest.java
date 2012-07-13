package com.twu28.biblioteca;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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
        Library l = new Library();
        //l.loadBooks();
        //Coach Question: How to test private methods
    }
}
