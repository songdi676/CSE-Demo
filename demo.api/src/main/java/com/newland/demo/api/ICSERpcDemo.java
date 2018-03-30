package com.newland.demo.api;

public interface ICSERpcDemo {

	String helloworld(String name);

	String sayHello(String name);

	int getPeopleNumberByNameAndStatus(People people);

	int addPeople(People people);

}