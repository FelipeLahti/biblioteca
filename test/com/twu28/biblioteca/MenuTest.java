package com.twu28.biblioteca;

import com.twu28.biblioteca.localization.Localization;
import com.twu28.biblioteca.menu.AppMenu;
import com.twu28.biblioteca.menu.AppMenuItem;
import com.twu28.biblioteca.menu.InvalidMenuException;
import com.twu28.biblioteca.ui.GUI;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.*;

public class MenuTest {
    @Test
    public void testIfMenuHasNoOptionsWhenCreated()
    {
        AppMenu menu = new AppMenu();

        assertEquals(0, menu.getItems().size());
    }

    @Test
    public void testIfOneItemWasInserted()
    {
        AppMenu menu = new AppMenu();
        AppMenuItem item = new AppMenuItem("Some item", 1);

        menu.addItem(item);

        assertEquals(1, menu.getItems().size());
        assertEquals(item, menu.getItems().get(0));
    }

    @Test
    public void testIfMoreThanOneItemWasInserted()
    {
        AppMenu menu = new AppMenu();

        for (int i = 0; i < 3; i++)
        {
            AppMenuItem item = new AppMenuItem("Some item: " + i, i);
            menu.addItem(item);

            assertEquals(i + 1, menu.getItems().size());
            assertEquals(item, menu.getItems().get(i));
        }
    }

    @Test
    public void testSelectionInvalidMenuItem()
    {
        AppMenu menu = createMenuApp();

        boolean isValid = true;

        try {
            String invalidOption = "50000asd";
            System.setIn(new ByteArrayInputStream(invalidOption.getBytes()));

            menu.readOption();

            fail("Invalid menu! Must throw an exception");
        } catch (IOException e) {
            isValid = false;
        } catch (InvalidMenuException e) {
            isValid = false;
        }

        assertEquals("InvalidMenuException", false, isValid);
    }

    @Test
    public void testSelectionCorrectMenuItem()
    {
        AppMenu menu = createMenuApp();

        try {
            String invalidOption = "1";
            System.setIn(new ByteArrayInputStream(invalidOption.getBytes()));

            AppMenuItem item = menu.readOption();

            assertEquals(Integer.parseInt(invalidOption), item.getSelectorId());

        } catch (IOException e) {
            fail("IOException");
        } catch (InvalidMenuException e) {
            fail("InvalidMenuException");
        }
    }

    private AppMenu createMenuApp() {
        AppMenu menu = new AppMenu();
        menu.addItem(new AppMenuItem(Localization.MENU_VIEW_ALL_BOOKS, Localization.SELECTOR_ID_VIEW_ALL_BOOKS));
        menu.addItem(new AppMenuItem(Localization.MENU_RESERVE_A_BOOK, Localization.SELECTOR_ID_RESERVE_A_BOOK));
        menu.addItem(new AppMenuItem(Localization.MENU_CHECK_LIBRARY_NUMBER, Localization.SELECTOR_ID_CHECK_LIBRARY_NUMBER));
        return menu;
    }
}
