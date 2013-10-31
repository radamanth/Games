package com.radamanth.dice;

import org.junit.Test;

import junit.framework.Assert;


/**
 * @author CER3190183
 * 
 */
public class DiceRollerTest {

	private static final int NB_ITER = 50;

	/**
	 * Test method for
	 * {@link com.radamanth.dice.DiceRoller#isCritical(java.lang.String, int, int)}
	 * .
	 */
	@Test
	public void testIsCritical() {
		Assert.assertTrue(DiceRoller.isCritical("1D20", 19, 18));
		Assert.assertFalse(DiceRoller.isCritical("1D20", 19, 20));
	}

	/**
	 * Test method for
	 * {@link com.radamanth.dice.DiceRoller#rollDice(java.lang.String)}.
	 */
	@Test
	public void testRollDice() {
		int res = -1;

		String diceStr = "5d20+12R1B2";
		for (int i = 0; i < NB_ITER; i++) {
			res = DiceRoller.rollDice(diceStr);
			System.out.println("res " + diceStr + " = " + res);
			Assert.assertTrue(14 < res);
			Assert.assertTrue(res <= 52);
		}

		diceStr = "1d1+10";
		for (int i = 0; i < NB_ITER; i++) {

			res = DiceRoller.rollDice(diceStr);
			System.out.println("res " + diceStr + " = " + res);
			Assert.assertEquals(11, res);
		}

	}

}
