package com.service.firstapp.controller;


import com.huawei.paas.cse.tcc.annotation.TccTransaction;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-03-06T02:14:40.372Z")

@RestSchema(schemaId = "firstapp")
@RequestMapping(path = "/FirstApp", produces = MediaType.APPLICATION_JSON)
public class FirstappImpl {

    private static final Logger logger = LoggerFactory.getLogger(FirstappImpl.class);

    @Autowired
    private HelloWorld userFirstappDelegate;


    static private class Person{
        @ApiModelProperty(value = "hello用户")
        private String name;
        private String id;

        public String getId() { return id; }
        public String getName() {
            return name;
        }
    }

    @ApiOperation(value = "新增用户", notes = "新增用户注意事项")
    @RequestMapping(value = "/helloworld", method = RequestMethod.POST)
    public String helloworld( @RequestBody Person person){

        System.out.println("helloworld");
        return userFirstappDelegate.helloworld(person.name);
    }

    @TccTransaction(confirmMethod = "confirm", cancelMethod = "cancel")
    @RequestMapping(value = "/dotry", method = RequestMethod.POST)
    public void doTry() {
        logger.info("==========doTry==========");
    }

    public void confirm() {
        logger.info("==========confirm==========");
    }

    public void cancel() {
        logger.info("==========cancel==========");
    }

    @ExceptionHandler(value=Exception.class)
    public String allExceptionHandler(Exception exception) throws Exception
    {
        exception.printStackTrace();
        System.out.println("我报错了："+exception.getLocalizedMessage());
        System.out.println("我报错了："+exception.getCause());
        System.out.println("我报错了："+exception.getSuppressed());
        System.out.println("我报错了："+exception.getMessage());
        System.out.println("我报错了："+exception.getStackTrace());
        return "FirstApp服务器异常，请联系管理员！";
    }

    @RequestMapping(value = "/testex", method = RequestMethod.POST)
    public String test() throws Exception {
        logger.info("==========test==========");
        //throw new Exception("test exception");
        throw new InvocationException(2, "test error", "{\"error\":123}");
    }
}
