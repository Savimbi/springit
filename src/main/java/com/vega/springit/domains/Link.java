package com.vega.springit.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable{




	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String url;
	
	public Link(String title, String url) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.url=url;
	}
	@OneToMany(mappedBy="link")
	private List<Comment> comments= new ArrayList<>();


	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		comments.add(comment);
	}
	
}
