package org.zalando.stups.stupsback.admin.domain;

import javax.persistence.PersistenceException;
import java.io.IOException;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

/**
 * @author Christian Lohmann
 */
@RepositoryEventHandler(Issue.class)
public class IssueHandler {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private GitHub gitHub;

    @HandleAfterCreate
    public void handleAfterCreate(final Issue issue) {
        final Rating rating = issue.getRatings().get(0);
        if (rating == null) {
            throw new PersistenceException("No rating entity found for creating an issue for!");
        }
        //TODO: make sure that all linked ratings belong to the same application
        final Application application = applicationRepository.findByName(rating.getAppId());
        try {
            final GHRepository repository = gitHub.getRepository(application.getRepo());
            final GHIssueBuilder builder = repository.createIssue(issue.getTitle());
            builder.body(issue.getDescription());
            final GHIssue ghIssue = builder.create();
            issue.setGhIssueNumber(ghIssue.getNumber());

        } catch (IOException e) {
            throw new PersistenceException("Couldn't create a github issue!", e);
        }

    }
}
