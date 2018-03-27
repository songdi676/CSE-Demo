package com.newland.servicecustomer.controller;

import org.apache.servicecomb.provider.pojo.RpcReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;

/**
 * RPC方式调用服务
 * 
 * @author SongDi
 *
 */
@Component
public class ServicecustomerDelegate {

	@RpcReference(microserviceName = "CSERpcDemo", schemaId = "CSERpcDemo")
	private static ICSERpcDemo cSERpcDemo;
	
	 private static final Logger logger = LoggerFactory.getLogger(ServicecustomerDelegate.class);

	public String helloworld(String name) {

		cSERpcDemo.helloworld(name);
		return name;
	}

	public int getPeopleNum(People people) {
		logger.debug("开始调用RPC服务");
		return cSERpcDemo.getPeopleNumberByNameAndStatus(people);
	}
}
