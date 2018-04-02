package com.newland.cxfprovidersb.service;


import com.newland.cxfprovidersb.dao.PeopleRepository;
import com.newland.cxfprovidersb.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "DemoService",
        targetNamespace = "http://webservice.demo.com/",
        endpointInterface = "com.newland.cxfprovidersb.service.DemoService"
)
@Component
public class DemoServiceImp implements DemoService {
    @Autowired
    private PeopleRepository repository;

    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }

    @Override
    public List<People> listPeopleByName(String name) {
        return repository.findPeopleByName(name);
    }

    @Override
    public People getPeople(People people) {
        return repository.findPeopleById(people.getId());
    }
}
