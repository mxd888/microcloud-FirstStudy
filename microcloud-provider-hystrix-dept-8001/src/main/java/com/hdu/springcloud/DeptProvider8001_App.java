package com.hdu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient			//表明身份eureka客户端
@EnableDiscoveryClient		//做服务发现启动类
@EnableCircuitBreaker		//对hystrix熔断机制的支持
public class DeptProvider8001_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DeptProvider8001_App.class, args);

	}

}
