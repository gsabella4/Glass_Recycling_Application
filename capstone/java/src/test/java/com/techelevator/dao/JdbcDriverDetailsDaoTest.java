package com.techelevator.dao;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class JdbcDriverDetailsDaoTest extends BaseDaoTests {

    JdbcDriverDetailsDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcDriverDetailsDao(jdbcTemplate);
    }



}