package com.sample.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sample.service.EmployeeService;

public class HelloWorldController extends AbstractController{
	 
		@Autowired
		EmployeeService employeeService;
	
		@Override
		protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
			ModelAndView model = new ModelAndView("HelloWorldPage");
			model.addObject("list", employeeService.getEmployeeList());
	 
			return model;
		}

		public EmployeeService getEmployeeService() {
			return employeeService;
		}

		public void setEmployeeService(EmployeeService employeeService) {
			this.employeeService = employeeService;
		}
		
		
}
