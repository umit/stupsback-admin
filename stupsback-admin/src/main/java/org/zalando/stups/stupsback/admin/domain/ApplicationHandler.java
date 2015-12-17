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
