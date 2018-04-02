package com.newland.cxfconsumersb.service;

import com.newland.cxfconsumersb.vo.People;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

public interface ConsumerService {
    String sayHello(String name);
    List<People> listPeopleByName(String name);
    People getPeople(People people);
}
