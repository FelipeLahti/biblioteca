package com.twu28.biblioteca;

import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenu;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.menu.InvalidMenuException;
import com.twu28.biblioteca.ui.GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppLauncher {

    public static void main(String[] args)
    {
        GUI ui = new GUI();
        ui.showMessage(Localization.WELCOME_MESSAGE);

        AppMenu menu = new AppMenu();
        menu.addItem(new AppMenuItem(Localization.MENU_VIEW_ALL_BOOKS, Localization.SELECTOR_ID_VIEW_ALL_BOOKS));
        menu.addItem(new AppMenuItem(Localization.MENU_RESERVE_A_BOOK, Localization.SELECTOR_ID_RESERVE_A_BOOK));
        menu.addItem(new AppMenuItem(Localization.MENU_CHECK_LIBRARY_NUMBER, Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER));

        ui.showMenu(menu);

        while(true)
        {
            try {
                AppMenuItem itemSelected = menu.readOption();

                switch (itemSelected.getSelectorId())
                {
                    case Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER:
                        break;
                    case Localization.SELECTOR_ID_RESERVE_A_BOOK:
                        break;
                    case Localization.SELECTOR_ID_VIEW_ALL_BOOKS:
                        Library lib = new Library();
                        ui.clear();
                        ui.showViewAllBooks(lib.getAllBooksAvailable());
                        break;
                    default:
                        ui.showMessage(Localization.EMBARRASING_MESSAGE);
                        System.exit(1);
                }

                System.in.read();
                ui.clear();
                ui.showMenu(menu);

            } catch (IOException e) {
                ui.clear();
                ui.showMessage(Localization.MENU_INVALID_SELECTION);
                ui.showMenu(menu);
            } catch (InvalidMenuException e) {
                ui.clear();
                ui.showMessage(Localization.MENU_INVALID_SELECTION);
                ui.showMenu(menu);
            }
        }
    }
}
