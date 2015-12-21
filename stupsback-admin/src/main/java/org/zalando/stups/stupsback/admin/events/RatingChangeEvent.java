package org.zalando.stups.stupsback.admin.events;

import org.springframework.context.ApplicationEvent;
import org.zalando.stups.stupsback.admin.domain.Rating;

/**
 * 
 * @author jbellmann
 *
 */
public class RatingChangeEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	private final Rating rating;
	private final String type;

	public RatingChangeEvent(Object source, Rating rating, String type) {
		super(source);
		this.rating = rating;
		this.type = type;
	}
	
	public Rating getRating(){
		return this.rating;
	}
	
	public String getType(){
		return type;
	}

}
