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
package org.zalando.stups.stupsback.admin;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import org.zalando.stups.stupsback.admin.domain.Rating;
import org.zalando.stups.stupsback.admin.nodedomain.RatingNode;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {Rating.class})
@EnableNeo4jRepositories(basePackageClasses = RatingNode.class)
public class StupsBackAdminApplication extends Neo4jConfiguration {
    public StupsBackAdminApplication() {
        setBasePackage("org.zalando.stups.stupsback.admin.nodedomain");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/hello.db");
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(StupsBackAdminApplication.class, args);
    }

}
