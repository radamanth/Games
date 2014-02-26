package com.radamanth.cryptotron;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import com.radamanth.cryptotron.Cryptotron.CryptModeEnum;

public class CryptotronUtilsTest {

	@Test
	public void testGenerateDictionaryFromSourceWords() throws Exception {
		List<String> test = Arrays.asList("abc", " ", "abc", " ", "def");

		Set<Character> result = CryptotronUtils
				.generateDictionaryFromSourceWords(test);
		Assert.assertNotNull(result);
		Assert.assertEquals(6, result.size());
		char[] toBefound = { 'a', 'b', 'c', 'd', 'e', 'f' };

		for (char c : toBefound) {
			Assert.assertTrue(c + " non trouvé dans le dictionnaire.",
					result.contains(c));
		}

	}

	@Test
	public void testIsWhiteSpaceOnly() throws Exception {
		String s = " ";
		Assert.assertTrue(CryptotronUtils.isWhiteSpaceOnly(s));
		s = " \t\t\r\n ";
		Assert.assertTrue(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "\n";
		Assert.assertTrue(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "\r";
		Assert.assertTrue(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "\t";
		Assert.assertTrue(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "Non";
		Assert.assertFalse(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "et toto";
		Assert.assertFalse(CryptotronUtils.isWhiteSpaceOnly(s));
		s = "waya";
		Assert.assertFalse(CryptotronUtils.isWhiteSpaceOnly(s));
	}

	@Test
	public void testSplitIntoWordsAndSpaces() throws Exception {
		SplitData split = CryptotronUtils.splitIntoWordsAndSpaces("ceci est un test", CryptModeEnum.CRYPT);
				
		List<String> listOfWordsAndWhiteSpace = split.getListOfWordsAndWhiteSpace();
		Set<Integer> whiteSpaceIndexSet = split.getWhiteSpaceIndexSet();
		Set<Integer> wordIndexSet = split.getWordIndexSet();

		Assert.assertNotNull(listOfWordsAndWhiteSpace);
		Assert.assertNotNull(whiteSpaceIndexSet);
		Assert.assertNotNull(wordIndexSet);
		
		Assert.assertEquals(7, listOfWordsAndWhiteSpace.size());
		// Check White Index
		Assert.assertEquals(3, whiteSpaceIndexSet.size());
		Assert.assertTrue(whiteSpaceIndexSet.contains(1));
		Assert.assertTrue(whiteSpaceIndexSet.contains(3));
		Assert.assertTrue(whiteSpaceIndexSet.contains(5));
		//check Wordindex
		Assert.assertEquals(4, wordIndexSet.size());
		Assert.assertTrue(wordIndexSet.contains(0));
		Assert.assertTrue(wordIndexSet.contains(2));
		Assert.assertTrue(wordIndexSet.contains(4));
		Assert.assertTrue(wordIndexSet.contains(6));
		
	}

}

