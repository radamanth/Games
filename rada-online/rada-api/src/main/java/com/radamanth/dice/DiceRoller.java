package com.radamanth.dice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author radamanth
 * 
 */
public abstract class DiceRoller {

	/**
	 * PAttern : ^[0-9]+[dD][0-9]+([pPMm][0-9]*)?([rR][0-9]+)?([bB][0-9]+)?$
	 */
	public static final String S_DICE_PATTERN = "^[1-9]{1}[0-9]*[dD]{1}[1-9]{1}[0-9]*([\\+-]{1}[1-9]{1}[0-9]*)?([rR]{1}[1-9]{1}[0-9]*)?([bB]{1}[1-9]{1}[0-9]*)?";
	public static final Pattern DICE_PATTERN = Pattern.compile(S_DICE_PATTERN);
	public static final String MINUS = "-";
	public static final String PLUS = "+";
	public static final String REROLL = "r";
	public static final String BEST = "b";
	public static final String DICE= "d";
	
	public enum OperateurEnum {
		
		DICE(DiceRoller.DICE),MINUS(DiceRoller.MINUS), PLUS(DiceRoller.PLUS), REROLL(DiceRoller.REROLL), BEST(DiceRoller.BEST);
		private String operateur;
		private OperateurEnum(String oper) {
			this.operateur = oper;
		}
		
