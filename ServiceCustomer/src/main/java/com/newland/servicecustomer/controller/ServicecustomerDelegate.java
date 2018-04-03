package com.newland.servicecustomer.controller;

import java.util.ArrayList;
import java.util.List;

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
	private static ICSERpcDemo cseRpcDemo;

	private static final Logger logger = LoggerFactory.getLogger(ServicecustomerDelegate.class);

	public String helloworld(String name) {

		cseRpcDemo.helloworld(name);
		return name;
	}

	public int getPeopleNum(People people) {
		logger.debug("开始调用RPC服务");
		return cseRpcDemo.getPeopleNumberByNameAndStatus(people);
	}

	public static void testPeopleDao(ICSERpcDemo demoService) {
		String name = "rpcService";
		People people = new People();
		people.setStatus(1);
		people.setPeopleName(name);
		people.setPeopleId(11111);

		int result = demoService.addPeople(people);
		System.out.println("addPeople people:" + name + " result:" + result);

		List<People> peopleList = demoService.getPeopleByName(name);
		System.out.println("after addPeople, getPeopleByName:" + name + " result:" + peopleList);

		result = demoService.deletePeopleByName(name);
		System.out.println("deletePeopleByName:" + name + " result:" + result);

		peopleList = demoService.getPeopleByName(name);
		System.out.println("after deletePeopleByName, getPeopleByName:" + name + " result:" + peopleList);

		peopleList = new ArrayList<People>();
		People people2 = new People();
		people2.setStatus(1);
		people2.setPeopleName(name);
		people2.setPeopleId(22222);
		peopleList.add(people);
		peopleList.add(people2);

		int[] result2 = demoService.batchAddPeople(peopleList);
		System.out.println("addPeople batchAddPeople:" + name + " result:" + result2);

		List<People> peopleList3 = demoService.getPeopleByName(name);
		System.out.println("after batchAddPeople, getPeopleByName:" + name + " result:" + peopleList3);

		result = demoService.deletePeopleByName(name);
		System.out.println("deletePeopleByName:" + name + " result:" + result);

		peopleList3 = demoService.getPeopleByName(name);
		System.out.println("after deletePeopleByName, getPeopleByName:" + name + " result:" + peopleList3);
	}
}
