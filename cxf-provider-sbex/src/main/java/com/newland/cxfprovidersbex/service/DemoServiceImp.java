package com.newland.cxfprovidersbex.service;


import com.newland.cxfprovidersbex.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;

@WebService(serviceName = "DemoService",
        targetNamespace = "http://webservice.demo.com/",
        endpointInterface = "com.newland.cxfprovidersbex.service.DemoService"
)
@Component
public class DemoServiceImp implements DemoService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }

    @Override
    public List<People> testService1(String name) {
        People[] arr = restTemplate.getForObject("http://cxf-base-sbdemo/test1?name=" + name, People[].class);
        List<People> list = Arrays.asList(arr);
        return list;
    }

    @Override
    public People testService2(People people) {
        People ple = restTemplate.postForObject("http://cxf-base-sbdemo/test2", people, People.class);
        return ple;
    }
}
