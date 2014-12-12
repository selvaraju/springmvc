package com.sample.web;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.exception.CustomGenericException;
import com.sample.model.Employee;
import com.sample.service.EmployeeService;
@Controller
public class EmployeeController {

	 private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	   
	 
	@Autowired
	EmployeeService employeeService;
	 
	 
	 @RequestMapping("/employee")
	    public String load( Model model,Locale locale){
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("list", employeeService.getEmployeeList());
	        System.out.println("**********************************************");
	        System.out.println("Welcome home! The client locale is "+locale);
	        System.out.println("**********************************************");
	        throw new CustomGenericException("101", "TEST MESSAGE");
	        //return "employee";
	    }
	 
	 
	  @RequestMapping(value= "/addEmployee", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("employee") @Valid Employee employee,BindingResult bindingResult,Locale locale){
		  System.out.println(employee);
		  logger.info("Welcome home! The client locale is {}.", locale);
		  if (bindingResult.hasErrors()) {
			  System.out.println("Valicdation Failed::::");
			  System.out.println(bindingResult.getAllErrors().size());
			    return "employee";
		  }else{
			 	employeeService.empsave(employee); 
			    return "redirect:/employee";
		  }
		 
		 
	    
	         
	    }
	  
	  @RequestMapping("/remove/{id}")
	    public String removePerson(@PathVariable("id") int id){
	         
		  employeeService.removePerson(id);
	        return "redirect:/employee";
	    }
	 
	 
	 @RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	        model.addAttribute("employee", employeeService.getEmployeeByID(id));
	        model.addAttribute("list", employeeService.getEmployeeList());
	        return "employee";
	    }
	 
	 
	 @ExceptionHandler(CustomGenericException.class)
		public ModelAndView handleCustomException(CustomGenericException ex) {
	 
			ModelAndView model = new ModelAndView("error");
			model.addObject("errCode", ex.getErrCode());
			model.addObject("errMsg", ex.getErrMsg());
	 
			return model;
	 
		}
	 
	 
	 @ExceptionHandler(Exception.class)
		public ModelAndView handleAllException(Exception ex) {
	 
			ModelAndView model = new ModelAndView("error");
			model.addObject("errMsg", "this is Exception.class");
	 
			return model;
	 
		}
	 
}
