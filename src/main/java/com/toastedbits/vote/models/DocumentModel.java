package com.toastedbits.vote.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.toastedbits.vote.util.SQLUtils;

public class DocumentModel extends Model {
	private String id;
	private String documentType;
	private String documentNumber;
	private String documentName;
	private String documentTitle;
	private String documentShortTitle;
	
	public String insert(final String fkRollCallVote, JdbcTemplate jdbcTemplate) {
		id = SQLUtils.newId();
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO Document (id, documentType, documentNumber, documentName, documentTitle, documentShortTitle, fkRollCallVote) VALUES (?, ?, ?, ?, ?, ?, ?)");
				setOther(pstmt, 1, id);
				setString(pstmt, 2, documentType);
				setString(pstmt, 3, documentNumber);
				setString(pstmt, 4, documentName);
				setString(pstmt, 5, documentTitle);
				setString(pstmt, 6, documentShortTitle);
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
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	public String getDocumentShortTitle() {
		return documentShortTitle;
	}
	public void setDocumentShortTitle(String documentShortTitle) {
		this.documentShortTitle = documentShortTitle;
	}
}
