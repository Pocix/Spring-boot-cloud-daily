package com.dcp.springcloud.config.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
	}

}
