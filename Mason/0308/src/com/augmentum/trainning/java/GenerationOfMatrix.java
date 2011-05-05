/** 
 * Use <code>InformationRetrieval</code> to Generate 
 * the Matrix of the DataSource.
 */
package com.augmentum.trainning.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mason.xu
 * @since 03/08/2011
 * @version 1.0
 */
public class GenerationOfMatrix {
	private final static String SLASH = "/";
	
	private Map<String , WordDocsMap> wdMatrix_ ;
	


	/**
	 * Construtor 
	 * @param String  The dir of datasource.
	 */
	public  GenerationOfMatrix(String dir) {
		
		String fileName;                    //the name of one file
		List<String> wordList;              // the list of word of one file
		
		//list the file of the specified dir.
		String[] fileList = listFiles(dir);
		
		if(fileList != null) {
			wdMatrix_ = new ConcurrentHashMap<String, WordDocsMap>();
		
			for(String file : fileList) {
				//compose the file address.
				fileName = dir + GenerationOfMatrix.SLASH + file;
				
				//get all words of the file named fileName
				wordList = readFile(fileName);
				
				for(String word : wordList) {
					if(wdMatrix_.containsKey(word.trim())) {
						/**
						 * If the word has been insert into the Map(wdMatrix_),
						 * then get the corresponding value of the key.   
						 */	
						WordDocsMap temp = wdMatrix_.get(word.trim());
						
						/**
						 * Because the doc newly founded, and the word 
						 * has previously existed the map, it is necessary to 
						 * execute the method of {@link #addDocToList(String fileName)}.
						 */
						temp.addDocToList(file);
					} else {
						/**
						 * Because the word is found for the first time, it is 
						 * necessary to create the new key-value mapping. 
						 */	
						wdMatrix_.put(word.trim() , new WordDocsMap(word,file));
					}
				}
			}	
			
		} else {
			System.out.println("ERROR:");
			System.out.println("The path of data source is erroneous.Please type right path" +
					" following the convention:");
			System.out.println("'C:/Java Training/data/data/result'");
		}
	}
	
	/**
	 * Read String from specified file.
	 * @param String  the file wanted to read.
	 * @return List<String> the list of every word. 
	 */
	public  List<String> readFile(String fileName) {
		List<String> wordList = new ArrayList<String>();
		BufferedReader in = null;
		String[] content;
		String tempString;
		
		try {
		    in = new BufferedReader(new FileReader(new File(fileName)));
		    
			while((tempString=in.readLine())!=null) {
				content = tempString.split(" ");
				for(String i : content) 
					wordList.add(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return wordList;
	}
	/**
	 * List the file name of directory. 
	 * @return String[] 
	 */
	public  String[] listFiles(String dirName) {
		String[] fileList; 
		
		File dir = new File(dirName);
		fileList = dir.list();
		
		return fileList;
	}
	
	/**
	 * Get the field wdMatrix_.
	 * @return Map<String, WordDocsMap> 
	 */
	public Map<String, WordDocsMap> getWdMatrix_() {
		return wdMatrix_;
	}
}
