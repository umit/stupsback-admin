package org.zalando.stups.stupsback.admin.domain;

import static org.zalando.stups.stupsback.admin.config.WebsocketConfiguration.MESSAGE_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RepositoryEventHandler(Rating.class)
public class RatingHandler {
	

	private final SimpMessagingTemplate websocket;

	private final EntityLinks entityLinks;

	@Autowired
	public RatingHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
		this.websocket = websocket;
		this.entityLinks = entityLinks;
	}
	
	@HandleAfterCreate
	public void newRating(Rating rating) {
		this.websocket.convertAndSend(
				MESSAGE_PREFIX + "/newRating", getPath(rating));
	}

	@HandleAfterDelete
	public void deleteRating(Rating rating) {
		this.websocket.convertAndSend(
				MESSAGE_PREFIX + "/deleteRating", getPath(rating));
	}

	@HandleAfterSave
	public void updateRating(Rating rating) {
		this.websocket.convertAndSend(
				MESSAGE_PREFIX + "/updateRating", getPath(rating));
	}

	/**
	 * Take an {@link Employee} and get the URI using Spring Data REST's {@link EntityLinks}.
	 *
	 * @param rating
	 */
	private String getPath(Rating rating) {
		return this.entityLinks.linkForSingleResource(rating.getClass(),
				rating.getId()).toUri().getPath();
	}

}
