package com.newland.cxfconsumersb.service;

import com.newland.cxfconsumersb.vo.People;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://webservice.demo.com/"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {
    @WebMethod
    String sayHello(@WebParam(name = "name") String name);


    @WebMethod
    List<People> listPeopleByName(@WebParam(name = "name") String name);


    @WebMethod
    People getPeople(@WebParam(name = "people") People people);
}
