package com.twu28.biblioteca;

import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenu;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.menu.InvalidMenuException;
import com.twu28.biblioteca.ui.GUI;

import java.io.IOException;

public class AppLauncher {

    public static void main(String[] args)
    {
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
                        break;
                    case Localization.SELECTOR_ID_RESERVE_A_BOOK:
                        break;
                    case Localization.SELECTOR_ID_VIEW_ALL_BOOKS:

                        ui.clear();
                        ui.showViewAllBooks(lib.getAllBooksAvailable());
                        break;
                    default:
                        ui.showMessage(Localization.EMBARRASING_MESSAGE);
                        System.exit(1);
                }

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
