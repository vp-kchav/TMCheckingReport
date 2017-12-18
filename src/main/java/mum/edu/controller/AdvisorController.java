package mum.edu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.dao.IAdvisorDao;
import mum.edu.domain.Advisor;
import mum.edu.domain.Gender;

@Controller
public class AdvisorController {
	
	//@Resource(name = "singleTransactionsService")
	private IAdvisorDao advisorDao;
	
	@GetMapping(path="/addAdvisor")
	public String addAdvisor() {
		
//		advisorDao.addAdvisor(advisor);
		return "addAdvisor";
		
	}
	
	@RequestMapping(value="/advisors", method=RequestMethod.POST)
	public String saveAdvisor(Advisor advisor) {
		
			//advisor.setGender(Enum.valueOf(Gender.class, gender));
			advisorDao.addAdvisor(advisor);
			return "redirect:/advisors";
			//return "ok";
			
		}

}
