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
	public void test() {
		String src = "Test de cryptage a la \n\r\t con juste pour voir.";
		
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(48);
		ckey.add(27);
		
		System.out.println("LA SOURCE : /" + src+"/");
		Cryptotron c = new Cryptotron(src, Cryptotron.MODE_CRYPT, 100, ckey);
		String ret = c.cypher();
		System.out.println("Crypted : " + ret);
		
		c.setSrc(ret);
		c.setMode(Cryptotron.MODE_DECRYPT);
		c.setCentage(100);
		String cryptedDecripted = c.cypher();
		System.out.println("Decrypted : /" + cryptedDecripted+"/");
		System.out.println(src.length());
		System.out.println(cryptedDecripted.length());
		Assert.assertTrue(src.compareTo(cryptedDecripted) == 0);

	}

}
