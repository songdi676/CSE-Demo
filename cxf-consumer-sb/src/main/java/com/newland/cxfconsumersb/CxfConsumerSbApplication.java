package com.newland.cxfconsumersb;

import com.newland.cxfconsumersb.service.DemoService;
import com.newland.cxfconsumersb.vo.Person;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CxfConsumerSbApplication {

	@RequestMapping(value = "/testcxf", method = RequestMethod.POST)
	public String testcxf(@RequestBody Person person) {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://cxf-provider-sbdemo/services/DemoService?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			objects = client.invoke("sayHello", person.getName());
			return objects[0].toString();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@RequestMapping(value = "/testcxf2", method = RequestMethod.POST)
	public String testcxf2(@RequestBody Person person) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(DemoService.class);
		factoryBean.setAddress("http://cxf-provider-sbdemo/services/DemoService");
		DemoService demoService = (DemoService) factoryBean.create();
		String result = demoService.sayHello(person.getName());
		return result;

	}

	public static void main(String[] args) {

		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "30101");

		SpringApplication.run(CxfConsumerSbApplication.class, args);
	}
}
