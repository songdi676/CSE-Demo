package com.service.firstapp.controller;

import org.apache.servicecomb.core.Invocation;
import org.apache.servicecomb.core.handler.impl.AbstractHandler;
import org.apache.servicecomb.swagger.invocation.AsyncResponse;
import org.apache.servicecomb.swagger.invocation.response.Headers;

import javax.ws.rs.core.Response;

/**
 * Created by bear on 2018/3/15.
 */
public class MyHandler extends AbstractHandler {
    @Override
    public void handle(Invocation invocation, AsyncResponse asyncResp) throws Exception {

        System.out.println("code before");

        try {
            invocation.next(response -> {
                System.out.println("code after1");
                Headers headers = response.getHeaders();
                //response.setResult("aaaaaaaaaaaaaaaaaa");
                headers.addHeader("abc", "sssss");
                response.setHeaders(headers);
                asyncResp.handle(response);
                System.out.println("code after2");
            });
        } catch (Exception e) {
            asyncResp.success(Response.Status.OK, "sss");
            System.out.println("catch exception");
        }

        System.out.println("invocation："+invocation);
        System.out.println("MyHandler end");
    }
}