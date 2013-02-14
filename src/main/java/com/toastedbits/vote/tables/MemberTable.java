package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class MemberTable implements Table {
	public static final String TABLE_NAME = "Member";
	
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + " (id uuid PRIMARY KEY, member_full text, last_name text, first_name text, state text, UNIQUE(last_name, first_name, state))";
		jdbcTemplate.execute(sql);
	}
	
	public void drop(JdbcTemplate jdbcTemplate) {
		SQLUtils.dropTable(TABLE_NAME, jdbcTemplate);
	}
}
