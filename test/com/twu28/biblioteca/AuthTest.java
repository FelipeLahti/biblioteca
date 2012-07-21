package com.twu28.biblioteca;

import com.twu28.biblioteca.auth.Auth;
import com.twu28.biblioteca.auth.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AuthTest {

    private String login = "111-1111";
    private String password = "password1";

    @Test
    public void testGetAllUsers()
    {
        Auth authSys = new Auth();

        List<User> users = authSys.getAllUsers();

        assertEquals(5, users.size());
    }

    @Test
    public void testUserCreation()
    {
        User user = new User(login, password);

        assertEquals(login, user.getLogin());
    }

    @Test
    public void testUserLoginSuccess()
    {
        Auth auth = new Auth();

        assertEquals(true, auth.login(login, password));
        assertEquals(true, auth.isLogged());
        assertEquals(login, auth.getUserLogged().getLogin());
    }

    @Test
    public void testUserLoginFail()
    {
        Auth auth = new Auth();

        assertEquals(false, auth.login(login, password + "123"));
        assertEquals(false, auth.isLogged());
        assertEquals(null, auth.getUserLogged());
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
