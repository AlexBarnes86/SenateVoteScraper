package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

public interface Table {
	public void create(JdbcTemplate jdbcTemplate);
	public abstract void drop(JdbcTemplate jdbcTemplate);
}
