/**
 * 
 */
package com.radamanth.cryptotron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.radamanth.cryptotron.Cryptotron.CryptModeEnum;

/**
 * @author radamanth
 *
 */
public abstract class CryptotronUtils {

	public static final Pattern PATTERN_WHITESPACE = Pattern.compile("\\s");
	
	/**
	 * Construit un dicitonnaire de charactère en fonction du contenu. 
	 * 
	 * @param wordAndWhiteSpaces
	 * @return
	 */
	public static Set<Character> generateDictionaryFromSourceWords(List<String> wordAndWhiteSpaces) {
		if (wordAndWhiteSpaces == null)
			return null;
		List<String> words = new ArrayList<String>();
		for (String s:wordAndWhiteSpaces) {
			if (!isWhiteSpaceOnly(s))
				words.add(s);
		}
		Set<Character> res = new HashSet<Character>(words.size());
		for (String w:words) {
			char[] cs = w.toCharArray();
			for (char c:cs) {
				res.add(c);
			}
		}
		
		return res;
	}

	/**
	 * La chaine de caractère est est uniquement composé de caractère blanc  ?
	 * @param s
	 * @return
	 */
	public static boolean isWhiteSpaceOnly(String s) {
		if (s == null)
			return false;
		return s.matches("^\\s*$");
	}

	/**
	 * @param src - Le texte à splitté
	 */
	public static SplitData splitIntoWordsAndSpaces(String src, CryptModeEnum mode) {
		
		SplitData split = new SplitData();
		
		List<String> listOfWordsAndWhiteSpace = new ArrayList<String>();
		Set<Integer> whiteSpaceIndexSet = new TreeSet<Integer>();
		Set<Integer> wordIndexSet = new TreeSet<Integer>();
		if (src ==null)
			return null;
		
		Matcher matcher = PATTERN_WHITESPACE.matcher(src);
		int lastStart = 0;
		int lastEnd = 0;
		
		
		while (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			if (lastStart < start) {
				//WORD
				listOfWordsAndWhiteSpace.add(src.substring(lastEnd, start));
				wordIndexSet.add(listOfWordsAndWhiteSpace.size()-1);
				
			}
			// WhiteSpace
			listOfWordsAndWhiteSpace.add(src.substring(start, end ));
			whiteSpaceIndexSet.add(listOfWordsAndWhiteSpace.size()-1);
			// maj index
			lastStart = start;
			lastEnd = end ;
		}
		if (lastEnd < src.length()) {
			listOfWordsAndWhiteSpace.add(src.substring(lastEnd));
			wordIndexSet.add(listOfWordsAndWhiteSpace.size()-1);
		}
		// Génération DICO
		Set<Character> dicoChar = CryptotronUtils.generateDictionaryFromSourceWords(listOfWordsAndWhiteSpace);
		List<Character> dicoCharLst  = new ArrayList<Character>(dicoChar);
		Collections.sort(dicoCharLst);
		if (CryptModeEnum.DECRYPT.equals(mode))
			Collections.reverse(dicoCharLst);
		
		split.setListOfWordsAndWhiteSpace(listOfWordsAndWhiteSpace);
		split.setWhiteSpaceIndexSet(whiteSpaceIndexSet);
		split.setWordIndexSet(wordIndexSet);
		split.setDicoChar(dicoChar);
		split.setDicoCharList(dicoCharLst);
		return split;
	}
	
	
}
