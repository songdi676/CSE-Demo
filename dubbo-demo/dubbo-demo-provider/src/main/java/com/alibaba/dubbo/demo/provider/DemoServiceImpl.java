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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcContext;
import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;

public class DemoServiceImpl implements ICSERpcDemo {

	private PeopleJdbcTemplate peopleJdbcTemplate;

	public String sayHello(String name) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
				+ ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
	}

	@Override
	public String helloworld(String name) {
		sayHello(name);
		return null;
	}

	public int getPeopleNumberByNameAndStatus(People people) {
		return peopleJdbcTemplate.countOfPeopleByNameAndStatus(people);
	}

	public int addPeople(People people) {
		return peopleJdbcTemplate.save(people);
	}

	public PeopleJdbcTemplate getPeopleJdbcTemplate() {
		return peopleJdbcTemplate;
	}

	public void setPeopleJdbcTemplate(PeopleJdbcTemplate peopleJdbcTemplate) {
		this.peopleJdbcTemplate = peopleJdbcTemplate;
	}
}
