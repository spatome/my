package com.spatome.applet.activity.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="my")
public class MyConfig {

	private String wxAppletAppId;
	private String wxAppletAppSecret;
	private String wxAppId;
	private String wxAppSecret; 
	
}
