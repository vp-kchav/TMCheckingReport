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
		model.addAttribute("advisor",advisorservice.getAdvisor(id) );
		return "advisordetail";
	}
	
	@RequestMapping(value="/advisordetail/{id}",method=RequestMethod.POST)
	 public String updateAdvisor(@ModelAttribute("advisor") @Valid Advisor advisor, BindingResult result, Model model,@PathVariable int id) throws Exception{
        String view = "redirect:/advisorlist";
        if(result.hasErrors()) {
        	throw new Exception(result.getFieldError().getDefaultMessage());
        }
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
    public String saveAdvisor(@ModelAttribute("advisor") @Valid Advisor advisor, BindingResult result, Model model) throws Exception{
        String view = "redirect:/advisorlist";
        if(result.hasErrors()) {
        	throw new Exception(result.getFieldError().getDefaultMessage());
        }
        if (!result.hasErrors()){
        	advisorservice.addAdvisor(advisor);
            //createLoginAccount(advisor);
        }else{
            view ="addAdvisor";
        }
        return view;
    }
	
	 private void createLoginAccount(Advisor advisor) {
	        User user = new User();
	        user.setStudentId(advisor.getAdvisorid());
	        user.setEmail(advisor.getEmail());
	        user.setRole(StringUtils.ROLE_USER);
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

//	 public synchronized static boolean sendMailAdvance(String emailTo, String subject, String body)
//	 {
//	 String host = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-ADDRESS");
//	 String userName = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-USERNAME");
//	 String password = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-PASSWORD");
//	 String port = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-PORT");
//	 String starttls = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-STARTTLS");
//	 String socketFactoryClass = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-SOCKET-CLASS");
//	 String fallback = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-ALLOW-FALLBACK");                         
//
//	         try
//	         {
//	             java.util.Properties props = null;
//	             props = System.getProperties();
//	             props.put("mail.smtp.user", userName);
//	             props.put("mail.smtp.host", host);
//	             props.put("mail.smtp.auth", "true");
//	             props.put("mail.smtp.debug", "true");
//
//	             if(!"".equals(port))
//	             {
//	                 props.put("mail.smtp.port", port);
//	                 props.put("mail.smtp.socketFactory.port", port);
//	             }
//
//	             if(!"".equals(starttls))
//	                 props.put("mail.smtp.starttls.enable",starttls);
//
//	             if(!"".equals(socketFactoryClass))
//	                 props.put("mail.smtp.socketFactory.class",socketFactoryClass);
//
//	             if(!"".equals(fallback))
//	                 props.put("mail.smtp.socketFactory.fallback", fallback);
//
//	             Session session = Session.getDefaultInstance(props, null);
//	             session.setDebug(true);
//
//	             MimeMessage msg = new MimeMessage(session);
//	             msg.setFrom(new InternetAddress(userName));
//	             msg.setSubject(subject);                
//	             msg.setText(body, "ISO-8859-1");
//	             msg.setSentDate(new Date());
//	             msg.setHeader("content-Type", "text/html;charset=\"ISO-8859-1\"");
//	             msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
//	             msg.saveChanges();
//
//	             Transport transport = session.getTransport("smtp");
//	             transport.connect(host, userName, password);
//	             transport.sendMessage(msg, msg.getAllRecipients());
//	             transport.close();
//
//	             return true;
//	         }
//	         catch (Exception mex)
//	         {
//	             mex.printStackTrace();
//	             return false;
//	         }
//	 }
}
