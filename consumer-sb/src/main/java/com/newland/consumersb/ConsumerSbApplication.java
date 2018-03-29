package com.newland.consumersb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsumerSbApplication {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/callhello", method = RequestMethod.GET)
	public String callhello() {
		String res = restTemplate.getForObject("http://127.0.0.1:8080/hello", String.class);
		return res;
	}


	@RequestMapping(value = "/callhello2", method = RequestMethod.GET)
	public String callhello2() {
		String res = restTemplate.getForObject("http://192.168.56.101:30101/hello", String.class);
		return res;
	}

	@RequestMapping(value = "/callhello3", method = RequestMethod.GET)
	public String callhello3() {
		String res = restTemplate.getForObject("http://provider-sb-demo/hello", String.class);
		return res;
	}

	public static void main(String[] args) {
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "30101");
		SpringApplication.run(ConsumerSbApplication.class, args);
	}
}
