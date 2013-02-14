package com.toastedbits.vote.util;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;

public class SQLUtils {
	//TODO: vulnerable to sql injection
	public static void dropTable(String tableName, JdbcTemplate jdbcTemplate) {
		String sql = "DROP TABLE IF EXISTS " + tableName + " CASCADE";
		jdbcTemplate.execute(sql);
	}

	public static String newId() {
		return UUID.randomUUID().toString();
	}
}