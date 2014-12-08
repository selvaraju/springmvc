package com.sample;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.dao.PersonDAO;
import com.sample.model.Department;
import com.sample.model.Employee;
import com.sample.model.MarkDetails;
 

public class Test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	        
		/*PatternDoa patternDAO = (PatternDoa) context.getBean("personDAO");
         
		Pattern pattern = new Pattern();
		pattern.setName("Composite"); 
		pattern.setDetail("Tree Structure");
		pattern.setType("Structural");
	 
		patternDAO.save(pattern);*/
         
        //System.out.println("Person::"+person);
         
       /* List<Pattern> list = patternDAO.list();
         
        for(Pattern p : list){
            System.out.println("Person List::"+p);
        }*/
        //close resources
		
		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
	 
		Employee emp = new Employee();
		Department department = new Department();
		department.setDepartmentId(new Long(112));
		department.setDepartmentName("Sales Dep");
		emp.setName("Santhosh Natarajan");
		 
		emp.setDepartmentName("Purchase");
		emp.setJoiningDate(new Date());
		emp.setDepartment(department);
		
		MarkDetails markDetails = new MarkDetails();
		markDetails.setMarksObtained("100");
		markDetails.setMaxMarks("100");
		markDetails.setPerson(emp);
		markDetails.setResult("Pass");
		markDetails.setSubject("English");
		
		
		MarkDetails markDetails1 = new MarkDetails();
		markDetails1.setMarksObtained("90");
		markDetails1.setMaxMarks("100");
		markDetails1.setPerson(emp);
		markDetails1.setResult("Pass");
		markDetails1.setSubject("Tamil");
		
	 
		personDAO.depSave(department); 
		personDAO.empsave(emp);
		personDAO.markSave(markDetails);
		personDAO.markSave(markDetails1);
    
        List<Employee> list = personDAO.empList();
        
        for(Employee p : list){
            System.out.println("EMP List::"+p);
            System.out.println("DEPT List::"+p.getDepartment().getDepartmentName());
            System.out.println("MARK:"+p.getMarksDetails());
        }
        
        
       
        context.close();  
        
	}

}
