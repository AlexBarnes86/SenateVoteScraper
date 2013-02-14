package com.toastedbits.vote.datainserter.messages;

import java.io.File;

public class BeginParsingMessage {
	private File[] folders;
	
	public BeginParsingMessage(File[] folders) {
		this.folders = folders;
	}
	
	public File[] getFolders() {
		return folders;
	}
	
	public void setFolders(File[] folders) {
		this.folders = folders;
	}
}