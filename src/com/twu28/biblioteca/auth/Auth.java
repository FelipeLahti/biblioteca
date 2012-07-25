package com.twu28.biblioteca.auth;

import java.util.ArrayList;
import java.util.List;

public class Auth {

    public List<User> users = new ArrayList<User>();
    private boolean isLogged = false;
    private User userLogged;

    public Auth()
    {
        loadUsers();
    }

    private List<User> loadUsers() {

        for(int i = 1; i <= 5; i++)
        {
            users.add(new User("111-111" + i, "password" + i));
        }

        return users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public boolean login(String login, String password) {

        for(User user : users)
        {
            if ( user.match(login, password) )
            {
                userLogged = user;
                return isLogged = true;
            }
        }

        return false;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public User getUserLogged() {
        return userLogged;
    }

    public void logout() {
        isLogged = false;
        userLogged = null;
    }
}
