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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;
import org.zalando.stups.stupsback.admin.domain.UserLike;
import org.zalando.stups.stupsback.admin.domain.UserLikeRepository;
import org.zalando.stups.stupsback.admin.domain.Application;
import org.zalando.stups.stupsback.admin.domain.ApplicationRepository;
import org.zalando.stups.stupsback.admin.domain.Rating;
import org.zalando.stups.stupsback.admin.domain.RatingRepository;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseLoader implements CommandLineRunner {

    private final RatingRepository repository;
    private final UserLikeRepository userLikeRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public void run(final String... strings) throws Exception {
        final Rating rating1 = this.repository.save(new Rating("Comment_1", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating2 = this.repository.save(new Rating("Comment_2", 2, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating3 = this.repository.save(new Rating("Comment_3", 3, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating4 = this.repository.save(new Rating("Comment_4", 4, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating5 = this.repository.save(new Rating("Comment_5", 5, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating6 = this.repository.save(new Rating("Comment_6", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        final Rating rating7 = this.repository.save(new Rating("Comment_7", 1, "test@example.org",
                "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_8", 2, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_9", 3, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_10", 4, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_11", 5, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_12", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_13", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_14", 2, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_15", 3, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_16", 4, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_17", 5, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_18", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_19", 3, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_20", 4, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_21", 5, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_22", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_23", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_24", 2, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_25", 3, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_26", 4, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_27", 5, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));
        this.repository.save(new Rating("Comment_28", 1, "test@example.org", "{\"key\":\"value\"}", "appId", new ArrayList<>()));

        final List<Rating> ratings = Lists.newArrayList(rating1, rating2, rating3, rating4, rating5, rating6, rating7);
        final UserLike userLike = this.userLikeRepository.save(new UserLike("testuser", rating1));
        rating1.getUserLikes().add(userLike);
        final UserLike userLike1 = this.userLikeRepository.save(new UserLike("testuser", rating2));
        rating2.getUserLikes().add(userLike1);
        final UserLike userLike2 = this.userLikeRepository.save(new UserLike("testuser", rating3));
        rating3.getUserLikes().add(userLike2);
        final UserLike userLike3 = this.userLikeRepository.save(new UserLike("testuser", rating4));
        rating4.getUserLikes().add(userLike3);
        final UserLike userLike4 = this.userLikeRepository.save(new UserLike("testuser", rating5));
        rating5.getUserLikes().add(userLike4);
        final UserLike userLike5 = this.userLikeRepository.save(new UserLike("testuser", rating6));
        rating6.getUserLikes().add(userLike5);
        final UserLike userLike6 = this.userLikeRepository.save(new UserLike("testuser", rating7));
        rating7.getUserLikes().add(userLike6);


        final UserLike userLike7 = this.userLikeRepository.save(new UserLike("testuser2", rating1));
        rating1.getUserLikes().add(userLike7);
        final UserLike userLike8 = this.userLikeRepository.save(new UserLike("testuser2", rating2));
        rating2.getUserLikes().add(userLike8);
        final UserLike userLike9 = this.userLikeRepository.save(new UserLike("testuser2", rating3));
        rating3.getUserLikes().add(userLike9);
        final UserLike userLike10 = this.userLikeRepository.save(new UserLike("testuser2", rating4));
        rating4.getUserLikes().add(userLike10);
        final UserLike userLike11 = this.userLikeRepository.save(new UserLike("testuser2", rating5));
        rating5.getUserLikes().add(userLike11);
        final UserLike userLike12 = this.userLikeRepository.save(new UserLike("testuser2", rating6));
        rating6.getUserLikes().add(userLike12);
        final UserLike userLike13 = this.userLikeRepository.save(new UserLike("testuser2", rating7));
        rating7.getUserLikes().add(userLike13);

        final UserLike userLike14 = this.userLikeRepository.save(new UserLike("testuser3", rating1));
        rating1.getUserLikes().add(userLike14);
        final UserLike userLike15 = this.userLikeRepository.save(new UserLike("testuser3", rating2));
        rating2.getUserLikes().add(userLike15);
        final UserLike userLike16 = this.userLikeRepository.save(new UserLike("testuser3", rating3));
        rating3.getUserLikes().add(userLike16);
        final UserLike userLike17 = this.userLikeRepository.save(new UserLike("testuser3", rating4));
        rating4.getUserLikes().add(userLike17);
        final UserLike userLike18 = this.userLikeRepository.save(new UserLike("testuser3", rating5));
        rating5.getUserLikes().add(userLike18);
        final UserLike userLike19 = this.userLikeRepository.save(new UserLike("testuser3", rating6));
        rating6.getUserLikes().add(userLike19);
        final UserLike userLike20 = this.userLikeRepository.save(new UserLike("testuser3", rating7));
        rating7.getUserLikes().add(userLike20);

        repository.save(ratings);

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
