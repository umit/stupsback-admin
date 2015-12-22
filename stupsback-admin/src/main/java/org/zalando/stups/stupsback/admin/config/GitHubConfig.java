package org.zalando.stups.stupsback.admin.config;

import java.io.IOException;
import java.util.Properties;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.extras.OkHttpConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

/**
 * @author Christian Lohmann
 */
@Configuration
public class GitHubConfig {

    @Value("${github.oauth}")
    private String oauth;

    @Value("${github.login}")
    private String login;

    @Bean
    GitHub gitHub() throws IOException {
        final Properties properties = new Properties();
        properties.put("oauth", oauth);
        properties.put("login", login);
        final GitHubBuilder builder = GitHubBuilder.fromProperties(properties);
        return builder.withConnector(new OkHttpConnector(new OkUrlFactory(new OkHttpClient()))).build();
    }
}
