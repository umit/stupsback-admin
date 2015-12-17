package org.zalando.stups.stupsback.admin;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.opentable.db.postgres.embedded.EmbeddedPostgreSQL;

@Configuration
@AutoConfigureBefore({DataSourceAutoConfiguration.class})
@Profile("!production")
public class EmbeddedPostgresConfiguration {

	@Bean
	public DataSource postgresDataSource() {
		EmbeddedPostgreSQL pg;
		try {
			pg = EmbeddedPostgreSQL.start();
			return pg.getPostgresDatabase();
		} catch (IOException e) {
			throw new RuntimeException("Unable to start embedded Postgres", e);
		}
	}
}
