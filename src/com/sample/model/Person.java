package com.sample.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	
	  @Id
	  @Column(name="person_id")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int person_id;
    
    private String name;
     
    private String country;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "person")  
    private Set<MarkDetails> marksDetails;  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
    
	 public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	
	
	public Set<MarkDetails> getMarksDetails() {
		return marksDetails;
	}

	public void setMarksDetails(Set<MarkDetails> marksDetails) {
		this.marksDetails = marksDetails;
	}

	@Override
	    public String toString(){
	        return "person_id="+person_id+", name="+name+", country="+country;
	    }

}
