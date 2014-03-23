package com.radamanth.d20.combat;

public class CombatResult {

	private String attackcode;
	private boolean hit = Boolean.FALSE;
	private boolean critique = Boolean.FALSE;
	private int defense = 0;
	public String getAttackcode() {
		return attackcode;
	}
	public void setAttackcode(String attackcode) {
		this.attackcode = attackcode;
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
	/**
	 * @return the hit
	 */
	public boolean isHit() {
		return hit;
	}
	/**
	 * @param hit the hit to set
	 */
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	
}
