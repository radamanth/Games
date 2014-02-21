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

	/**
	 * Inner class décrivant un lancé de dé
	 * @author radamanth
	 *
	 */
	public class Roll {
		private int minus;
		private int plus;
		private int reroll;
		private int best;
		private int plustotal;
		/**
		 * @param minus
		 * @param plus
		 * @param reroll
		 * @param best
		 * @param plustotal
		 */
		public Roll(int minus, int plus, int reroll, int best, int plustotal) {
			super();
			this.minus = minus;
			this.plus = plus;
			this.reroll = reroll;
			this.best = best;
			this.plustotal = plustotal;
		}
		/**
		 * @return the minus
		 */
		public int getMinus() {
			return minus;
		}
		/**
		 * @return the plus
		 */
		public int getPlus() {
			return plus;
		}
		/**
		 * @return the reroll
		 */
		public int getReroll() {
			return reroll;
		}
		/**
		 * @return the best
		 */
		public int getBest() {
			return best;
		}
		/**
		 * @return the plustotal
		 */
		public int getPlustotal() {
			return plustotal;
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

			Integer[] tabint = getTabIntFromDiceStr(diceStr);
			if ((score - tabint[2]) >= (critThreshold))
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
	private static Integer[] getTabIntFromDiceStr(String diceStr) {
		diceStr = diceStr.toLowerCase();

		
		Pattern p = Pattern.compile("[d\\-\\+rb]");
		Matcher m = p.matcher(diceStr);
		
		Integer tabint[] = new Integer[5];
		int indexM = diceStr.indexOf(MINUS);
		int indexP = diceStr.indexOf(PLUS);
		int indexR = diceStr.indexOf(REROLL);
		int indexB = diceStr.indexOf(BEST);

		int lastStart = 0;
		int lastEnd=0;
		String operateur = null;
		while (m.matches()) {
			int start = m.start();
			int end = m.end();
			operateur = m.group();
			String value = "";
			if (lastStart == 0 && lastEnd == 0 ){
				 
			} else {
				
			}
		}
		
		
		String splitStr[] = diceStr.split("[d\\-\\+rb]");
		// NbDice
		tabint[0] = Integer.parseInt(splitStr[0]);
		// diceType
		tabint[1] = Integer.parseInt(splitStr[1]);
		int absent = 0;
		// BONUS
		if (indexM != -1 || indexP != -1) {
			tabint[2] = Integer.parseInt(splitStr[2]);
			if (indexM != -1)
				tabint[2] = -1 * tabint[2];
		} else {
			tabint[2] = 0;
			absent++;
		}
		// REROLL
		if (indexR != -1) {
			tabint[3] = Integer.parseInt(splitStr[3 - absent]);
		} else {
			tabint[3] = 0;
			absent++;
		}

		if (indexB != -1) {
			tabint[4] = Integer.parseInt(splitStr[4 - absent]);
		} else {
			// Dans la cas du BEST ALL
			tabint[4] = tabint[0];
		}

		return tabint;
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

				Integer[] tabint = getTabIntFromDiceStr(diceStr);
				try {
					int nbDice = tabint[0];
					int diceType = tabint[1];
					int bonus = tabint[2];
					int rerollValue = tabint[3];
					int bestof = tabint[4];

					int resultat = 0;
					LinkedList<Integer> tempdiceResult = new LinkedList<Integer>();
					// (int)(Math.random() * (higher-lower)) + lower
					// valeurs comprises en lower(inclus) et higher(exclus)
					for (int i = 0; i < nbDice; i++) {
						int tmpIntValue = (int) (Math.random() * ((diceType + 1) - (1 + rerollValue)))
								+ (1 + rerollValue);
						// System.out.println(tmpIntValue);
						tempdiceResult.add(tmpIntValue);
					}

					Collections.sort(tempdiceResult);
					Collections.reverse(tempdiceResult);
					// for (Integer ii : tempdiceResult) {
					// System.out.println(ii);
					// }
					Collection<Integer> subset = tempdiceResult.subList(0,
							(int) bestof);
					for (Integer best : subset) {
						// System.out.println("++" + best);
						resultat += best;
					}
					// System.out.println("++"+bonus);
					resultat += (int) bonus;
					// System.out.println(resultat);
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
