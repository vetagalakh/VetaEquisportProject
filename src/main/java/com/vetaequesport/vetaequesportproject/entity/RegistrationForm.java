package com.vetaequesport.vetaequesportproject.entity;

import java.util.Objects;

public class RegistrationForm {
    private String email;
    private String login;
    private String password;
    private String passwordRepeated;

    public RegistrationForm(String email, String login, String password, String passwordRepeated) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.passwordRepeated = passwordRepeated;
    }

    public RegistrationForm() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationForm that = (RegistrationForm) o;
        return Objects.equals(email, that.email) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(passwordRepeated, that.passwordRepeated);
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, login, password, passwordRepeated);

    }
    @Override
    public String toString() {
        return "RegistrationForm{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", passwordRepeated='" + passwordRepeated + '\'' +
                '}';
    }


}
