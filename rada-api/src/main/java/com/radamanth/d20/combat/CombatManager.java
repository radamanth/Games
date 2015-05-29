package 	com.radamanth.d20.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.radamanth.dice.DiceRoller;

public class CombatManager {
	private static final Logger logger = Logger.getLogger(CombatManager.class.getName());

	/**
	 * Lance une attaque multiple.
	 * Appel {@link CombatManager#oneAttack(String, int, int)} 
	 * @param attackCode les attackDice de oneAttack séparé par des / 
	 * @param defense 
	 * @param critOn
	 * @return
	 * @throws Exception
	 */
	public static List<CombatResult> multipleAttackHit(String attackCode, int defense, int critOn) throws Exception {
		
		String acode[] = attackCode.split("/");
		List<CombatResult> resList = new ArrayList<CombatResult>();
		
		for (int i = 0; i < acode.length; i++) 
		{
			CombatResult res = oneAttack(acode[i], defense, critOn);
			
			if (res.isHit() ) {
				resList.add(res);
			}
		}
		return resList;
	}
	/**
	 * Lance une attaque contre une défense en fonciton d'un seuil de crit
	 * @param attackDice cf. {@link DiceRoller#S_DICE_PATTERN}
	 * @param defense
	 * @param critOn
	 * @return
	 * @throws Exception
	 */
	public static CombatResult oneAttack(String attackDice, int defense, int critOn) throws Exception {
		
		CombatResult res = new CombatResult();
		
		res.setAttackcode(attackDice);
		res.setDefense(defense);
		
		int resultat= DiceRoller.rollDice(attackDice);
		if (DiceRoller.isCritical(attackDice, resultat, critOn)) {
			res.setHit(Boolean.TRUE);
			res.setCritique(Boolean.TRUE);
		}
		else if (resultat >= defense) {
			res.setHit(Boolean.TRUE);
		}
		if (logger.isLoggable(Level.INFO) ) 
			logger.log(Level.INFO, attackDice +" = " + resultat + " vs " + defense + " critical hit : " + res.isCritique());
		
		
		return res;
	}
	
	
	
	
}
