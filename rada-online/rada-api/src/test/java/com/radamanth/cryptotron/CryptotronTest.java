/**
 * 
 */
package com.radamanth.cryptotron;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author CER3190183
 *
 */
public class CryptotronTest {

	@Test
	public void testSimple() {
		String src = "abc abc";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(1);
		
		
		Cryptotron c = new Cryptotron(src, Cryptotron.CryptModeEnum.CRYPT, 100, ckey);
		String ret = c.cypher();
		
		c.setSrc(ret);
		c.setMode(Cryptotron.CryptModeEnum.DECRYPT);
		c.setCentage(100);
		String cryptedDecripted = c.cypher();

		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}
	
	@Test
	public void test100Pour100() {
		String src = "Test de cryptage a la \n\r\t con juste pour voir.";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(48);
		ckey.add(27);
		
		Cryptotron c = new Cryptotron(src, Cryptotron.CryptModeEnum.CRYPT, 100, ckey);
		String ret = c.cypher();
		
		c.setSrc(ret);
		c.setMode(Cryptotron.CryptModeEnum.DECRYPT);
		c.setCentage(100);
		String cryptedDecripted = c.cypher();

		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}
	
	@Test
	public void test20POURCENT() {
		String src = "Test de cryptage a la \n\r\t con juste pour voir.";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(48);
		ckey.add(27);
		
		Cryptotron c = new Cryptotron(src, Cryptotron.CryptModeEnum.CRYPT, 20, ckey);
		String ret = c.cypher();
		
		c.setSrc(ret);
		c.setMode(Cryptotron.CryptModeEnum.DECRYPT);
		c.setCentage(20);
		String cryptedDecripted = c.cypher();

		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}
	
	@Test
	public void test50POURCENT() {
		String src = "Test de cryptage a la \n\r\t con juste pour voir.";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(48);
		ckey.add(27);
		
		Cryptotron c = new Cryptotron(src, Cryptotron.CryptModeEnum.CRYPT, 50, ckey);
		String ret = c.cypher();
		
		c.setSrc(ret);
		c.setMode(Cryptotron.CryptModeEnum.DECRYPT);
		c.setCentage(50);
		String cryptedDecripted = c.cypher();
		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}

	@Test
	public void test70POURCENT() {
		String src = "Test de cryptage a la \n\r\t con juste pour voir.";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(48);
		ckey.add(27);
		
		Cryptotron c = new Cryptotron(src, Cryptotron.CryptModeEnum.CRYPT, 70, ckey);
		String ret = c.cypher();
		
		c.setSrc(ret);
		c.setMode(Cryptotron.CryptModeEnum.DECRYPT);
		c.setCentage(70);
		String cryptedDecripted = c.cypher();

		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}
	
	

}
