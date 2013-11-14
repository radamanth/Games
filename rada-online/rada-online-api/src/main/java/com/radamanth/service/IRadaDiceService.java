package com.radamanth.service;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.VerifyMailBean;

public interface IRadaDiceService {

	public int rollTheDice(String dicePattern) throws IllegalArgumentException;
	
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request) throws IllegalArgumentException;
	
	public VerifyMailBean verifyMail(VerifyMailBean mail) throws IllegalArgumentException;
	
	public String usage();
}
