package com.toastedbits.vote.tables;

import org.springframework.jdbc.core.JdbcTemplate;

import com.toastedbits.vote.util.SQLUtils;

public class RollCallVoteTable implements Table {
	public static final String TABLE_NAME = "RollCallVote";
	
	public void create(JdbcTemplate jdbcTemplate) {
		String sql = "CREATE TABLE " + TABLE_NAME + "(id uuid PRIMARY KEY, congress int, session int, congressYear int, voteNumber int, voteDate timestamp, voteQuestionText text, voteDocumentText text, " +
						"voteResultText text, question text, voteTitle text, majorityRequirementNumerator int, majorityRequirementDenominator int, voteResult text, yea int, nay int, " +
						"present int, absent int, tieVote text)";
		
		jdbcTemplate.execute(sql);
	}
	
	public void drop(JdbcTemplate jdbcTemplate) {
		SQLUtils.dropTable(TABLE_NAME, jdbcTemplate);
	}
}
