package com.twu28.biblioteca.ui;

import com.twu28.biblioteca.library.Book;
import com.twu28.biblioteca.library.Movie;
import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenu;
import com.twu28.biblioteca.menu.AppMenuItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Avell
 * Date: 13/07/12
 * Time: 02:49
 * To change this template use File | Settings | File Templates.
 */
public class GUI {

    private AppMenu menu;

    public GUI()
    {
        createMenu();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMenu() {
        showMenuHeader();

        for(AppMenuItem item : menu.getItems())
        {
            showMenuItem(item);
        }
    }

    public void clear() {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    public void showViewAllBooks(List<Book> allBooksAvailable) {
        showBookListHeader();
        for(Book book : allBooksAvailable)
        {
            System.out.println(book.toFormattedString());
        }
    }

    public AppMenu getMenu()
    {
        return menu;
    }

    public void showViewAllMovies(List<Movie> movies) {
        showMovieHeader();

        for( Movie movie : movies )
        {
            System.out.println(movie.toFormattedString());
        }
    }

    private void createMenu() {
        menu = new AppMenu();
        menu.addItem(new AppMenuItem(Localization.MENU_VIEW_ALL_BOOKS, Localization.SELECTOR_ID_VIEW_ALL_BOOKS));
        menu.addItem(new AppMenuItem(Localization.MENU_VIEW_ALL_MOVIES, Localization.SELECTOR_ID_VIEW_ALL_MOVIES));
        menu.addItem(new AppMenuItem(Localization.MENU_RESERVE_A_BOOK, Localization.SELECTOR_ID_RESERVE_A_BOOK));
        menu.addItem(new AppMenuItem(Localization.MENU_CHECK_LIBRARY_NUMBER, Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER));
        menu.addItem(new AppMenuItem(Localization.MENU_LOGIN, Localization.SELECTOR_LOGIN));
    }

    private void showMenuHeader() {
        System.out.println(Localization.MENU_HEADER_DEFAULT);
    }

    private void showMenuItem(AppMenuItem item) {
        System.out.println(item.toFormattedString());
    }

    private void showBookListHeader() {
        System.out.println(Localization.BOOK_LIST_HEADER);
        System.out.println(Localization.BOOK_LIST_HEADER_2);
    }

    private void showMovieHeader() {
          System.out.println(Localization.MOVIE_LIST_HEADER);
    }
}
