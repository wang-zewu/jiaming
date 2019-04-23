package com.bee.sample.ch1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int getcount(){
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
}