		public static OperateurEnum forOperateur(String operateur)  {
			for (OperateurEnum o:OperateurEnum.values()) {
				if (o.operateur.equalsIgnoreCase(operateur))
					return o;
			}
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @param diceStr
	 *            -
	 * @param score
	 * @param critThreshold
	 * @return
	 */
	public static boolean isCritical(String diceStr, int score,
			int critThreshold) {

		if (diceStr != null && DICE_PATTERN.matcher(diceStr).matches()) {

			Roll roll = getRollFromDiceStr(diceStr);
			if ((score - roll.getBonus()) >= (critThreshold))
				return true;

		} else
			usage(diceStr);

		return false;
	}

	
	/**
	 * Split de la chaine de dé
	 * @param diceStr diceStr.split("[d\\-\\+rb]");
	 * @return
	 */
	private static Roll getRollFromDiceStr(String diceStr) {
		diceStr = diceStr.toLowerCase();

		
		Pattern p = Pattern.compile("[d\\-\\+rb]");
		Matcher m = p.matcher(diceStr);
		

		int lastEnd=0;
		String operateurStr = null;
		Roll result =  new Roll();
		OperateurEnum operateur = null;
		while (m.find()) {
			int start = m.start();
			int end = m.end();
			operateurStr = m.group();
			String value = diceStr.substring(lastEnd, start);
			int intValue = -1;
			try {
				intValue = Integer.parseInt(value);
			} catch (Exception e) {
				throw new IllegalStateException("value : " + value + " devrait être au format nuémric.");
			}
			operateur = OperateurEnum.forOperateur(operateurStr);
			switch (operateur) {
			case DICE:
				result.setNbDice(intValue);
				break;
			case BEST:
				// avant B c est soit Reroll soit soit plus soit type de dé
				
				if (result.getTypeDice() == -1 )
					result.setTypeDice(intValue);
				else if (diceStr.contains(REROLL)) {
					// si reroll présent dans la chaine alors le précédent est reroll
					result.setReroll(intValue);
				} else if (diceStr.contains(PLUS)) {
					// Sinon ca peut etre + 
					result.setPlus(intValue);
				}else if (diceStr.contains(PLUS)) {
					// Sinon ca peut etre + 
					result.setMinus(intValue);
				} else {
					// Sinon c est le dice type
					result.setTypeDice(intValue);
				}
				break;
			case MINUS:
				// Avant - c est toujours le type de dé
				result.setTypeDice(intValue);
				break;
			case PLUS:
				// Avant + c est toujours le type de dé
				result.setTypeDice(intValue);
				break;
			case REROLL:
				// Avant R de reroll c est soir + soit - soit diceType
				if (result.getTypeDice() == -1 )
					result.setTypeDice(intValue);
				else if (diceStr.contains(PLUS)) {
					// Sinon ca peut etre + 
					result.setPlus(intValue);
				}else if (diceStr.contains(PLUS)) {
					// Sinon ca peut etre + 
					result.setMinus(intValue);
				} else {
					// Sinon c est le dice type
					result.setTypeDice(intValue);
				}
				break;
			default:
				break;
			}
			
			lastEnd =end;
		}
		if (lastEnd < diceStr.length()) {
			// il rest la dernière partie
			int lastValue = Integer.parseInt(diceStr.substring(lastEnd));
					
			switch (operateur) {
			case BEST:
				result.setBest(lastValue);
				break;
			case DICE:
				result.setTypeDice(lastValue);
				break;
			case MINUS:
				result.setMinus(lastValue);
				break;
			case PLUS:
				result.setPlus(lastValue);
				break;
			case REROLL:
				result.setReroll(lastValue);
				break;
			default:
				break;
			}
		}
		
		
		

		return result;
	}

	/**
	 * 
	 * @param diceStr
	 *            - Un chaine du type 3D6+12R1
	 * @return - Le resultat du jet de dés ou renvoit une erreur
	 */
	public static int rollDice(String diceStr) throws IllegalArgumentException {
		if (diceStr != null) {

			if (DICE_PATTERN.matcher(diceStr).matches()) {

				Roll roll = getRollFromDiceStr(diceStr);
				try {
					int nbDice = roll.getNbDice();
					int diceType = roll.getTypeDice();
					int bonus = roll.getBonus();
					int rerollValue = roll.getReroll();
					if (rerollValue == -1)
						rerollValue= 0;
					int bestof = roll.getBest();

					int resultat = 0;
					LinkedList<Integer> tempdiceResult = new LinkedList<Integer>();
					// (int)(Math.random() * (higher-lower)) + lower
					// valeurs comprises en lower(inclus) et higher(exclus)
					for (int i = 0; i < nbDice; i++) {
                        // Min + (int)(Math.random() * ((Max - Min) + 1))
						int tmpIntValue = ( rerollValue +1 ) + (int) (Math.random() * ((diceType  - ( rerollValue+ 1 ))+1) );
						// System.out.println(tmpIntValue);
						tempdiceResult.add(tmpIntValue);
					}
					if (bestof == -1)
						bestof = tempdiceResult.size();
					Collections.sort(tempdiceResult);
					Collections.reverse(tempdiceResult);
					
					Collection<Integer> subset = tempdiceResult.subList(0,
							(int) bestof);
					for (Integer best : subset) {
						resultat += best;
					}
					resultat += (int) bonus;
					return resultat;

				} catch (Exception e) {
					throw new IllegalArgumentException(e);
				}

			} else {
				String res = usage(diceStr);
				throw new IllegalArgumentException(res);
			}

		}
		return 0;
	}

	public static String usage(String diceStr) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println("Format attendu (" + diceStr + ").");
		pw.println("Cela doit etre de la forme  3D6+4R2B1 ");
		pw.println("3D6 fait partie de la partie obligatoire et lance donc 3 dés à 6 faces. 1D20 lance 1D20 ");
		pw.println("+4 ou -4 cette partie ajoute un bonus/malus.");
		pw.println("R2  Reroll 2 : indique donc les valeurs en dessous de laquelle on relance le dés (valeur comprise) pour ne pas reroller ne pas mettre de valeur ou mettre R0");
		pw.println("B1 pour Best 1  ");
		pw.println("on peut mettre des minuscule au lieux des majuscules.");
		pw.println("La seule partie obligatoire est celle des 3D6. Vous pouvez omettres des partie mais pas les mettres dans le mauvais ordre.");
		pw.println("3D6B1R2 ne fonctionne pas alors que 3D6R1B2 oui. ");
		return sw.toString();
	}
	
}
