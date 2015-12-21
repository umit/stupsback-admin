package org.zalando.stups.stupsback.admin.config;

import java.io.IOException;
import java.util.Properties;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.extras.OkHttpConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

/**
 * @author Christian Lohmann
 */
@Configuration
public class GitHubConfig {

    @Bean
    GitHub gitHub() throws IOException {


        final Properties properties = new Properties();
//        properties.put("login", "4d3944c86c498b932cb2");
//        properties.put("password", "2a3df36f22bf7f0911e519aa0198177bd930e880");
        final GitHubBuilder builder = GitHubBuilder.fromProperties(properties);
        return builder.withConnector(new OkHttpConnector(new OkUrlFactory(new OkHttpClient()))).build();
    }
}
