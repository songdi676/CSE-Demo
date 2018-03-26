package com.service.firstapp.consumer;

import com.service.firstapp.controller.HelloWorld;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.stereotype.Component;

/**
 * Created by bear on 2018/3/7.
 */
@Component
public class HelloConsumer {
    @RpcReference(microserviceName = "FirstApp")
    private HelloWorld hello;

    public String doCall() {
        return hello.helloworld("beardog");
    }
}
