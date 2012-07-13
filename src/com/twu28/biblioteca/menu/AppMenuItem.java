package com.twu28.biblioteca.menu;

/**
 * Created with IntelliJ IDEA.
 * User: Avell
 * Date: 13/07/12
 * Time: 03:06
 * To change this template use File | Settings | File Templates.
 */
public class AppMenuItem {
    private String displayName;
    private int selectorId;

    public AppMenuItem(String displayName, int selectorId) {
        this.displayName = displayName;
        this.selectorId = selectorId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getSelectorId() {
        return selectorId;
    }
}
