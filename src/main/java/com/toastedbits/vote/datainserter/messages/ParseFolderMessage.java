package com.toastedbits.vote.datainserter.messages;

public class ParseFolderMessage {
	private String name;
	private Integer fileCount;
	
	public ParseFolderMessage(String name, Integer fileCount) {
		this.name = name;
		this.fileCount = fileCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getFileCount() {
		return fileCount;
	}
	
	public void setFileCount(Integer fileCount) {
		this.fileCount = fileCount;
	}
}
