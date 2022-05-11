package com.sct.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.sct.app"})
@EnableScheduling
public class SCTApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SCTApplication.class, args);
	}

}
