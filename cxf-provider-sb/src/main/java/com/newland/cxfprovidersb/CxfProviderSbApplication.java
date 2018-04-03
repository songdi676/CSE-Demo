package com.newland.cxfprovidersb;

import com.newland.cxfprovidersb.service.DemoService;
import com.newland.cxfprovidersb.vo.People;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class CxfProviderSbApplication {
	@RequestMapping(value = "/testcxf", method = RequestMethod.POST)
	public String testcxf(@RequestParam(name = "name") String name) {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/services/DemoService?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			objects = client.invoke("sayHello", name);
			return objects[0].toString();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/testcxf2", method = RequestMethod.POST)
	public String testcxf2(@RequestParam(name = "name") String name) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(DemoService.class);
		factoryBean.setAddress("http://localhost:8080/services/DemoService");
		DemoService demoService = (DemoService) factoryBean.create();
		String result = demoService.sayHello(name);
		return result;
	}

	@RequestMapping(value = "/testcxf3", method = RequestMethod.POST)
	public List<People> testcxf3(@RequestParam(name = "name") String name) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(DemoService.class);
		factoryBean.setAddress("http://localhost:8080/services/DemoService");
		DemoService demoService = (DemoService) factoryBean.create();
		List<People> result = demoService.listPeopleByName(name);
		return result;
	}

	public static void main(String[] args) {

		SpringApplication.run(CxfProviderSbApplication.class, args);
	}
}
