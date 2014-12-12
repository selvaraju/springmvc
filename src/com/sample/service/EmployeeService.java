package com.sample.service;

import java.util.List;

import com.sample.model.Employee;

public interface EmployeeService { 	
	public List<Employee> getEmployeeList();
	public void empsave(Employee employee) ;
   public Employee getEmployeeByID(int id) ;
   public void removePerson(int id) ;
}
