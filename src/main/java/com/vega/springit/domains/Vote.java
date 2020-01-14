package com.vega.springit.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vote {

	@Id
	@GeneratedValue
	private Long id;
	//private Link link;
	private int vote;
	
	
	
	
}
