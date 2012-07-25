package com.twu28.biblioteca;

import com.twu28.biblioteca.library.Book;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class BookTest {
    @Test
    public void testToFormattedString()
    {
        int id = 0;
        String name = "Book name";
        String author = "Some author";

        Book book = new Book(id, name, author);

        String result = book.toFormattedString();

        assertEquals(id + " " + name + " " + author, book.toFormattedString());
    }
}
