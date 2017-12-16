package mum.edu.controller;
/*
 * Created on Nov 15, 2017
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.service.StudentService;
import mum.edu.service.TMCheckingService;
import mum.edu.service.UserService;


@Controller
public class HomeController {

    @Autowired
    TMCheckingService service;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    JavaMailSender sender;
    
    @RequestMapping(value="/test")
    public String email() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("kchav@mum.edu");
        email.setSubject("Hello World");
        email.setText("this is a email from mum");
        sender.send(email);
        return "home";
    }

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {       
        return "home";
    }
 
}
