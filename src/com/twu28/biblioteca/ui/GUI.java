package com.twu28.biblioteca.ui;

import com.twu28.biblioteca.Book;
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
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMenu(AppMenu menu) {

        showMenuHeader();

        for(AppMenuItem item : menu.getItems())
        {
            showItem(item);
        }
    }

    private void showMenuHeader() {
        System.out.println(Localization.MENU_HEADER_DEFAULT);
    }

    private void showItem(AppMenuItem item) {
        System.out.println(String.format("%d) %s", item.getSelectorId(), item.getDisplayName()));
    }

    public void clear() {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    public void showViewAllBooks(List<Book> allBooksAvailable) {
        showBookListHeader();
        for(Book book : allBooksAvailable)
        {
            System.out.println(String.format("%d %s %s", book.getId(), book.getTitle(), book.getAuthor()));
        }
    }

    private void showBookListHeader() {
        System.out.println(Localization.BOOK_LIST_HEADER);
        System.out.println(Localization.BOOK_LIST_HEADER_2);
    }
}
