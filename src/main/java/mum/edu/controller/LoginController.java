/*
 * Created on Dec 17, 2017
 */
package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    public LoginController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping(value ="/loginError")
    public String loginFail(Model model) {
        //request.setAttribute("msg", null);
        model.addAttribute("msg","email or password is incorrect!!!");
        return "login";
    }
    
    @GetMapping(value ="/login")
    public String getLogin(Model model) {
        return "login";
    }
}
