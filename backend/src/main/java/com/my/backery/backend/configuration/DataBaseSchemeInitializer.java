package com.my.backery.backend.configuration;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class DataBaseSchemeInitializer {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Flyway flyway;

    @PostConstruct
    public void init () {
        logger.debug("preparing database schema");
        flyway.migrate();
        logger.debug("preparing database schema finished");
    }
}
