package com.yindeyue.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ApplicationClientOne {
	@Autowired
	private Registration registration;
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClientOne.class, args);
	}

	@RequestMapping("shiyan")
	public String shiyan() {
		StringBuilder builder = new StringBuilder();
		builder.append(registration.getServiceId());
		builder.append("\r\n");
		List<String> services = discoveryClient.getServices();
		builder.append(services.toString());
		return builder.toString();
	}
	@RequestMapping("shiyan1")
	public String shiyan1() {
		List<ServiceInstance> instances = discoveryClient.getInstances("server-client-1");
		ServiceInstance serviceInstance = instances.get(0);
		StringBuilder builder=new StringBuilder();
		builder.append(serviceInstance.getHost());
		builder.append("----");
		builder.append(serviceInstance.getPort());
		builder.append("----");
		builder.append(serviceInstance.getServiceId());
		builder.append("----");
		builder.append(serviceInstance.getUri());
		builder.append("----");
		builder.append(serviceInstance.getMetadata());
		return builder.toString();
	}
	@RequestMapping("hi")
	public String hi(String name) {
		return "return: "+name;
	}
}
