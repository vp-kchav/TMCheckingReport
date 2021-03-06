package mum.edu.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.domain.Advisor;
import mum.edu.domain.Gender;
import mum.edu.domain.User;
import mum.edu.service.IAdvisorService;
import mum.edu.service.UserService;
import mum.edu.utils.StringUtils;

@Controller
public class AdvisorController {
	
	@Autowired
	private IAdvisorService advisorservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	JavaMailSender emailsender;
	
	@RequestMapping(value ="/addAdvisor",method = RequestMethod.GET)
	 public ModelAndView addAdvisor(@ModelAttribute("advisor") Advisor advisor, Model model) {
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("addAdvisor");
	        return mav;
	    }
	
	@RequestMapping(value="/advisorlist",method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("advisorlist", advisorservice.getAllAdvisor());
		return "advisorlist";
	}
	@RequestMapping(value="/advisordetail/{id}",method=RequestMethod.GET)
	public String getAdvisor(@PathVariable long id, Model model) {
		//model.addAttribute("genders", Gender.values());
		model.addAttribute("advisor",advisorservice.getAdvisor(id) );
		return "advisordetail";
	}
	
	@RequestMapping(value="/advisordetail/{id}",method=RequestMethod.POST)
	 public String updateAdvisor(@ModelAttribute("advisor") @Valid Advisor advisor, BindingResult result, Model model,@PathVariable int id) {
        String view = "redirect:/advisorlist";
        if (!result.hasErrors()){
        	advisorservice.updateAdvisor(id, advisor);;
           
        }else{
            view ="redirect:/advisordetail";
        }
        return view;
    }
		
	@RequestMapping(value="/deleteadvisor/{id}",method=RequestMethod.GET)
	public String deleteAdvisor(@PathVariable long id) {
		advisorservice.deleteAdvisor(id);
		return "redirect:/advisorlist";
	}
	
	@RequestMapping(value = {"/advisors"}, method = RequestMethod.POST)
    public String saveAdvisor(@ModelAttribute("advisor") @Valid Advisor advisor, BindingResult result, Model model) {
        String view = "redirect:/advisorlist";
        if (!result.hasErrors()){
        	advisorservice.addAdvisor(advisor);
            createLoginAccount(advisor);
        }else{
            view ="addAdvisor";
        }
        return view;
    }
	
	 private void createLoginAccount(Advisor advisor) {
	        User user = new User();
	        user.setStudentId(advisor.getAdvisorid());
	        user.setEmail(advisor.getEmail());
	        user.setRole(StringUtils.ROLE_ADMIN);
	        user.setPassword(StringUtils.generateRandomPassword());
	        userservice.save(user);
	        sendEmail(user);
	    }
	
	 private void sendEmail(User user) {
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(user.getEmail());
	        email.setSubject("Account created");
	        email.setText("Your account had been created with login: " + user.getStudentId() + " and password: " + user.getPassword());
	        emailsender.send(email);
	    }

}
