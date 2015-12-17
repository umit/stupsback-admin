package org.zalando.stups.stupsback.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.stups.stupsback.admin.domain.ApplicationHandler;
import org.zalando.stups.stupsback.admin.domain.ThumbsUpHandler;

/**
 * @author Christian Lohmann
 */
@Configuration
public class RepositoryConfig {

    @Bean
    ThumbsUpHandler userLikeHandler() {
        return new ThumbsUpHandler();
    }

    @Bean
    ApplicationHandler applicationHandler() {
        return new ApplicationHandler();
    }
}
