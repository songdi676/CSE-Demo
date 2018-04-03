package com.newland.demo.api;

import java.util.List;

public interface ICSERpcDemo {

	String helloworld(String name);

	String sayHello(String name);

	int getPeopleNumberByNameAndStatus(People people);

	List<People> getPeopleByName(String peopleName);

	int addPeople(People people);

	int[] batchAddPeople(List<People> peopleList);

	int deletePeopleByName(String peopleName);

}