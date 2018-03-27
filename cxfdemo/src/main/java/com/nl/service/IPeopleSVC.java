package com.nl.service;

import com.nl.vo.Person;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IPeopleSVC {

    public String getNameById(@WebParam( name="id") int id);

    public Person insertPerson(@WebParam( name="person") Person person);

    public List<Person> listPeople(@WebParam( name="person") Person person);


}
