package com.dorna.dornablog;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@SpringBootApplication
@EnableTransactionManagement
public class DornaBlogApp {

	public static void main(String[] args) {
		SpringApplication.run(DornaBlogApp.class, args);
	}
	
	@Bean
	PrettyTime prettyTime() {
		return new PrettyTime();
	}

	@Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}

}
