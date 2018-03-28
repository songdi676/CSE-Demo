package com.newland.providermesh.controller;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestProvidermesh {

        ProvidermeshDelegate providermeshDelegate = new ProvidermeshDelegate();


    @Test
    public void testhelloworld(){

        String expactReturnValue = "hello"; // You should put the expect String type value here.

        String returnValue = providermeshDelegate.helloworld("hello");

        assertEquals(expactReturnValue, returnValue);
    }

}