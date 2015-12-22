package org.zalando.stups.stupsback.admin.config;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueBuilder;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.extras.OkHttpConnector;
import org.springframework.web.client.RestTemplate;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by clohmann on 21.12.15.
 */
@Slf4j
public class GitHubConfigTest {


    @Before
    public void setUp() throws Exception {
//        GitHubConfig config = new GitHubConfig();
//        gitHub = config.gitHub();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGithubConnector() throws Exception {
        final Properties properties = new Properties();
        properties.put("oauth", "ceb628ba010c44238dadfc0aef6c546cbd912099");
        properties.put("login", "christianl.proxy@gmail.com");
        final GitHubBuilder builder = GitHubBuilder.fromProperties(properties);
        final GitHub gitHub = builder.withConnector(new OkHttpConnector(new OkUrlFactory(new OkHttpClient()))).build();

        final GHRepository repository = gitHub.getRepository("zalando-stups/stupsback-admin");
        final GHIssueBuilder issueBuilder = repository.createIssue("Test");
        issueBuilder.body("Ein test!");
        issueBuilder.create();
    }
}