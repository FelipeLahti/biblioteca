package com.twu28.biblioteca.menu;

import com.sun.org.apache.xml.internal.utils.BoolStack;
import com.twu28.biblioteca.ui.GUI;
import com.twu28.biblioteca.utils.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppMenu {

    private List<AppMenuItem> items = new ArrayList<AppMenuItem>();

    public List<AppMenuItem> getItems() {
        return items;
    }

    public void addItem(AppMenuItem item) {
        items.add(item);
    }

    public AppMenuItem readOption() throws IOException, InvalidMenuException {

        try {
            int optionSelected = Integer.parseInt(IOUtils.readLine());

            for(int i = 0; i < items.size(); i++)
            {
                if ( items.get(i).getSelectorId() == optionSelected )
                {
                    return items.get(i);
                }
            }

            throw new InvalidMenuException();
        } catch (NumberFormatException e)
        {
            throw new InvalidMenuException();
        }
    }
}
