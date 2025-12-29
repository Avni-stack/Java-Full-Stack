package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class OrderservicemicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderservicemicroApplication.class, args);
	}

}
