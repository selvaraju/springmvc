package com.sample.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
@PrimaryKeyJoinColumn(name="person_id")
public class Employee extends Person {
	
	   
	     @Column(name="joining_date")
	     private Date joiningDate;
	      
	     @Column(name="department_name")
	     private String departmentName;
 
	     @ManyToOne 
	     @JoinColumn(name="department_id")
	     private Department department;
	     
		public Date getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(Date joiningDate) {
			this.joiningDate = joiningDate;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		
		
	    
	  public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

	@Override
	public String toString() {
	// TODO Auto-generated method stub
		  return "departmentName="+departmentName+", joiningDate="+joiningDate+", person="+super.toString();
	}   
}
