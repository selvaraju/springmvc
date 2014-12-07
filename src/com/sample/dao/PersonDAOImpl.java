package com.sample.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.model.Department;
import com.sample.model.Employee;
import com.sample.model.MarkDetails;
import com.sample.model.Person;
@Transactional(readOnly = true)
public class PersonDAOImpl implements PersonDAO {
 
	protected HibernateTemplate template = null;
	
	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
    	template = new HibernateTemplate(sessionFactory);
    }
     
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(Person person) {
        template.saveOrUpdate(person);
    }
    
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void empsave(Employee employee) {
        template.saveOrUpdate(employee);
    }
 
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void depSave(Department department) {
        template.saveOrUpdate(department);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void markSave(MarkDetails markDetails) {
        template.saveOrUpdate(markDetails);
    }
    
    @SuppressWarnings("unchecked")
    public List<Person> list() {
    	return (List<Person>) template.find("from Person");
    }
    @SuppressWarnings("unchecked")
    public List<Employee> empList() {
        
        return (List<Employee>) template.find("from Employee");
    }
    
    @SuppressWarnings("unchecked")
    public List<Department> depList() {
        
        return (List<Department>) template.find("from department");
    }

}
