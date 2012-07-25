package com.twu28.biblioteca;

import com.twu28.biblioteca.auth.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UserTest {

    private String login = "111-1111";
    private String password = "password1";

    @Test
    public void testUserCreation()
    {
        User user = new User(login, password);

        assertEquals(login, user.getLogin());
    }

    @Test
    public void testUserMatch()
    {
        User u = new User(login, password);
        assertTrue(u.match(login, password));
    }

    @Test
    public void testUserNotMatch()
    {
        User u = new User(login, password);
        assertFalse(u.match(login, password + "123"));
    }

    @Test
    public void testIfUserIsLibrarian()
    {
        User u = new User(login, password);

        assertTrue(u.isLibrarian());
    }

    @Test
    public void testIfUserIsNotLibrarian()
    {
        User u = new User("111-1112", password);

        assertFalse(u.isLibrarian());
    }
}
