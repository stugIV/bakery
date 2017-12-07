package com.my.backery.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Menu {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
}
