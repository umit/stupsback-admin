/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.stupsback.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class IndexController {

	private final List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList());

	@RequestMapping("/")
	public String home() {
		return "index";
	}

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
