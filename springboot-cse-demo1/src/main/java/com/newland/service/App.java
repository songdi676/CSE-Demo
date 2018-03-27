package com.newland.service;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource(BeanUtils.DEFAULT_BEAN_RESOURCE)
public class App 
{
    public static void main( String[] args ) throws Exception 
    {
    	Log4jUtils.init();
    	SpringApplication.run(App.class, args);
    }
}
