package com.toastedbits.vote.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.joda.time.DateTime;

public abstract class Model {
	public static void setString(PreparedStatement pstmt, int index, Object value) throws SQLException {
		if(value == null) {
			pstmt.setNull(index, Types.NULL);
		}
		else {
			pstmt.setString(index, value.toString());
		}
	}
	
	public static void setInt(PreparedStatement pstmt, int index, Object value) throws SQLException {
		if(value == null || value.toString().isEmpty()) {
			pstmt.setNull(index, Types.NULL);
		}
		else {
			pstmt.setInt(index, Integer.valueOf(value.toString()));
		}
	}
	
	public static void setTimestamp(PreparedStatement pstmt, int index, DateTime value) throws SQLException {
		if(value == null || value.toString().isEmpty()) {
			pstmt.setNull(index, Types.NULL);
		}
		else {
			pstmt.setTimestamp(index, new Timestamp(value.getMillis()));
		}
	}
	
	public static void setOther(PreparedStatement pstmt, int index, Object value) throws SQLException {
		if(value == null || value.toString().isEmpty()) {
			pstmt.setNull(index, Types.NULL);
		}
		else {
			pstmt.setObject(index, value, Types.OTHER);
		}
	}
}