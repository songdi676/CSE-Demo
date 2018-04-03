/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;

public class Provider {

	public static void main(String[] args) throws Exception {
		// Prevent to get IPV6 address,this way only work in debug mode
		// But you can pass use -Djava.net.preferIPv4Stack=true,then it work well
		// whether in debug mode or not
		System.setProperty("java.net.preferIPv4Stack", "true");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/dubbo-demo-provider.xml" });
		context.start();

		ICSERpcDemo demoService = (ICSERpcDemo) context.getBean("demoService"); // get remote service proxy

		String hello = demoService.sayHello("world"); // call remote method
		System.out.println(hello); // get result

		testPeopleDao(demoService);

		System.in.read(); // press any key to exit
	}

	private static void testPeopleDao(ICSERpcDemo demoService) {
		String name = "dubbo";
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
		System.out.println("批量添加人员： batchAddPeople:" + name + " result:" + result2);

		List<People> peopleList3 = demoService.getPeopleByName(name);
		System.out.println("批量添加人员后查询, getPeopleByName:" + name + " result:" + peopleList3);

		result = demoService.deletePeopleByName(name);
		System.out.println("删除人员：deletePeopleByName:" + name + " result:" + result);

		peopleList3 = demoService.getPeopleByName(name);
		System.out.println("删除人员后查询, getPeopleByName:" + name + " result:" + peopleList3);
	}
}
