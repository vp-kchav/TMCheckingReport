package mum.edu.controller;
/*
 * Created on Nov 15, 2017
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.service.StudentService;
import mum.edu.service.TMReportService;
import mum.edu.service.UserService;


@Controller
@SessionAttributes("currentUser")
public class HomeController {

    @Autowired
    TMReportService service;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails currentUser = (UserDetails) principal;
            model.addAttribute("currentUser", currentUser);
        }
        return "home";
    }
 
}
