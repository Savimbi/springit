package com.vega.springit.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable{




	@Id
	@GeneratedValue
	private Long id;
	private String body;
	
	
	@ManyToOne
	private Link link;
	
	public Comment(String body, Link link) {
		// TODO Auto-generated constructor stub
		this.body=body;
		this.link=link;
	}
	
	
}
