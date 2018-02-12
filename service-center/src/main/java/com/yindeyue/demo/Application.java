package com.yindeyue.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@SpringBootApplication
@RestController
public class Application {
public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
}
@RequestMapping("/hi")
public String shiyan() {
	return "hello word";
}
}
