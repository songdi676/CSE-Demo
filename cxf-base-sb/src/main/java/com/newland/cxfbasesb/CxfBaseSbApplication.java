package com.newland.cxfbasesb;

import com.newland.cxfbasesb.dao.PeopleRepository;
import com.newland.cxfbasesb.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class CxfBaseSbApplication {
	@Autowired
	private PeopleRepository repository;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public List<People> test1(@RequestParam(name = "name") String name){
		return repository.findPeopleByName(name);
	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public People test2(@RequestBody People people){
		return repository.findPeopleById(people.getId());
	}

	public static void main(String[] args) {
		SpringApplication.run(CxfBaseSbApplication.class, args);
	}

}
