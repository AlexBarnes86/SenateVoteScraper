package com.toastedbits.vote.datainserter;

import java.io.File;
import java.io.FileFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static File[] filesInDirMatchingDigits(String dir) {
		return new File(dir).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() && file.getName().matches("^\\d+$");
			}
		});
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DataInserter inserter = context.getBean("dataInserter", DataInserter.class);
		inserter.addObserver(new LogObserver());
		inserter.dropTables();
		inserter.createTables();
		inserter.parseFolders(filesInDirMatchingDigits("data"));
	}
}