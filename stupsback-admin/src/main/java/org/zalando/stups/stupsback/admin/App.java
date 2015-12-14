package org.zalando.stups.stupsback.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Hello world!
 */

@EnableAutoConfiguration
public class App {
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(AppController.class, args);
    }
}
