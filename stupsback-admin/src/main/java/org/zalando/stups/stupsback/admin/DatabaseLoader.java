package org.zalando.stups.stupsback.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RatingRepository repository;

    @Autowired
    public DatabaseLoader(final RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(final String... strings) throws Exception {
        this.repository.save(new Rating("Frodo", 1, "Baggins", "ring bearer", "appId"));
    }
}
