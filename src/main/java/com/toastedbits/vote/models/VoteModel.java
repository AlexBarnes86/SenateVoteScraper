package com.toastedbits.vote.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class VoteModel extends Model {
	public static void insert(final String fkRollCallVote, final String memberId, final String voteCast, JdbcTemplate jdbcTemplate) {
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO Vote (fkRollCallVote, memberId, voteCast) VALUES (?, ?, ?)");
				setOther(pstmt, 1, fkRollCallVote);
				setOther(pstmt, 2, memberId);
				setString(pstmt, 3, voteCast);
				
				return pstmt;
			}
		};
		
		jdbcTemplate.update(creator);
	}
}