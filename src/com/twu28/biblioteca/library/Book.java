package com.twu28.biblioteca.library;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean hasId(int bookId) {
        return bookId == id;
    }

    public String toFormattedString() {
        return String.format("%d %s %s", id, title, author);
    }
}
