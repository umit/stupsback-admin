package org.zalando.stups.stupsback.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * 
 * @author jbellmann
 *
 */
@Controller
public class SseUpdateController {

	private final List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList());

	@RequestMapping("/trigger")
	public void trigger() {
		for (SseEmitter emitter : emitters) {
			try {
				emitter.send("TEST");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/sse")
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
