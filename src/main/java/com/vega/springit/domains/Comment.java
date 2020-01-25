package com.vega.springit.domains;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.ocpsoft.prettytime.PrettyTime;

import com.vega.springit.service.BeanUtil;

import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Auditable{




	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private String body;
	
	@NonNull
	@ManyToOne
	private Link link;
	

	
	public String getPrettyTime() {
	    PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
	    return pt.format(convertToDateViaInstant(getCreationDate()));
	}

	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
	    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}
	
}
