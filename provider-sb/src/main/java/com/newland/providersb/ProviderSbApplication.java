package com.newland.providersb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProviderSbApplication {

	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello, Jack!";
	}

	public static void main(String[] args) {

		SpringApplication.run(ProviderSbApplication.class, args);
	}
}
