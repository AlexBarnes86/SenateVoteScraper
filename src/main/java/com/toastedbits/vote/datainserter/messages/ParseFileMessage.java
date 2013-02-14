package com.toastedbits.vote.datainserter.messages;

public class ParseFileMessage {
	public static final ParseFileMessage MSG = new ParseFileMessage();
	
	private String name;
	
	public ParseFileMessage() {}
	
	public ParseFileMessage(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}