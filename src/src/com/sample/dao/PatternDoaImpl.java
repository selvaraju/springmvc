package com.sample.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.model.Pattern;
@Transactional(readOnly = true)
public class PatternDoaImpl implements PatternDoa{

	protected HibernateTemplate template = null; 
	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
    	template = new HibernateTemplate(sessionFactory);
    }
     
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(Pattern pattern) {
        template.saveOrUpdate(pattern);
    }
 
    @SuppressWarnings("unchecked")
  
    public List<Pattern> list() {
      
        return (List<Pattern>) template.find("from Pattern");
    }

}
