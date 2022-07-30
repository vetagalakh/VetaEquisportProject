package com.vetaequesport.vetaequesportproject.service.impl;

import com.vetaequesport.vetaequesportproject.entity.LoginForm;
import com.vetaequesport.vetaequesportproject.entity.RegistrationForm;
import com.vetaequesport.vetaequesportproject.entity.User;
import com.vetaequesport.vetaequesportproject.repository.UserRepository;
import com.vetaequesport.vetaequesportproject.service.UserService;
import com.vetaequesport.vetaequesportproject.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.vetaequesport.vetaequesportproject.constant.RegistrationAttributes.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private Validator validator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public String addUser(RegistrationForm registrationForm) {
        String result = validateRegistration(registrationForm);
        if (result.equals(OK)) {
            result = userRepository.checkLogin(registrationForm.getLogin()).isPresent() ? LOGIN_EXISTS : OK;
        }
        if (result.equals(OK)){
            result = userRepository.checkEmail(registrationForm.getEmail()).isPresent() ? EMAIL_EXISTS: OK;
        }
        System.out.println(result);
        if (result.equals(OK)) {
            userRepository.addUser(registrationForm.getLogin(), registrationForm.getEmail(), registrationForm.getPassword());
            return OK;
        }

        else if (result.equals(LOGIN_EXISTS)){
            return LOGIN_EXISTS;
        }
        else if (result.equals(EMAIL_EXISTS)) {
            return EMAIL_EXISTS;
        }
        else if (result.equals(NO_LOGIN)){
            return NO_LOGIN;
        }
        else if (result.equals(NO_PASSWORD)){
            return NO_PASSWORD;
        }
        else if (result.equals(NO_EMAIL)){
            return NO_EMAIL;
        }
        else if (result.equals(PASSWORD_NO_EQUALS)){
            return PASSWORD_NO_EQUALS;
        }

        return result;
    }

    public String validateRegistration(RegistrationForm registrationForm){
        String result = OK;
        if (!validator.validateLogin(registrationForm.getLogin())){
            result = NO_LOGIN;
        }
        else if (!validator.validatePassword(registrationForm.getPassword())){
            result = NO_PASSWORD;
        }
        else if (!validator.validateEmail(registrationForm.getEmail())){
            result = NO_EMAIL;
        }
        else if (!registrationForm.getPassword().equals(registrationForm.getPasswordRepeated())){
            result = PASSWORD_NO_EQUALS;
        }
        return result;
    }
    public Optional<Integer> findUser(LoginForm loginForm) {
        return userRepository.findUser(loginForm.getLogin(), loginForm.getPassword());
    }


}
