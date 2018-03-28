package com.nl.service;

import com.nl.vo.Person;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleSVCImplTest {

    private IPeopleSVC impl;

    @Before
    public void setUp() throws Exception {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(IPeopleSVC.class);
        factoryBean.setAddress("http://10.1.3.80:8080/ws_people");
        impl = (IPeopleSVC) factoryBean.create();
    }

    @Test
    public void getNameById() {
        System.out.println(impl.getNameById(100002));
    }


    @Test
    public void insertPerson() {
        System.out.println(impl.insertPerson(new Person("test", 1, "mytest")));

    }

    @Test
    public void listPeople() {
        System.out.println(impl.listPeople(new Person("jack")).size());
    }
}