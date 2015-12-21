package org.zalando.stups.stupsback.admin.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GitHub;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by clohmann on 21.12.15.
 */
@Slf4j
public class GitHubConfigTest {

    private GitHub gitHub;

    @Before
    public void setUp() throws Exception {
        GitHubConfig config = new GitHubConfig();
        gitHub = config.gitHub();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGithubConnector() throws Exception {
        final GHOrganization organization = gitHub.getOrganization("zalando-stups");

    }
}