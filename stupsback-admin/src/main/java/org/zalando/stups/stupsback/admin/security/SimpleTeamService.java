package org.zalando.stups.stupsback.admin.security;

import java.util.Collections;
import java.util.Set;

import org.springframework.stereotype.Component;

import de.zalando.zmon.security.TeamService;

@Component
public class SimpleTeamService implements TeamService {

	@Override
	public Set<String> getTeams(String username) {
		return Collections.singleton("STUPS");
	}

}
