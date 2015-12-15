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
import org.zalando.stups.stupsback.admin.domain.Rating;
import org.zalando.stups.stupsback.admin.domain.RatingRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RatingRepository repository;

    @Autowired
    public DatabaseLoader(final RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(final String... strings) throws Exception {
        this.repository.save(new Rating("Comment_1", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_2", 2, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_3", 3, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_4", 4, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_5", 5, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_6", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
        this.repository.save(new Rating("Comment_7", 1, "test@example.org", "{\"key\":\"value\"}", "appId"));
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
    }
}
