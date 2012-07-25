package com.twu28.biblioteca;

import com.twu28.biblioteca.auth.Auth;
import com.twu28.biblioteca.library.exceptions.AlreadyReservedBookException;
import com.twu28.biblioteca.library.exceptions.InvalidBookException;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.menu.InvalidMenuException;
import com.twu28.biblioteca.ui.GUI;
import com.twu28.biblioteca.utils.IOUtils;

import java.io.IOException;

public class AppController {

    private static Library lib;
    private static GUI ui;
    private static Auth auth;

    public static void main(String[] args) throws InterruptedException {
        lib = new Library();
        auth = new Auth();

        ui = new GUI();
        ui.showMessage(Localization.WELCOME_MESSAGE);
        ui.showMenu();

        while(true)
        {
            try {
                AppMenuItem itemSelected = ui.getMenu().readOption();

                switch (itemSelected.getSelectorId())
                {
                    case Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER:
                        checkLibraryInfo();
                        break;
                    case Localization.SELECTOR_ID_RESERVE_A_BOOK:
                        reserveBook();
                        break;
                    case Localization.SELECTOR_ID_VIEW_ALL_BOOKS:
                        viewAllBooks();
                        break;
                    case Localization.SELECTOR_ID_VIEW_ALL_MOVIES:
                        viewAllMovies();
                        break;
                    case Localization.SELECTOR_LOGIN:
                        doLogin();
                        break;
                    case Localization.SELECTOR_LOGOUT:
                        auth.logout();
                        break;
                    case Localization.SELECTOR_EXIT:
                        System.exit(0);
                        break;
                    default:
                        defaultActionForUnknownError();
                }

                ui.showMessage(Localization.RETURN_MESSAGE);
                IOUtils.readLine();
                ui.clear();
                ui.showMenu();

            } catch (IOException e) {
                handleInvalidMenu();
            } catch (InvalidMenuException e) {
                handleInvalidMenu();
            }
        }
    }

    private static void doLogin() {
        ui.clear();
        try {
            System.out.println(Localization.LOGIN_REQUEST_LOGIN);
            String login = IOUtils.readLine();

            System.out.println(Localization.LOGIN_REQUEST_PASSWORD);
            String password = IOUtils.readLine();

             if ( !auth.login(login, password) )
             {
                 ui.showMessage(Localization.INVALID_LOGIN);
             }
             else
             {
                 ui.showMessage(String.format(Localization.VALID_LOGIN, auth.getUserLogged().getLogin()));
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void defaultActionForUnknownError() {
        ui.showMessage(Localization.EMBARRASING_MESSAGE);
        System.exit(1);
    }

    private static void handleInvalidMenu() {
        ui.clear();
        ui.showMessage(Localization.MENU_INVALID_SELECTION);
        ui.showMenu();
    }

    private static void viewAllMovies() {
        ui.clear();
        ui.showViewAllMovies(lib.getAllMoviesAvailable());
    }

    private static void viewAllBooks() {
        ui.clear();
        ui.showViewAllBooks(lib.getAllBooksAvailable());
    }

    private static void reserveBook() throws IOException {
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
    }

    private static void checkLibraryInfo() {
        if (!auth.isLogged())
        {
            ui.showMessage(Localization.CHECK_LIBRARY_INFORMATION);
        }
        else
        {
            ui.showMessage(String.format(Localization.LIBRARY_USER_NUMBER, auth.getUserLogged().getLogin()));
        }
    }
}
