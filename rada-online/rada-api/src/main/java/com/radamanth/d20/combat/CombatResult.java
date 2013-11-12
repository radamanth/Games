package com.radamanth.d20.combat;

public class CombatResult {

	private String attackcode;
	private int nbHit = 0;
	private boolean critique = false;
	private int defense = 0;
	public String getAttackcode() {
		return attackcode;
	}
	public void setAttackcode(String attackcode) {
		this.attackcode = attackcode;
	}
	public int getNbHit() {
		return nbHit;
	}
	public void setNbHit(int nbHit) {
		this.nbHit = nbHit;
	}
	public boolean isCritique() {
		return critique;
	}
	public void setCritique(boolean critique) {
		this.critique = critique;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	
}
