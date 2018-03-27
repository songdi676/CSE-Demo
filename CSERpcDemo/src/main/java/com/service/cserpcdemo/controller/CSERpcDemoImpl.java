package com.service.cserpcdemo.controller;

import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.springframework.beans.factory.annotation.Autowired;

import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;
import com.service.cserpcdemo.dao.PeopleJdbcTemplate;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CsePojoDemoCodegen", date = "2018-03-27T01:30:21.767Z")

@RpcSchema(schemaId = "CSERpcDemo")
public class CSERpcDemoImpl implements ICSERpcDemo {

	@Autowired
	private CSERpcDemoDelegate CSERpcDemoDelegate;
	@Autowired
	private PeopleJdbcTemplate peopleJdbcTemplate;

	public String helloworld(String name) {

		return CSERpcDemoDelegate.helloworld(name);
	}

	public int getPeopleNumberByNameAndStatus(People people) {

		return peopleJdbcTemplate.countOfPeopleByNameAndStatus(people);
	}

	public int addPeople(People people) {

		return peopleJdbcTemplate.save(people);
	}

}
