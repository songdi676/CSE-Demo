package com.newland.servicecustomer.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newland.demo.api.People;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-03-27T03:36:11.087Z")

@RestSchema(schemaId = "servicecustomer")
@RequestMapping(path = "/ServiceCustomer", produces = MediaType.APPLICATION_JSON)
public class ServicecustomerImpl {

	@Autowired
	private ServicecustomerDelegate userServicecustomerDelegate;

	@RequestMapping(value = "/helloworld", produces = { "application/json" }, method = RequestMethod.GET)
	public String helloworld(@RequestParam(value = "name", required = true) String name) {

		return userServicecustomerDelegate.helloworld(name);
	}

	@RequestMapping(value = "/getPeopleNum", produces = { "application/json" }, method = RequestMethod.POST)
	public int getPeopleNum(@RequestBody People people) {

		return userServicecustomerDelegate.getPeopleNum(people);
	}

}
