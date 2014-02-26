/**
 * 
 */
package com.radamanth.cryptotron;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author radamanth
 *
 */
public class SplitData {
	
	/**
	 * List mot et charactères blanc
	 */
	private List<String> listOfWordsAndWhiteSpace = new ArrayList<String>();

	/**
	 * Index des espaces blances
	 */
	private Set<Integer> whiteSpaceIndexSet = new TreeSet<Integer>();

	/**
	 * Index des Mots 
	 */
	private Set<Integer> wordIndexSet= new TreeSet<Integer>();
	
	/**
	 * Dico CHar 
	 * 
	 */
	Set<Character> dicoChar = new TreeSet<>();
	List<Character> dicoCharList = new ArrayList<>();
	
	/**
	 * @return the listOfWordsAndWhiteSpace
	 */
	public List<String> getListOfWordsAndWhiteSpace() {
		return listOfWordsAndWhiteSpace;
	}
	/**
	 * @param listOfWordsAndWhiteSpace the listOfWordsAndWhiteSpace to set
	 */
	public void setListOfWordsAndWhiteSpace(List<String> listOfWordsAndWhiteSpace) {
		this.listOfWordsAndWhiteSpace = listOfWordsAndWhiteSpace;
	}
	/**
	 * @return the whiteSpaceIndexSet
	 */
	public Set<Integer> getWhiteSpaceIndexSet() {
		return whiteSpaceIndexSet;
	}
	/**
	 * @param whiteSpaceIndexSet the whiteSpaceIndexSet to set
	 */
	public void setWhiteSpaceIndexSet(Set<Integer> whiteSpaceIndexSet) {
		this.whiteSpaceIndexSet = whiteSpaceIndexSet;
	}
	/**
	 * @return the wordIndexSet
	 */
	public Set<Integer> getWordIndexSet() {
		return wordIndexSet;
	}
	/**
	 * @param wordIndexSet the wordIndexSet to set
	 */
	public void setWordIndexSet(Set<Integer> wordIndexSet) {
		this.wordIndexSet = wordIndexSet;
	}
	/**
	 * @return the dicoChar
	 */
	public Set<Character> getDicoChar() {
		return dicoChar;
	}
	/**
	 * @param dicoChar the dicoChar to set
	 */
	public void setDicoChar(Set<Character> dicoChar) {
		this.dicoChar = dicoChar;
	}
	/**
	 * @return the dicoCharList
	 */
	public List<Character> getDicoCharList() {
		return dicoCharList;
	}
	/**
	 * @param dicoCharList the dicoCharList to set
	 */
	public void setDicoCharList(List<Character> dicoCharList) {
		this.dicoCharList = dicoCharList;
	}

}
