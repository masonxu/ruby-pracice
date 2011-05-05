/**
 * Use <code>WordDocsMap</code> to Express 
 * incidence relation of one Word and some Docs.  
 */
package com.augmentum.trainning.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mason.xu
 * @since 03/08/2011
 * @version 1.0
 */
public class WordDocsMap {
	
	private final static int INITIAL_NUMBER = 1;

	//the word searched.
	private String word_ ; 
	
	//the list of  doc which exist the sepecified word. 
	private List<String> docList_ = new ArrayList<String>();	
	
	// the number of the specified word in specified doc.
	private Map<String,Integer> wordNumInDoc_ = new ConcurrentHashMap<String,Integer>();
	
	
	public WordDocsMap() {};
	
	
	/**
	 * Use to Create one map of one word and doc,
	 * When one word is traversed first time.
	 * @param String  the searched word
	 * @param String  the name of doc
	 * @return WordDocsMap
	 */
	public  WordDocsMap(String word,String docName) {
		WordDocsMap wdm = new WordDocsMap();
		wdm.word_ = word;
		wdm.docList_.add(docName);
		wdm.wordNumInDoc_.put(docName, WordDocsMap.INITIAL_NUMBER);
	}
	
	/**
	 * To add the doc name into corresponding docList,
	 * and update the number of specified word in specidied doc.
	 * @param docInfo
	 */
	public void addDocToList(String docName) {
				
		if(wordNumInDoc_.containsKey(docName)) {
			/**
			 * Have exist the doc named docName in the docList_;
			 * So only update the number of words.
			 */			
			int tempNum = wordNumInDoc_.get(docName);
			wordNumInDoc_.put(docName,++tempNum);
		} else {
			docList_.add(docName);
			wordNumInDoc_.put(docName,this.INITIAL_NUMBER);
		}
	}
	

	/** 
	 * @return docList_
	 */
	public List<String> getDocList() {
		return docList_;
	}
	
	/** 
	 * @return word_
	 */
	public String getWord() {
		return word_;
	}
	
	/** 
	 * @return wordNumInDoc_
	 */
	public Map<String,Integer> getWordNumInDoc() {
		return wordNumInDoc_;
	}

}
