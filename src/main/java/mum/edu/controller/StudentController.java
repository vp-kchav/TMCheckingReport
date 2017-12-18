package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.domain.Student;
import mum.edu.domain.User;
import mum.edu.service.StudentService;
import mum.edu.service.TMReportService;
import mum.edu.service.UserService;
import mum.edu.utils.StringUtils;

import java.util.List;

@Controller
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    TMReportService tmReportService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    JavaMailSender sender;
    
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
            manageUserCreation(stu);
        }else{
            view ="student";
        }
        return view;
    }

    @RequestMapping(value = {"/listStudents"}, method = RequestMethod.GET)
    public ModelAndView listStudent(Model model){
//        List<Student> studentList = studentService.getCheckedStudents();
//        System.out.println(studentList);
        return null;
    }
    
    /**
     * 
     * @param student
     */
    private void manageUserCreation(Student student) {
        User user = new User();
        user.setStudentId(student.getStudentId());
        user.setEmail(student.getEmail());
        user.setRole(StringUtils.ROLE_USER);
        user.setPassword(StringUtils.generateRandomPassword());
        userService.save(user);
        sendEmail(user);
    }
    
    /**
     * 
     * @param user
     */
    private void sendEmail(User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Account created");
        email.setText("Your account had been created with login: " + user.getStudentId() + " and password: " + user.getPassword());
        sender.send(email);
    }
}
