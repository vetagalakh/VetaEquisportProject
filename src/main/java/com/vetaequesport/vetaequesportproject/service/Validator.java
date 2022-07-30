package com.vetaequesport.vetaequesportproject.service;

import org.springframework.stereotype.Component;

@Component
public class Validator {
    private static final String LOGIN_REGEX = "^[\\w_]{6,20}$";
    private static final String EMAIL_REGEX = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    private static final String PASSWORD_REGEX = "^.{8,30}$";
    private static final String PHONE_REGEX = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";
    private static final String CITY_REGEX = "^[\\p{L}_]{1,30}$";
    private static final String NAME_REGEX = "^[\\p{L}_]{1,30}$";
    private static final String SURNAME_REGEX = "^[\\p{L}_]{1,30}$";


    private static boolean validate(String data, String regex) {

        return data != null && data.matches(regex);

    }

    public boolean validateLogin(String login) {
        return validate(login, LOGIN_REGEX);

    }

    public boolean validatePassword(String password) {
        return validate(password, PASSWORD_REGEX);

    }

    public boolean validateEmail(String email) {
        return validate(email, EMAIL_REGEX);

    }
}
