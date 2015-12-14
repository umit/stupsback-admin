package org.zalando.stups.stupsback.admin.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.zalando.stups.stupsback.admin.nodedomain.RatingNode;

/**
 * 
 * @author jbellmann
 *
 */
@Profile("neo4j")
@Configuration
@EnableNeo4jRepositories(basePackageClasses = RatingNode.class)
public class MyNeo4jConfig extends Neo4jConfiguration {

	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer("http://localhost:7474");
	}

	@Override
	public SessionFactory getSessionFactory() {
		// with domain entity base package(s)
        return new SessionFactory("org.zalando.stups.stupsback.admin.nodedomain");
	}

}
