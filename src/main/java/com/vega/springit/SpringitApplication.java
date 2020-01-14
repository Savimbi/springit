package com.vega.springit;

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
@EnableJpaAuditing
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args ->{
			Link link=new Link("Get started with spring boot 2", "https://dudosart.net");
			linkRepository.save(link);
			
			Comment comment= new Comment("This is a wonderful spring boot course that I enjoyes too much!",link);
			commentRepository.save(comment);
			link.addComment(comment);
			
			System.out.println("We just inserted a link and comment");
		};
	}

}
