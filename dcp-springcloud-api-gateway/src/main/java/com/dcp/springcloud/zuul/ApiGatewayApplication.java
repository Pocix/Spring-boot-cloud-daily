package com.dcp.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}