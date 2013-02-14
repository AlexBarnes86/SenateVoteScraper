package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class MemberPartyMapTable implements Table {
	public static final String TABLE_NAME = "MemberPartyMap";
	
	@Override
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + "(id uuid PRIMARY KEY, fkMember uuid REFERENCES Member(id), fkParty char(255) REFERENCES Party(symbol), dateJoined timestamp, dateLeft timestamp)";
		jdbcTemplate.execute(sql);
	}
	
	@Override
	public void drop(JdbcTemplate jdbcTemplate) {
		SQLUtils.dropTable(TABLE_NAME, jdbcTemplate);
	}
}
