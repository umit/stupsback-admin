package org.zalando.stups.stupsback.admin.controller;

import org.kohsuke.github.GHIssueBuilder;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.stups.stupsback.admin.domain.Rating;

import lombok.RequiredArgsConstructor;

/**
 * @author Christian Lohmann
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GithubController {

    private final GitHub gitHub;

    public void createIssue(final String description, final String application) {

//        GHIssueBuilder

    }
}
