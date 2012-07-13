package com.twu28.biblioteca;

import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenu;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.ui.GUI;
import org.junit.Test;

public class GUITests {

    @Test
    public void testIfWelcomeMessageIsDisplayed()
    {
        GUI ui = new GUI();
        ui.showMessage(Localization.WELCOME_MESSAGE);

        //Coach Question: How can I test if a message was displayed on console? Is there a better way for doing GUI tests?
    }

    @Test
    public void testIfMenuIsDisplayed()
    {
        AppMenu menu = new AppMenu();
        menu.addItem(new AppMenuItem(Localization.MENU_VIEW_ALL_BOOKS, Localization.SELECTOR_ID_VIEW_ALL_BOOKS));
        menu.addItem(new AppMenuItem(Localization.MENU_RESERVE_A_BOOK, Localization.SELECTOR_ID_RESERVE_A_BOOK));
        menu.addItem(new AppMenuItem(Localization.MENU_CHECK_LIBRARY_NUMBER, Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER));

        GUI ui = new GUI();
        ui.showMenu();

        //Coach Question: Same question above.
    }
}
