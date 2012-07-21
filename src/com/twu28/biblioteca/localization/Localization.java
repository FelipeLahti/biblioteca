package com.twu28.biblioteca.localization;

public class Localization {

    public static final String WELCOME_MESSAGE = "Welcome customer!";
    public static final String EMBARRASING_MESSAGE = "Sorry, unknow error. Please contact your admin.";
    public static final String RETURN_MESSAGE = "Press enter to return to menu!";

    /////////////////////////// MENU OPTIONS //////////////////////////////
    public static final String MENU_HEADER_DEFAULT = "Select one option and press enter: (Hint: type the number of the menu option)";
    public static final String MENU_INVALID_SELECTION = "Invalid option selected. Try again!";

    /////////////////////////// MENU ITEMS //////////////////////////////
    public static final String MENU_VIEW_ALL_BOOKS = "View all books";
    public static final int SELECTOR_ID_VIEW_ALL_BOOKS = 1;

    public static final String MENU_VIEW_ALL_MOVIES = "View all movies";
    public static final int SELECTOR_ID_VIEW_ALL_MOVIES = 2;

    public static final String MENU_RESERVE_A_BOOK = "Reserve a book";
    public static final int SELECTOR_ID_RESERVE_A_BOOK = 3;

    public static final String MENU_CHECK_LIBRARY_NUMBER = "Check library number";
    public static final int SELECTOR_ID_CHECK_LIBRARY_NUMBER = 4;

    public static final String MENU_LOGIN = "Login";
    public static final int SELECTOR_LOGIN = 5;

    /////////////////////////// BOOK  //////////////////////////////
    public static final String BOOK_LIST_HEADER = "All books available:";
    public static final String BOOK_LIST_HEADER_2 = "Id | Title | Author:";

    public static final String INVALID_BOOK = "Sorry we don't have that book yet.";
    public static final String ALREADY_RESERVED = "The book is already reserved";
    public static final String BOOK_RESERVED = "Thank You! Enjoy the book.";
    public static final String WHAT_BOOK_DO_YOU_WANT = "Hey, what book do you want?";

    /////////////////////////// Library number  //////////////////////////////
    public static final String LIBRARY_USER_NUMBER = "Your library number is %s";
    public static final String CHECK_LIBRARY_INFORMATION = "Please talk to Librarian. Thank you.";

    /////////////////////////// MOVIE  //////////////////////////////
    public static final String MOVIE_LIST_HEADER = "Name | Director | Rating";

    public static final String LOGIN_REQUEST_LOGIN = "Login: ";
    public static final String LOGIN_REQUEST_PASSWORD = "Password: ";
    public static final String INVALID_LOGIN = "Invalid login or password. Try again.";
    public static final String VALID_LOGIN = "Logged with success. Welcome %s";
}