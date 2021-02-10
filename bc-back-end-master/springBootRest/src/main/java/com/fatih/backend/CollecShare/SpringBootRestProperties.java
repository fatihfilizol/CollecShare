package com.fatih.backend.CollecShare;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "springbootrest")
public class SpringBootRestProperties {
	private boolean displayOwner = false;
	
	public boolean isDisplayOwner() {
		return displayOwner;
	}
	
	public void setDisplayOwner(boolean displayOwner) {
		this.displayOwner = displayOwner;
	}

}
