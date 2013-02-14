package com.toastedbits.vote.models;

import org.springframework.jdbc.core.JdbcTemplate;

public class PartyModel {
	public static void insert(String symbol, JdbcTemplate jdbcTemplate) {
		String sql = "INSERT INTO Party (symbol) VALUES (?)";
		jdbcTemplate.update(sql, symbol.trim());
	}
}
