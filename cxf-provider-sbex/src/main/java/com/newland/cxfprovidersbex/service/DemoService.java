package com.newland.cxfprovidersbex.service;

import com.newland.cxfprovidersbex.vo.People;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://webservice.demo.com/"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {
    @WebMethod
//    @WebResult(name = "String", targetNamespace = "")
    public String sayHello(@WebParam(name = "name") String name);


    @WebMethod
//    @WebResult(name = "String", targetNamespace = "")
    public List<People> testService1(@WebParam(name = "name") String name);


    @WebMethod
//    @WebResult(name = "String", targetNamespace = "")
    public People testService2(@WebParam(name = "people") People people);
}
