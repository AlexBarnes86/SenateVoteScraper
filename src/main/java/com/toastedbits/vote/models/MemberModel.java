package com.toastedbits.vote.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gov.senate.rollcallvote.Member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.toastedbits.vote.util.SQLUtils;

public class MemberModel extends Model {
	public static String insert(final Member member, JdbcTemplate jdbcTemplate) {
		final String id = SQLUtils.newId();
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT into Member (id, member_full, last_name, first_name, state) VALUES (?, ?, ?, ?, ?)");
				setOther(pstmt, 1, id);
				setString(pstmt, 2, member.getFull());
				setString(pstmt, 3, member.getLastName());
				setString(pstmt, 4, member.getFirstName());
				setString(pstmt, 5, member.getState());
				
				return pstmt;
			}
		};
		
		jdbcTemplate.update(creator);
		return id;
	}
}
