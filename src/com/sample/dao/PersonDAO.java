package com.sample.dao;

import java.util.List;

import com.sample.model.Department;
import com.sample.model.Employee;
import com.sample.model.MarkDetails;
import com.sample.model.Person;

public interface PersonDAO {
	
	public void save(Person p);
	
	public void empsave(Employee employee);
	
	public void markSave(MarkDetails markDetails) ;
    
    public List<Person> list();
    
    public List<Employee> empList() ;
    
    public void depSave(Department department) ;
    
    public List<Department> depList() ;
}
