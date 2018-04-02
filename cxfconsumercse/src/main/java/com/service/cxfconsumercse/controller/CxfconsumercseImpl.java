package com.service.cxfconsumercse.controller;


import javax.ws.rs.core.MediaType;

import com.service.cxfconsumercse.service.DemoService;
import com.service.cxfconsumercse.vo.Person;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.client.RestTemplate;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-03-30T01:55:17.403Z")

@RestSchema(schemaId = "cxfconsumercse")
@RequestMapping(path = "/cxfconsumercse", produces = MediaType.APPLICATION_JSON)
public class CxfconsumercseImpl {

    @Autowired
    private CxfconsumercseDelegate userCxfconsumercseDelegate;


    @RequestMapping(value = "/helloworld",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public String helloworld( @RequestParam(value = "name", required = true) String name){

        return userCxfconsumercseDelegate.helloworld(name);
    }


    @RequestMapping(value = "/testcxf", method = RequestMethod.POST)
    public String testcxf(@RequestBody Person person) {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://cxf-provider-sbdemo/services/DemoService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            objects = client.invoke("sayHello", person.getName());
            return objects[0].toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/testcxf2", method = RequestMethod.POST)
    public String testcxf2(@RequestBody Person person) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(DemoService.class);
        factoryBean.setAddress("http://cxf-provider-sbdemo/services/DemoService");
        DemoService demoService = (DemoService) factoryBean.create();
        String result = demoService.sayHello(person.getName());
        return result;

    }

    private static RestTemplate restTemplate = RestTemplateBuilder.create();
    @RequestMapping(value = "/testcxf3", method = RequestMethod.POST)
    public String testcxf3(@RequestBody Person person) {
        String sayHiResult =
                restTemplate.postForObject("cse://cxf-provider-sbdemo/meshersbprovider/sayHello?name="+person.getName(), null, String.class);
        return sayHiResult;

    }


}
