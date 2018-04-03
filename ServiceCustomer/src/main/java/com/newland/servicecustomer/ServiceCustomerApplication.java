package com.newland.servicecustomer;

import java.util.ArrayList;
import java.util.List;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.newland.demo.api.ICSERpcDemo;
import com.newland.demo.api.People;

@Component
public class ServiceCustomerApplication {

	@RpcReference(microserviceName = "CSERpcDemo", schemaId = "CSERpcDemo")
	private static ICSERpcDemo demoService;

	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	public static void main(String[] args) throws Exception {
		Log4jUtils.init();
		BeanUtils.init();
		testPeopleDao(demoService);
		//testSpringBootPeopleDao(restTemplate);

	}

	public static void testSpringBootPeopleDao(RestTemplate restTemplate) {
		String name = "springboot";
		People people = new People();
		people.setStatus(1);
		people.setPeopleName(name);
		people.setPeopleId(11111);

		List<People> peopleList = new ArrayList<People>();
		People people2 = new People();
		people2.setStatus(1);
		people2.setPeopleName(name);
		people2.setPeopleId(22222);
		peopleList.add(people);
		peopleList.add(people2);

		String rootPath = "cse://spring-boot-demo";
		List<?> peopleResult = restTemplate
				.getForObject(rootPath + "/SampleController/findPeopleByName?name=springboot", ArrayList.class);
		System.out.println("添加前查询，findPeopleByName :" + name + " 返回结果:" + peopleResult);

		restTemplate.postForObject(rootPath + "/SampleController/save", peopleList, String.class);
		peopleResult = restTemplate.getForObject(rootPath + "/SampleController/findPeopleByName?name=springboot",
				ArrayList.class);
		System.out.println("添加人员后，查询, findPeopleByName :" + name + " 返回结果:" + peopleResult);

		restTemplate.getForObject(rootPath + "/SampleController/deletePeopleByName?name=springboot", String.class);
		peopleResult = restTemplate.getForObject(rootPath + "/SampleController/findPeopleByName?name=springboot",
				ArrayList.class);
		System.out.println("删除后查询人员, findPeopleByName :" + name + " 返回结果:" + peopleResult);

	}

	public static void testPeopleDao(ICSERpcDemo demoService) {
		String name = "rpcService";
		People people = new People();
		people.setStatus(1);
		people.setPeopleName(name);
		people.setPeopleId(11111);

		int result = demoService.addPeople(people);
		System.out.println("添加人员  people:" + name + " 返回结果:" + result);

		List<People> peopleList = demoService.getPeopleByName(name);
		System.out.println("添加人员后，查询, getPeopleByName:" + name + " 返回结果:" + peopleList);

		result = demoService.deletePeopleByName(name);
		System.out.println("通过人名删除人员，deletePeopleByName:" + name + "返回结果:" + result);

		peopleList = demoService.getPeopleByName(name);
		System.out.println("删除后查询人员, getPeopleByName:" + name + " 返回结果:" + peopleList);

		peopleList = new ArrayList<People>();
		People people2 = new People();
		people2.setStatus(1);
		people2.setPeopleName(name);
		people2.setPeopleId(22222);
		peopleList.add(people);
		peopleList.add(people2);

		int[] result2 = demoService.batchAddPeople(peopleList);
		System.out.println("批量添加人员 batchAddPeople:" + name + " 返回结果:" + result2);

		List<People> peopleList3 = demoService.getPeopleByName(name);
		System.out.println("批量添加后查询人员, getPeopleByName:" + name + " 返回结果:" + peopleList3);

		result = demoService.deletePeopleByName(name);
		System.out.println("通过人名删除人员，deletePeopleByName:" + name + " result:" + result);

		peopleList3 = demoService.getPeopleByName(name);
		System.out.println("删除后查询人员, getPeopleByName:" + name + " 返回结果:" + peopleList3);
	}
}
