package com.newland.cxfprovidersbex;

import com.alibaba.fastjson.JSONObject;
import com.newland.cxfprovidersbex.service.DemoService;
import com.newland.cxfprovidersbex.vo.People;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class CxfProviderSbexApplication {

	public static void main(String[] args) {
		SpringApplication.run(CxfProviderSbexApplication.class, args);
	}

	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(@RequestParam(name = "name") String name) {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://127.0.0.1:8080/services/DemoService?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			objects = client.invoke("testService1", name);
			return objects[0].toString();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public String test4(@RequestBody People people) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(DemoService.class);
		factoryBean.setAddress("http://127.0.0.1:8080/services/DemoService");
		DemoService demoService = (DemoService) factoryBean.create();
		People res = demoService.testService2(people);
		String result = JSONObject.toJSONString(res);
		return result;

	}
}
