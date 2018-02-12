package com.yindeyue.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
 
@FeignClient(name="serverclient")
public interface MyFeign {
	@GetMapping("/hi") 
	public String shiyan(String name);
}
