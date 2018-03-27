package com.service.cserpcdemo.controller;

import org.springframework.stereotype.Component;

import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;

/**
 * ICSERpcDemo 业务实现类
 * 
 * @author SongDi
 *
 */
@Component
public class CSERpcDemoDelegate implements ICSERpcDemo {

	public String helloworld(String name) {

		// Do Some Magic Here!
		return "RPC Demo" + name;
	}

	@Override
	public int getPeopleNumberByNameAndStatus(People people) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPeople(People people) {
		// TODO Auto-generated method stub
		return 0;
	}
}
