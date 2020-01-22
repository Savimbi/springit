package com.vega.springit;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.vega.springit.domains.Comment;
import com.vega.springit.domains.Link;
import com.vega.springit.repositorys.CommentRepository;
import com.vega.springit.repositorys.LinkRepository;

@SpringBootApplication

public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}
	
	@Bean
	PrettyTime prettyTime() {
		return new PrettyTime();
	}

}
