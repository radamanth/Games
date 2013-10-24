package com.radamanth.service;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.RollTheDiceFormResultBean;

public interface IRadaDiceService {

	public int rollTheDice(String dicePattern) throws IllegalArgumentException;
	
	public RollTheDiceFormResultBean rollTheRoller(RollTheDiceFormBean request) throws IllegalArgumentException;
	
	public String usage();
}
