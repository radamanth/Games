package com.radamanth.dice;

import junit.framework.Assert;

import org.junit.Test;


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
	
	/**
	 * Test method for
	 * {@link com.radamanth.dice.DiceRoller#DICE_PATTERN}.
	 */
	@Test
	public void testPattern() {
		String s= "1d20";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "5d15";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "1d20+10";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "1d20-10";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "5d20R1B2";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "14d20R2";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "5d20B2";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "5d20R2B2";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		
		
		
		s= "01d20B2";
		Assert.assertFalse(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "azeratretzertz";
		Assert.assertFalse(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "1d20+01";
		Assert.assertFalse(DiceRoller.DICE_PATTERN.matcher(s).matches());
		s= "1d20-01";
		Assert.assertFalse(DiceRoller.DICE_PATTERN.matcher(s).matches());
		
	}

	
	@Test
	public void testBonus() {
		String s= "10D1+27";
		Assert.assertTrue(DiceRoller.DICE_PATTERN.matcher(s).matches());
		int res = DiceRoller.rollDice(s);
		Assert.assertEquals(37, res);
		
	}
}
