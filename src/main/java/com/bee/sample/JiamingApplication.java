package com.bee.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:provider.xml"})
public class JiamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiamingApplication.class, args);
	}

}
