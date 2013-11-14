/**
 * 
 */
package com.radamanth.security;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author CER3190183
 * 
 */
public class HMACTest {
	private static final String SEC_KEY = "This is my fucking great 1st key!";
	private static final String HMAC_SHA1 = "HmacSHA1";
	private static final String GENERATED_KEY = "7e10c2946bf68566ec20205842c7a383e55b664c";

	@Test
	public void testCompareMail() {
		 StringBuffer text = new StringBuffer();
		 text.append("==START==\n");
		
		 text.append("Roll : " + "waya dans le couloir" + "\n");
		 text.append("NB : " + "4");
		 text.append(" : ");
		 text.append("1d20+12");
		 text.append("\n");
		 Integer[] vals = {31, 30, 15, 21};
		 for (Integer i : vals )
		 text.append(i + " / ");
		 text.append("\n\n\n");
		
		 text.append("==END==\n");
		String textCopie = "==START==\n"+
				"Roll : waya dans le couloir\n"+
				"NB : 4 : 1d20+12\n"+
				"31 / 30 / 15 / 21 / \n"+
				"\n"+
				"\n"+
				"==END==\n";
		String textcree=text.toString();
		Assert.assertEquals(textcree, textCopie);
		
		String res = HMAC.hmacDigest(textCopie, SEC_KEY, HMAC_SHA1);
		Assert.assertTrue(res.compareTo(GENERATED_KEY) == 0);
	}

}
