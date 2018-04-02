package com.service.cxfconsumercse.controller;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestCxfconsumercse {

        CxfconsumercseDelegate cxfconsumercseDelegate = new CxfconsumercseDelegate();


    @Test
    public void testhelloworld(){

        String expactReturnValue = "hello"; // You should put the expect String type value here.

        String returnValue = cxfconsumercseDelegate.helloworld("hello");

        assertEquals(expactReturnValue, returnValue);
    }

}