package com.newland.cxfconsumersb;

import com.newland.cxfconsumersb.service.ConsumerService;
import com.newland.cxfconsumersb.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class CxfConsumerSbApplication {
	@Autowired
	private ConsumerService consumerService;

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1(@RequestParam(name = "name") String name) {
		return  consumerService.sayHello(name);

	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public List<People> test2(@RequestParam(name = "name") String name) {
		return consumerService.listPeopleByName(name);

	}


	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public People test3(@RequestBody People people) {
		return consumerService.getPeople(people);

	}

	public static void main(String[] args) {

		/*System.setProperty("http.proxyHost", "10.1.3.80");//10.1.3.80
		System.setProperty("http.proxyPort", "30101");*/
		String http_proxy = System.getenv("http_proxy");
		if (!StringUtils.isEmpty(http_proxy)) {
			String[] splits = http_proxy.split(":");
			System.setProperty("http.proxyHost", splits[0]);//10.1.3.80
			System.setProperty("http.proxyPort", splits[1]);
		}
		SpringApplication.run(CxfConsumerSbApplication.class, args);
	}
}
