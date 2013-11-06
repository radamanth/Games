package com.radamanth.service;

import com.radamanth.model.RollTheDiceFormBean;

public interface IRadaDiceService {

	public int rollTheDice(String dicePattern) throws IllegalArgumentException;
	
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request) throws IllegalArgumentException;
	
	public String usage();
}
