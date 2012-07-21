package com.twu28.biblioteca;

import com.twu28.biblioteca.library.exceptions.AlreadyReservedBookException;
import com.twu28.biblioteca.library.exceptions.InvalidBookException;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.menu.InvalidMenuException;
import com.twu28.biblioteca.ui.GUI;
import com.twu28.biblioteca.utils.IOUtils;

import java.io.IOException;

public class AppLauncher {

    public static void main(String[] args) throws InterruptedException {
        Library lib = new Library();

        GUI ui = new GUI();
        ui.showMessage(Localization.WELCOME_MESSAGE);
        ui.showMenu();

        while(true)
        {
            try {
                AppMenuItem itemSelected = ui.getMenu().readOption();

                switch (itemSelected.getSelectorId())
                {
                    case Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER:
                        ui.showMessage(Localization.CHECK_LIBRARY_INFORMATION);
                        break;

                    case Localization.SELECTOR_ID_RESERVE_A_BOOK:
                        ui.clear();
                        ui.showMessage(Localization.WHAT_BOOK_DO_YOU_WANT);

                        try {
                            int bookId = Integer.parseInt(IOUtils.readLine());
                            lib.reserveBook(bookId);
                            ui.showMessage(Localization.BOOK_RESERVED);
                        } catch (InvalidBookException e) {
                            ui.showMessage(Localization.INVALID_BOOK);
                        } catch (AlreadyReservedBookException e) {
                            ui.showMessage(Localization.ALREADY_RESERVED);
                        } catch (NumberFormatException e) {
                            ui.showMessage(Localization.INVALID_BOOK);
                        }

                        break;

                    case Localization.SELECTOR_ID_VIEW_ALL_BOOKS:
                        ui.clear();
                        ui.showViewAllBooks(lib.getAllBooksAvailable());
                        break;

                    case Localization.SELECTOR_ID_VIEW_ALL_MOVIES:
                        ui.clear();
                        ui.showViewAllMovies(lib.getAllMoviesAvailable());
                        break;
                    default:
                        ui.showMessage(Localization.EMBARRASING_MESSAGE);
                        System.exit(1);
                }

                ui.showMessage(Localization.RETURN_MESSAGE);
                System.in.read();
                ui.clear();
                ui.showMenu();

            } catch (IOException e) {
                ui.clear();
                ui.showMessage(Localization.MENU_INVALID_SELECTION);
                ui.showMenu();
            } catch (InvalidMenuException e) {
                ui.clear();
                ui.showMessage(Localization.MENU_INVALID_SELECTION);
                ui.showMenu();
            }
        }
    }
}
