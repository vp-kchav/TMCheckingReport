package mum.edu.controller;

import mum.edu.domain.Student;
import mum.edu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public ModelAndView studentRegisterForm(@ModelAttribute("student") Student stu, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student");
        return mav;
    }

    @RequestMapping(value = {"/studentRegistration"}, method = RequestMethod.POST)
    public String studentRegistration(@ModelAttribute("student") @Valid Student stu, BindingResult result, Model model) {
        String view = "redirect:/index";
        if (!result.hasErrors()){
            studentService.save(stu);
        }else{
            view ="student";
        }
        return view;
    }
}
