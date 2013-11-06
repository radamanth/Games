package com.radamanth.d20modern.combat;

import java.util.ArrayList;
import java.util.List;

import com.radamanth.dice.DiceRoller;

public class CombatManager {

	public static List<CombatResult> multipleAttackHit(String attackCode, int defense, int critOn) throws Exception {
		
		String acode[] = attackCode.split("/");
		List<CombatResult> resList = new ArrayList<CombatResult>();
		
		for (int i = 0; i < acode.length; i++) 
		{
			CombatResult res = oneAttack(acode[i], defense, critOn);
			
			if (res.getNbHit() == 1 ) {
				resList.add(res);
			}
		}
		return resList;
	}
	public static CombatResult oneAttack(String attackDice, int defense, int critOn) throws Exception {
		
		CombatResult res = new CombatResult();
		
		res.setAttackcode(attackDice);
		res.setDefense(defense);
		
		int resultat= DiceRoller.rollDice(attackDice);
		if (DiceRoller.isCritical(attackDice, resultat, critOn)) {
			res.setNbHit(res.getNbHit() +1);
			res.setCritique(true);
		}
		else if (resultat >= defense) {
			res.setNbHit(res.getNbHit() +1);
		}
		System.out.println(attackDice +" = " + resultat + " vs " + defense + " critical hit : " + res.isCritique());
		
		return res;
	}
	
	
	
	public static void main(String[]argd) {
		try {
			CombatManager.oneAttack("1d20p10", 25, 20);
			System.out.println("======");
			CombatManager.multipleAttackHit("1d20p10/1D20p5/1D20", 18, 20);
			System.out.println("======");
			CombatManager.multipleAttackHit("1d20p10", 18, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
