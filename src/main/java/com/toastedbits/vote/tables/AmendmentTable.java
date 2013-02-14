package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class AmendmentTable implements Table {
	public static final String TABLE_NAME = "Amendment";
	
	@Override
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + "(id uuid PRIMARY KEY, amendmentNumber text, amendmentToAmendmentNumber text, amendmentToDocumentNumber text, amendmentToDocumentShortTitle text, amendmentPurpose text, fkRollCallVote uuid REFERENCES RollCallVote(id))";
		jdbcTemplate.execute(sql);
	}
	
	@Override
	public void drop(JdbcTemplate jdbcTemplate) {
		SQLUtils.dropTable(TABLE_NAME, jdbcTemplate);
	}
}
