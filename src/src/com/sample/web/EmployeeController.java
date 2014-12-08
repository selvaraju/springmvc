package com.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.model.Employee;
import com.sample.service.EmployeeService;
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	 
	 
	 @RequestMapping("/employee")
	    public String load( Model model){
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("list", employeeService.getEmployeeList());
	        return "employee";
	    }
	 
	 
	  @RequestMapping(value= "/addEmployee", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("employee") Employee employee){
		  System.out.println(employee);
		  employeeService.empsave(employee);
	        return "redirect:/employee";
	         
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
}
