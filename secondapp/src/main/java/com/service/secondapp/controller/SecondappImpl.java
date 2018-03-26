package com.service.secondapp.controller;


import com.huawei.paas.cse.tcc.annotation.TccTransaction;
import com.service.firstapp.HelloWorld;
import com.service.mesh.BmCgiCall;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-03-07T02:14:40.371Z")

@RestSchema(schemaId = "secondapp")
@RequestMapping(path = "/SecondApp", produces = MediaType.APPLICATION_JSON)
public class SecondappImpl {

    private static final Logger logger = LoggerFactory.getLogger(SecondappImpl.class);

    @RpcReference(microserviceName = "FirstApp", schemaId = "firstapp")
    private HelloWorld userFirstappDelegate;

    @RpcReference(microserviceName = "bm_cgi_mesher", schemaId = "BM_CGI_SERVICE")
    private BmCgiCall bmCgiCall;

    @RequestMapping(value = "/docallrpc", method = RequestMethod.POST)
    public String helloworld1( @RequestBody String name) {

        System.out.println("second app 1 called");
        String result = "";
        try {
            result = userFirstappDelegate.helloworld(makePerson(name));
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    @RequestMapping(value = "/docallrest", method = RequestMethod.POST)
    public String helloworld2( @RequestBody String name) {

        System.out.println("second app 2 called");
        String result = "";
        try {
            result = restTemplate.postForObject("cse://FirstApp/FirstApp/helloworld", makePerson(name), String.class);
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static HelloWorld.Person makePerson(String name) {
        HelloWorld.Person person = new HelloWorld.Person();
        person.setId("0");
        person.setName(name);
        return person;
    }

    @TccTransaction(confirmMethod = "confirm", cancelMethod = "cancel")
    @RequestMapping(value = "/testTccTransaction", method = RequestMethod.POST)
    public void testTccTransaction(@RequestBody String req) throws Exception {

        logger.info("testTccTransaction called");
        String result = "";
        try {
            result = restTemplate.postForObject("cse://FirstApp/FirstApp/dotry", null, String.class);
            logger.info("result:?", result);
        } catch (Exception e) {
            throw e;
        }
        if(req!=null && req.equals("rollback")) {
            logger.info("exception");
            throw new Exception("test exception");
        }
    }

    public void confirm(String req) {
        logger.info("==========confirm==========");
    }

    public void cancel(String req) {
        logger.info("==========cancel==========");
    }

    /*不支持*/
    @ExceptionHandler(value=Exception.class)
    public String allExceptionHandler(Exception exception) throws Exception
    {
        exception.printStackTrace();
        System.out.println("我报错了："+exception.getLocalizedMessage());
        System.out.println("我报错了："+exception.getCause());
        System.out.println("我报错了："+exception.getSuppressed());
        System.out.println("我报错了："+exception.getMessage());
        System.out.println("我报错了："+exception.getStackTrace());
        return "SecondApp服务器异常，请联系管理员！";
    }

    @RequestMapping(value = "/callCgi", method = RequestMethod.POST)
    public String callCgi(@RequestBody String input) {
        return bmCgiCall.test1("test input");
    }
}
