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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;
import org.zalando.stups.stupsback.admin.domain.Application;
import org.zalando.stups.stupsback.admin.domain.ApplicationRepository;
import org.zalando.stups.stupsback.admin.domain.Likes;
import org.zalando.stups.stupsback.admin.domain.LikesRepository;
import org.zalando.stups.stupsback.admin.domain.Rating;
import org.zalando.stups.stupsback.admin.domain.RatingRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseLoader implements CommandLineRunner {

    private final RatingRepository repository;

    private final LikesRepository likesRepository;
    
    private final ApplicationRepository applicationRepository;

    @Override
    public void run(final String... strings) throws Exception {
        final Rating rating1 = this.repository.save(new Rating("Comment_1", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating2 = this.repository.save(new Rating("Comment_2", 2, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating3 = this.repository.save(new Rating("Comment_3", 3, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating4 = this.repository.save(new Rating("Comment_4", 4, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating5 = this.repository.save(new Rating("Comment_5", 5, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating6 = this.repository.save(new Rating("Comment_6", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        final Rating rating7 = this.repository.save(new Rating("Comment_7", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_8", 2, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_9", 3, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_10", 4, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_11", 5, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_12", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_13", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_14", 2, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_15", 3, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_16", 4, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_17", 5, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_18", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_19", 3, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_20", 4, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_21", 5, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_22", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_23", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_24", 2, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_25", 3, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_26", 4, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_27", 5, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_28", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));

        this.likesRepository.save(new Likes("testuser", rating1));
        this.likesRepository.save(new Likes("testuser", rating2));
        this.likesRepository.save(new Likes("testuser", rating3));
        this.likesRepository.save(new Likes("testuser", rating4));
        this.likesRepository.save(new Likes("testuser", rating5));
        this.likesRepository.save(new Likes("testuser", rating6));
        this.likesRepository.save(new Likes("testuser", rating7));

        this.likesRepository.save(new Likes("testuser2", rating1));
        this.likesRepository.save(new Likes("testuser2", rating2));
        this.likesRepository.save(new Likes("testuser2", rating3));
        this.likesRepository.save(new Likes("testuser2", rating4));
        this.likesRepository.save(new Likes("testuser2", rating5));
        this.likesRepository.save(new Likes("testuser2", rating6));
        this.likesRepository.save(new Likes("testuser2", rating7));

        this.likesRepository.save(new Likes("testuser3", rating1));
        this.likesRepository.save(new Likes("testuser3", rating2));
        this.likesRepository.save(new Likes("testuser3", rating3));
        this.likesRepository.save(new Likes("testuser3", rating4));
        this.likesRepository.save(new Likes("testuser3", rating5));
        this.likesRepository.save(new Likes("testuser3", rating6));
        this.likesRepository.save(new Likes("testuser3", rating7));

        this.applicationRepository.save(new Application("application_1", "description", "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_2","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_3","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_4","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_5","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_6","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_7","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_8","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_9","description",  "partone", "parttwo"));

        this.applicationRepository.save(new Application("application_10","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_11","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_12","description",  "partone", "parttwo"));
        this.applicationRepository.save(new Application("application_13","description",  "partone", "parttwo"));
    }
}
