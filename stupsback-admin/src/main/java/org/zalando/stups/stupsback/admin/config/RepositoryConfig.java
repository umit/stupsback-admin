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
package org.zalando.stups.stupsback.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.stups.stupsback.admin.domain.ApplicationHandler;
import org.zalando.stups.stupsback.admin.domain.IssueHandler;
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

    @Bean
    IssueHandler issueHandler() {
        return new IssueHandler();
    }

}
