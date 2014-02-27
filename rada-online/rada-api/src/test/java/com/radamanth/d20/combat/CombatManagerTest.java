package com.radamanth.d20.combat;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;



/**
 * 
 * @author radamanth
 *
 */
public class CombatManagerTest {

	@Test
	public void testOneAttack() throws Exception {
		CombatResult result = CombatManager.oneAttack("1d20+10r14", 25, 20);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isHit());
		
		
		
	}

	@Test
	public void testMultipleAttackHit() throws Exception {
		List<CombatResult> result = CombatManager.multipleAttackHit("1d20+10r14/1d20+10r14/1d20+10r14", 25, 20);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		for (CombatResult r: result) {
			Assert.assertNotNull(r);
			Assert.assertTrue(r.isHit());
		}
	}

}
