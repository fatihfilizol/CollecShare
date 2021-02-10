package com.fatih.backend.CollecShare;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootRstConfiguration {
	
	@Autowired
	private SpringBootRestProperties springBootRestProperties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display owners:"+springBootRestProperties.isDisplayOwner());
	}

}
