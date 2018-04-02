package com.newland.cxfconsumersb;

import com.newland.cxfconsumersb.service.ConsumerService;
import com.newland.cxfconsumersb.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class CxfConsumerSbApplication {
	@Autowired
	private ConsumerService demoService;

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1(@RequestParam(name = "name") String name) {
		return  demoService.sayHello(name);

	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public List<People> test2(@RequestParam(name = "name") String name) {
		return demoService.listPeopleByName(name);

	}


	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public People test3(@RequestBody People people) {
		return demoService.getPeople(people);

	}

	public static void main(String[] args) {

		/*System.setProperty("http.proxyHost", "127.0.0.1");//10.1.3.80
		System.setProperty("http.proxyPort", "30101");*/

		SpringApplication.run(CxfConsumerSbApplication.class, args);
	}
}
