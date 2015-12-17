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
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.zalando.stups.stupsback.admin.domain.Application;
import org.zalando.stups.stupsback.admin.domain.ApplicationRepository;
import org.zalando.stups.stupsback.admin.domain.Rating;
import org.zalando.stups.stupsback.admin.domain.RatingRepository;
import org.zalando.stups.stupsback.admin.domain.ThumbsUp;
import org.zalando.stups.stupsback.admin.domain.ThumbsUpRepository;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;

@Component
@Profile("local")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseLoader implements CommandLineRunner {

    private final RatingRepository repository;
    private final ThumbsUpRepository thumbsUpRepository;
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
        final ThumbsUp thumbsUp = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating1));
        rating1.getThumbsUps().add(thumbsUp);
        final ThumbsUp thumbsUp1 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating2));
        rating2.getThumbsUps().add(thumbsUp1);
        final ThumbsUp thumbsUp2 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating3));
        rating3.getThumbsUps().add(thumbsUp2);
        final ThumbsUp thumbsUp3 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating4));
        rating4.getThumbsUps().add(thumbsUp3);
        final ThumbsUp thumbsUp4 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating5));
        rating5.getThumbsUps().add(thumbsUp4);
        final ThumbsUp thumbsUp5 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating6));
        rating6.getThumbsUps().add(thumbsUp5);
        final ThumbsUp thumbsUp6 = this.thumbsUpRepository.save(new ThumbsUp("testuser", rating7));
        rating7.getThumbsUps().add(thumbsUp6);


        final ThumbsUp thumbsUp7 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating1));
        rating1.getThumbsUps().add(thumbsUp7);
        final ThumbsUp thumbsUp8 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating2));
        rating2.getThumbsUps().add(thumbsUp8);
        final ThumbsUp thumbsUp9 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating3));
        rating3.getThumbsUps().add(thumbsUp9);
        final ThumbsUp thumbsUp10 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating4));
        rating4.getThumbsUps().add(thumbsUp10);
        final ThumbsUp thumbsUp11 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating5));
        rating5.getThumbsUps().add(thumbsUp11);
        final ThumbsUp thumbsUp12 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating6));
        rating6.getThumbsUps().add(thumbsUp12);
        final ThumbsUp thumbsUp13 = this.thumbsUpRepository.save(new ThumbsUp("testuser2", rating7));
        rating7.getThumbsUps().add(thumbsUp13);

        final ThumbsUp thumbsUp14 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating1));
        rating1.getThumbsUps().add(thumbsUp14);
        final ThumbsUp thumbsUp15 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating2));
        rating2.getThumbsUps().add(thumbsUp15);
        final ThumbsUp thumbsUp16 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating3));
        rating3.getThumbsUps().add(thumbsUp16);
        final ThumbsUp thumbsUp17 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating4));
        rating4.getThumbsUps().add(thumbsUp17);
        final ThumbsUp thumbsUp18 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating5));
        rating5.getThumbsUps().add(thumbsUp18);
        final ThumbsUp thumbsUp19 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating6));
        rating6.getThumbsUps().add(thumbsUp19);
        final ThumbsUp thumbsUp20 = this.thumbsUpRepository.save(new ThumbsUp("testuser3", rating7));
        rating7.getThumbsUps().add(thumbsUp20);

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
