package com.sample.service;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}