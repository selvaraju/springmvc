package com.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.model.Employee;
import com.sample.service.EmployeeService;
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	 @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("employee", "command", new Employee());
	   }
	 
	 
	 @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Employee employee, 
	   ModelMap model) {
	   
	      System.out.println("employee:"+employee);
	      employeeService.empsave(employee);
		  //model.addObject("list", employeeService.getEmployeeList());
		  
		  model.addAttribute("list", employeeService.getEmployeeList());
	      return "HelloWorldPage";
	   }
}
