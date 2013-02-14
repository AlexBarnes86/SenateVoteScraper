package com.toastedbits.vote.models;

import gov.senate.rollcallvote.RollCallVote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class RollCallVoteModel extends Model {
	public static String insert(final RollCallVote rollCall, final int session, JdbcTemplate jdbcTemplate) {
		final String id = UUID.randomUUID().toString();
		final int numerator = Integer.parseInt(rollCall.getMajorityRequirement().split("/")[0]);
		final int denominator = Integer.parseInt(rollCall.getMajorityRequirement().split("/")[1]);
		
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO RollCallVote(id, congress, session, congressYear, voteNumber, voteDate, voteQuestionText, voteDocumentText, " +
						"voteResultText, question, voteTitle, majorityRequirementNumerator, majorityRequirementDenominator, voteResult, yea, nay, " +
						"present, absent, tieVote) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				setOther(pstmt, 1, id);
				setInt(pstmt, 2, rollCall.getCongress());
				setInt(pstmt, 3, session);
				setInt(pstmt, 4, rollCall.getCongressYear());
				setInt(pstmt, 5, rollCall.getVoteNumber());
				setTimestamp(pstmt, 6, DateTime.parse(rollCall.getVoteDate(), DateTimeFormat.forPattern("MMMMMMMM dd, YYYY,  hh:mm aa")));
				setString(pstmt, 7, rollCall.getVoteQuestionText());
				setString(pstmt, 8, rollCall.getVoteDocumentText());
				setString(pstmt, 9, rollCall.getVoteResultText());
				setString(pstmt, 10, rollCall.getQuestion());
				setString(pstmt, 11, rollCall.getVoteTitle());
				setInt(pstmt, 12, numerator);
				setInt(pstmt, 13, denominator);
				setString(pstmt, 14, rollCall.getVoteResult());
				setInt(pstmt, 15, rollCall.getCount().getYeas());
				setInt(pstmt, 16, rollCall.getCount().getNays());
				setInt(pstmt, 17, rollCall.getCount().getPresent());
				setInt(pstmt, 18, rollCall.getCount().getAbsent());
				setString(pstmt, 19, rollCall.getTieBreaker().getVote());
				
				return pstmt;
			}
		};
		
		jdbcTemplate.update(creator);
		return id;
	}
}
