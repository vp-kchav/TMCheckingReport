/*
 * Created on Dec 17, 2017
 */
package mum.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.domain.CheckingStatus;
import mum.edu.domain.Student;
import mum.edu.domain.TMCheckingReport;
import mum.edu.service.StudentService;
import mum.edu.service.TMReportService;

@Controller
public class CheckingController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    TMReportService tmReportService;
    
    public CheckingController() {
        // TODO Auto-generated constructor stub
    }
    
    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    public String appointmentApprove(@RequestParam("id") Long id) {
        TMCheckingReport report = tmReportService.getById(id);
        report.setStatus(CheckingStatus.APPROVE);
        tmReportService.update(report);
        return "redirect:/listPendingChecking";

    }
    
    @RequestMapping(value = {"/listChecking"}, method = RequestMethod.GET)
    public ModelAndView listChecking(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String studentId = ((UserDetails)principal).getUsername();
            List<TMCheckingReport> reports = tmReportService.getByStudentId(studentId);
            model.addAttribute("reports", reports);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ListChecking");
        return mav;
    }
    
    @RequestMapping(value = {"/listPendingChecking"}, method = RequestMethod.GET)
    public ModelAndView listPendingChecking(Model model) {
        List<TMCheckingReport> requestPending = tmReportService.getPedingList();
        model.addAttribute("reports", requestPending);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ListPendingChecking");
        return mav;
    }
    
    @RequestMapping(value = {"/requestChecking"}, method = RequestMethod.GET)
    public ModelAndView requestChecking(@ModelAttribute("checking") TMCheckingReport checking, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TmChecking");
        return mav;
    }
    
    @RequestMapping(value = {"/requestChecking"}, method = RequestMethod.POST)
    public ModelAndView requestChecking(@ModelAttribute("checking") @Valid TMCheckingReport checking,BindingResult result, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String studentId = ((UserDetails)principal).getUsername();
            Student student = studentService.getByStudentId(studentId);
            checking.setStatus(CheckingStatus.PENDING);
            student.addChecking(checking);
            studentService.update(student);
        }
         ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

}
