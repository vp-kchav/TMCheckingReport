/*
 * Created on Dec 17, 2017
 */
package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.domain.User;
import mum.edu.service.UserService;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
    
    @Autowired
    UserService userService;

    public LoginController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping(value ="/loginError")
    public String loginFail(Model model) {
        //request.setAttribute("msg", null);
        model.addAttribute("msg","student-ID or password is incorrect!!!");
        return "login";
    }
    
    @GetMapping(value ="/login")
    public String getLogin(Model model) {
        return "login";
    }
    
    @GetMapping(value = "/changepassword")
    public String chagePassword(Model model) {
        return "changepassword";
    }
    @PostMapping(value = "/changepassword")
    public String chagePassword(User user,Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails currentUser = (UserDetails) principal;
            String userId = currentUser.getUsername();
            User updateUser = userService.findById(userId);
            updateUser.setPassword(user.getPassword());
            userService.update(updateUser);
            String text = "Password had been changed successfuly!!!";
            model.addAttribute("text", text);
        }
        return "home";
    }
}
