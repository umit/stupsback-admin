package org.zalando.stups.stupsback.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;
import org.zalando.stups.stupsback.admin.events.RatingChangeEvent;

/**
 * 
 * @author jbellmann
 *
 */
@Controller
public class SseUpdateController {

	private final Logger log = LoggerFactory.getLogger(SseUpdateController.class);
	
	private final List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList<SseEmitter>());

	@EventListener
	public void onRatingsUpdate(RatingChangeEvent event) {
		log.info("rating-change-event: {}",event.toString());
		for (SseEmitter emitter : emitters) {
			try {
				SseEventBuilder builder = SseEmitter.event().data(event.getRating()).name(event.getType());
				emitter.send(builder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/sse/update/ratings")
	public SseEmitter emitter() {
		SseEmitter emitter = new SseEmitter();
		synchronized (emitters) {
			emitter.onCompletion(new Runnable() {
				@Override
				public void run() {
					emitters.remove(emitter);
				}
			});
			emitters.add(emitter);
		}
		return emitter;
	}
}
