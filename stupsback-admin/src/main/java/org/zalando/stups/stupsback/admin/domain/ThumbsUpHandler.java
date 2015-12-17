/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.stupsback.admin.domain;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Christian Lohmann
 */
@RepositoryEventHandler(ThumbsUp.class)
public class ThumbsUpHandler {

    @HandleBeforeCreate
    public void handleCreate(ThumbsUp likes) {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            final Optional<Object> principal = Optional.ofNullable(authentication.getPrincipal());
            likes.setUser(principal.orElse(new String("testuser")).toString());
        } else {
            likes.setUser("anonymous");
        }
    }
}
