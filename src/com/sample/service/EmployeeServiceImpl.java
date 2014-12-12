package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.dao.PersonDAO;
import com.sample.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	PersonDAO personDAO;
	
	
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return personDAO.empList();
	}

	public void empsave(Employee employee) {
		personDAO.empsave(employee);
	}

	 public Employee getEmployeeByID(int id) {
		 
		 return personDAO.getEmployeeByID(id);
	 }
	public PersonDAO getPersonDAO() {
		return personDAO;
	}


	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public void removePerson(int id) {
		 
		personDAO.removePerson(id);
	}
	
	

}
