package com.service.cserpcdemo.controller;

import org.springframework.stereotype.Component;

/**
 * ICSERpcDemo 业务实现类
 * 
 * @author SongDi
 *
 */
@Component
public class CSERpcDemoDelegate {

	public String helloworld(String name) {

		return "RPC Demo" + name;
	}

}
