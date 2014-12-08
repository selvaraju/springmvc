package com.sample.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class MyLogger {

		
	private Logger log = Logger.getLogger("MyLogger");

	 @Before("execution(* com.sample.dao.PersonDAOImpl.empList())")
	    public void log1(JoinPoint point) {
	    	 log.info("++++++++++++++++++++++++++++++++++++++");
	        log.info(point.getSignature().getName() + " going to call.....");
	        log.info("+++++++++++++++++++++++++++++++++++++++");
	    }
	 
    @After("execution(* com.sample.dao.PersonDAOImpl.empList())")
    public void log(JoinPoint point) {
    	 log.info("==========================================");
        log.info(point.getSignature().getName() + " called...");
        log.info("==========================================");
    }
    
   
}
