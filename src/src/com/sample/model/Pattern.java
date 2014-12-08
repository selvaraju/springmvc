package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATTERN")
public class Pattern {
	  @Id
	  @Column(name="id")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)	
private int id;
    
    private String name;
     
    
    private String detail;
    
    private String type;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}
    
	
	 public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	    public String toString(){
	        return "id="+id+", name="+name+", detail="+detail;
	    }

}
