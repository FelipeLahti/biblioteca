package com.twu28.biblioteca.auth;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public boolean match(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public boolean isLibrarian() {
        return login.equals("111-1111");
    }
}
