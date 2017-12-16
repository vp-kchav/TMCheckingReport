package mum.edu.controller;

import mum.edu.domain.Student;
import mum.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public ModelAndView studentRegister(Student student, Model model){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("student");
        return mav;
    }
}
