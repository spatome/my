package com.spatome.yj.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties
@ComponentScan("com.spatome")
@MapperScan("com.spatome.yj.manager.dao")
public class AppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppletApplication.class, args);
	}

}

