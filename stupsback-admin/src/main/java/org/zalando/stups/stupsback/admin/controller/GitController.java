package org.zalando.stups.stupsback.admin.controller;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author Christian Lohmann
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GitController {

    private final GitHub gitHub;

    public void createIssue(final String description, final String application) {

//        GHIssueBuilder

    }
}
