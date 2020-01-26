package com.hdu.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdu.springcloud.bean.TestBean;

@RestController
public class ConfigClientRest {

	@Autowired
	private TestBean testbean;
	
	@GetMapping("/config")
	public String getconfig() {
		String string="application:"+testbean.getApplicationName()+"\t eurekaServers:"+testbean.getEurekaServers()
				+"\t server.port"+testbean.getPort();
		System.out.println("*****"+string);
		return string;
	}
}
