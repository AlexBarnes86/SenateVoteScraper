package com.toastedbits.vote.datainserter;

import java.util.Observable;
import java.util.Observer;

import com.toastedbits.vote.datainserter.messages.BeginParsingMessage;
import com.toastedbits.vote.datainserter.messages.EndParseFolderMessage;
import com.toastedbits.vote.datainserter.messages.ParseFileMessage;
import com.toastedbits.vote.datainserter.messages.ParseFolderMessage;

//TODO: refactor
public class LogObserver implements Observer {
	private int fileCt;
	private int totalFolders;
	private int folderCt;
	
	@Override
	public void update(Observable o, Object msg) {
		if(msg instanceof String) {
			System.out.println(msg);
		} else if (msg instanceof ParseFileMessage) {
			System.out.print(".");
			if(++fileCt % 100 == 0) {
				System.out.println();
			}
		} else if (msg instanceof ParseFolderMessage) {
			ParseFolderMessage folder = (ParseFolderMessage)msg;
			System.out.println("Parsing folder: " + folder.getName() + " [" + (++folderCt) + " of " + totalFolders + "]");
			System.out.println("Folder contains " + folder.getFileCount() + " files");
		} else if (msg instanceof EndParseFolderMessage) {
			fileCt = 0;
			System.out.println();
		} else if (msg instanceof BeginParsingMessage) {
			BeginParsingMessage begin = (BeginParsingMessage) msg;
			this.totalFolders = begin.getFolders().length;
		}
	}
}
