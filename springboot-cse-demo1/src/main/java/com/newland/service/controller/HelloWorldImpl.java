package com.newland.service.controller;

import org.springframework.stereotype.Component;

/**
 * Created by bear on 2018/3/7.
 */
@Component
public class HelloWorldImpl implements HelloWorld {
    public String helloworld(String name){

        // Do Some Magic Here!
        return "hello "+name;
    }
}
