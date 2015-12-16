package org.zalando.stups.stupsback.admin.domain;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Christian Lohmann
 */
@RepositoryEventHandler(UserLike.class)
public class UserLikeHandler {

    @HandleBeforeCreate
    public void handleCreate(UserLike likes) {

        final Optional<Object> principal = Optional.ofNullable(SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal());
        likes.setUser(principal.orElse(new String("testuser")).toString());

    }
}
