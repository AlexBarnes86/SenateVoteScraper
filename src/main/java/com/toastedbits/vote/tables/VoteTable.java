package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class VoteTable implements Table {
	public static final String TABLE_NAME = "Vote";
	
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + "(fkRollCallVote uuid REFERENCES RollCallVote(id), memberId uuid REFERENCES Member(id), voteCast text)";
		jdbcTemplate.execute(sql);
	}
	
	public void drop(JdbcTemplate template) {
		SQLUtils.dropTable(TABLE_NAME, template);
	}
}
