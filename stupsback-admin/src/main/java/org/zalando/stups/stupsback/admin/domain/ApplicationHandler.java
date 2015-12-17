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
package org.zalando.stups.stupsback.admin.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.util.StringUtils;

/**
 * 
 * @author jbellmann
 *
 */
@RepositoryEventHandler(Application.class)
public class ApplicationHandler {

	@HandleBeforeCreate
	public void handleCreate(Application application) {
		application.setUsername(buildUsername(application));
		application.setPassword(RandomStringUtils.randomAlphanumeric(9));
	}

	protected String buildUsername(Application application) {
		return StringUtils.trimAllWhitespace(application.getName()).toLowerCase();
	}
}
