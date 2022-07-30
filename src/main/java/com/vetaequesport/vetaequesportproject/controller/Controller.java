package com.vetaequesport.vetaequesportproject.controller;

import com.vetaequesport.vetaequesportproject.entity.ApplicationForm;
import com.vetaequesport.vetaequesportproject.entity.LoginForm;
import com.vetaequesport.vetaequesportproject.entity.RegistrationForm;
import com.vetaequesport.vetaequesportproject.repository.UserRepository;
import com.vetaequesport.vetaequesportproject.service.ParticipantService;
import com.vetaequesport.vetaequesportproject.service.impl.ParticipantServiceImpl;
import com.vetaequesport.vetaequesportproject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
    private UserServiceImpl service;
    private ParticipantServiceImpl participantService;


    @Autowired
    Controller(UserServiceImpl service, ParticipantServiceImpl participantService)  {
        this.service = service;
        this.participantService = participantService;
    }

    @GetMapping("/registration")
    public String start(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("loginForm", new LoginForm());
        model.addAttribute("applicationForm", new ApplicationForm());
        return "index.html";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("registrationForm") RegistrationForm registrationForm, Model model) {
        System.out.println(registrationForm);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);
        session.setAttribute("registrationStatus", service.addUser(registrationForm));
        return "redirect:registration";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        System.out.println(loginForm);
        System.out.println(service.findUser(loginForm));
        return "redirect:registration";
    }

    @PostMapping("/application")
    public String login(@ModelAttribute("applicationForm") ApplicationForm applicationForm, Model model) {

        System.out.println(applicationForm);
        participantService.addParticipant(applicationForm);
        return "redirect:registration";
    }
}
