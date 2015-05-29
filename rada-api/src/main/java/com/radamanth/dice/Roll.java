/**
 * 
 */
package com.radamanth.dice;

/**
 *  class décrivant un lancé de dé
 *  Les valeurs sont initialisée à -1.
 *  
 * @author radamanth
 *
 */
public class Roll {
	private int minus = -1;
	private int plus= -1;
	private int reroll= -1;
	private int best= -1;
	private int plustotal= -1;
	private int nbDice= -1;
	private int typeDice = -1;
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
	 * Constructeur vide
	 */
	public Roll() {
		super();
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
	/**
	 * @param minus the minus to set
	 */
	public void setMinus(int minus) {
		this.minus = minus;
	}
	/**
	 * @param plus the plus to set
	 */
	public void setPlus(int plus) {
		this.plus = plus;
	}
	/**
	 * @param reroll the reroll to set
	 */
	public void setReroll(int reroll) {
		this.reroll = reroll;
	}
	/**
	 * @param best the best to set
	 */
	public void setBest(int best) {
		this.best = best;
	}
	/**
	 * @param plustotal the plustotal to set
	 */
	public void setPlustotal(int plustotal) {
		this.plustotal = plustotal;
	}
	/**
	 * @return the nbDice
	 */
	public int getNbDice() {
		return nbDice;
	}
	/**
	 * @param nbDice the nbDice to set
	 */
	public void setNbDice(int nbDice) {
		this.nbDice = nbDice;
	}
	/**
	 * @return the typeDice
	 */
	public int getTypeDice() {
		return typeDice;
	}
	/**
	 * @param typeDice the typeDice to set
	 */
	public void setTypeDice(int typeDice) {
		this.typeDice = typeDice;
	}
	
	/**
	 * Retourn le plus ou le moins en fonction de la présence de l'un ou l'autre.
	 * @return
	 */
	public int getBonus() {
		if (plus == -1 && minus==-1)
			return 0;
		if (plus != -1 && minus != -1)
			throw new IllegalStateException("Plus et Moins ne peuvent être définit en même temps");
		if (plus == -1 && minus != -1)
			return -minus;
		if (plus != -1 && minus == -1)
			return plus;
		return 0;
		
	}
}