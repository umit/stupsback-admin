package org.zalando.stups.stupsback.admin.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;
import org.zalando.stups.stupsback.admin.events.RatingChangeEvent;

@Component
@RepositoryEventHandler(Rating.class)
public class RatingHandler {
	

//	private final SimpMessagingTemplate websocket;
//
//	private final EntityLinks entityLinks;
	
	private final ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	public RatingHandler(ApplicationEventPublisher applicationEventPublisher) {
//		this.websocket = websocket;
//		this.entityLinks = entityLinks;
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	@HandleAfterCreate
	public void newRating(Rating rating) {
//		this.websocket.convertAndSend(
//				MESSAGE_PREFIX + "/newRating", getPath(rating));
		sendChangeEvent(rating, "CREATE");
	}

	@HandleAfterDelete
	public void deleteRating(Rating rating) {
//		this.websocket.convertAndSend(
//				MESSAGE_PREFIX + "/deleteRating", getPath(rating));
		sendChangeEvent(rating, "DELETE");
	}

	@HandleAfterSave
	public void updateRating(Rating rating) {
//		this.websocket.convertAndSend(
//				MESSAGE_PREFIX + "/updateRating", getPath(rating));
		sendChangeEvent(rating, "UPDATE");
	}

	/**
	 * Take an {@link Employee} and get the URI using Spring Data REST's {@link EntityLinks}.
	 *
	 * @param rating
	 */
//	private String getPath(Rating rating) {
//		return this.entityLinks.linkForSingleResource(rating.getClass(),
//				rating.getId()).toUri().getPath();
//	}
	
	protected void sendChangeEvent(Rating rating, String type){
		this.applicationEventPublisher.publishEvent(new RatingChangeEvent(this, rating, type));
	}

}
