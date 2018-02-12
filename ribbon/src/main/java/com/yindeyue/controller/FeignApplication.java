package com.yindeyue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignApplication {
	 @Autowired
	 private MyFeign myFeign;
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	 @GetMapping("shiyan")
	 public String shiyan(String name) {
	 return myFeign.shiyan(name);
	
	 }
	@RequestMapping("shiyan2")
	public String shiyan() {
		StringBuilder builder = new StringBuilder();
		List<String> services = discoveryClient.getServices();
		builder.append(services.toString());
		return builder.toString();
	}
}
