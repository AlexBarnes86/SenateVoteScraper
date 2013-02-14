package com.toastedbits.vote.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.toastedbits.vote.util.SQLUtils;

public class MemberPartyMapModel extends Model {
	public static String insert(final String fkMember, final String fkParty, final DateTime dateJoined, final DateTime dateLeft, JdbcTemplate jdbcTemplate) {
		final String id = SQLUtils.newId();
		
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO MemberPartyMap (id, fkMember, fkParty, dateJoined, dateLeft) VALUES (?, ?, ?, ?, ?)");
				setOther(pstmt, 1, id);
				setOther(pstmt, 2, fkMember);
				setString(pstmt, 3, fkParty);
				setTimestamp(pstmt, 4, dateJoined);
				setTimestamp(pstmt, 5, dateLeft);
				
				return pstmt;
			}
		};
		
		jdbcTemplate.update(creator);
		return id;
	}
}
