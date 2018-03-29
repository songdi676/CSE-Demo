package com.newland.cxfprovidersb.service;


import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "DemoService",
        targetNamespace = "http://webservice.demo.com/",
        endpointInterface = "com.newland.cxfprovidersb.service.DemoService"
)
@Component
public class DemoServiceImp implements DemoService {

    @Override
    public String sayHello(String name) {

        return "Hello ," + name;
    }
}
