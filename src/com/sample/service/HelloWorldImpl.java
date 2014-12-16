package com.sample.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.sample.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	 public HelloWorldImpl() {
		// TODO Auto-generated constructor stub
		 System.out.println("Service Init...");
	}
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}