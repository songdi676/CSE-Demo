package com.newland.cxfconsumersb.service;

import com.newland.cxfconsumersb.vo.People;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String sayHello(String name) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(DemoService.class);
        factoryBean.setAddress("http://demoServer/services/DemoService");
        DemoService demoService = (DemoService) factoryBean.create();
        String result = demoService.sayHello(name);
        return result;
    }

    @Override
    public List<People> listPeopleByName(String name) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(DemoService.class);
        factoryBean.setAddress("http://demoServer/services/DemoService");
        DemoService demoService = (DemoService) factoryBean.create();
        List<People> result = demoService.listPeopleByName(name);
        return result;
    }

    @Override
    public People getPeople(People people) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(DemoService.class);
        factoryBean.setAddress("http://demoServer/services/DemoService");
        DemoService demoService = (DemoService) factoryBean.create();
        People result = demoService.getPeople(people);
        return result;
    }
}
