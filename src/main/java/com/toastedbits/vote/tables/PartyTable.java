package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class PartyTable implements Table {
	public static final String TABLE_NAME = "Party";
	
	@Override
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + "(symbol char(255) PRIMARY KEY)";
		jdbcTemplate.execute(sql);
	}
	
	@Override
	public void drop(JdbcTemplate jdbcTemplate) {
		SQLUtils.dropTable(TABLE_NAME, jdbcTemplate);
	}
}
