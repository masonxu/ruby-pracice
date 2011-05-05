/** 
 * Use <code>InformationRetrieval</code> to retrieve file.  
 */

package com.augmentum.trainning.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * @author mason.xu
 * @since 03/08/2011
 * @version 1.0
 */
public class InformationRetrieval {
	private final static String DIRECTORY = "C:/Java Training/data/data/result";
	
	
	public static void main(String[] args) {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String input;

		
		//Generate the Matrix of the DataSource.
		GenerationOfMatrix gom = new GenerationOfMatrix(InformationRetrieval.DIRECTORY);
		
		if(gom.getWdMatrix_() != null) {
			//Get the Matrix of word and WordDocsMap.
			Map<String,WordDocsMap> matrix = gom.getWdMatrix_();
			 
			System.out.println("Please type the word you want to search!");
			try {
				while((input = stdin.readLine()) != null) {
					if(input.equals("exit")) {
						break;
					}else {
						//print the search result.
						printResult(input, matrix);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block.
				e.printStackTrace();
			} 
		} 
	} 
	
	
	/**
	 * Print the search result.
	 * @param String  The searched word.
	 * @param Map<String,WordDocsMap>   The matrix generated.
	 */
	public static void printResult(String input,Map<String,WordDocsMap> matrix) {
		WordDocsMap wordDocsMap;
		List<String> docList;
		
		if(matrix.containsKey(input)) {
			System.out.println("The informations have searched!");
			wordDocsMap = matrix.get(input);
			System.out.println("The Documents about the " + input +
								"are bellow: ");
			docList = wordDocsMap.getDocList();
			
			for(String doc : docList) {
				System.out.print(doc + "---");
				System.out.println("There are " + 
						wordDocsMap.getWordNumInDoc().get(doc) +
						" position found out in this file");
				System.out.println("---------------------------------");
				System.out.println("Please type another word for search!");
				System.out.println("---------------------------------");
			
			}
		}else {
			System.out.println("---------------------------------");
			System.out.println("Sorry.Have not search any result!");
			System.out.println("Please type another word for search!");
			System.out.println("---------------------------------");
		}
	}
	
}

