package com.toastedbits.vote.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.toastedbits.vote.util.SQLUtils;

public class AmendmentModel extends Model {
	private String id;
	private String amendmentNumber;
	private String amendmentToAmendmentNumber;
	private String amendmentToDocumentNumber;
	private String amendmentToDocumentShortTitle;
	private String amendmentPurpose;
	
	public String insert(final String fkRollCallVote, JdbcTemplate jdbcTemplate) {
		id = SQLUtils.newId(); 
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO Amendment (id, amendmentNumber, amendmentToAmendmentNumber, amendmentToDocumentNumber, amendmentToDocumentShortTitle, amendmentPurpose, fkRollCallVote) VALUES (?, ?, ?, ?, ?, ?, ?)");
				setOther(pstmt, 1, id);
				setString(pstmt, 2, amendmentNumber);
				setString(pstmt, 3, amendmentToAmendmentNumber);
				setString(pstmt, 4, amendmentToDocumentNumber);
				setString(pstmt, 5, amendmentToDocumentShortTitle);
				setString(pstmt, 6, amendmentPurpose);
				setOther(pstmt, 7, fkRollCallVote);
				
				return pstmt;
			}
		};
		
		jdbcTemplate.update(creator);
		return id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmendmentNumber() {
		return amendmentNumber;
	}
	public void setAmendmentNumber(String amendmentNumber) {
		this.amendmentNumber = amendmentNumber;
	}
	public String getAmendmentToAmendmentNumber() {
		return amendmentToAmendmentNumber;
	}
	public void setAmendmentToAmendmentNumber(String amendmentToAmendmentNumber) {
		this.amendmentToAmendmentNumber = amendmentToAmendmentNumber;
	}
	public String getAmendmentToDocumentNumber() {
		return amendmentToDocumentNumber;
	}
	public void setAmendmentToDocumentNumber(String amendmentToDocumentNumber) {
		this.amendmentToDocumentNumber = amendmentToDocumentNumber;
	}
	public String getAmendmentToDocumentShortTitle() {
		return amendmentToDocumentShortTitle;
	}
	public void setAmendmentToDocumentShortTitle(
			String amendmentToDocumentShortTitle) {
		this.amendmentToDocumentShortTitle = amendmentToDocumentShortTitle;
	}
	public String getAmendmentPurpose() {
		return amendmentPurpose;
	}
	public void setAmendmentPurpose(String amendmentPurpose) {
		this.amendmentPurpose = amendmentPurpose;
	}
}