package com.radamanth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Service;

import com.radamanth.dice.DiceRoller;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.RollTheDiceFormResultBean;
import com.radamanth.service.IRadaDiceService;

@Service
public class RadaDiceService implements IRadaDiceService {

	@Override
	public int rollTheDice(String dicePattern) throws IllegalArgumentException {
		return DiceRoller.rollDice(dicePattern);
	}

	@Override
	public RollTheDiceFormResultBean rollTheRoller(RollTheDiceFormBean request)
			throws IllegalArgumentException {
		if (request == null)
			throw new IllegalArgumentException(
					"les données d'entrée ne peuvent être nulle.");
		RollTheDiceFormResultBean results = new RollTheDiceFormResultBean();
		results.setRequest(request);
		
		Integer nbRoll = request.getNbRoll1();
		List<Integer> resDice = new ArrayList<Integer>();
		String diceStr = request.getDice1();
		
		if (StringUtils.isEmpty(diceStr)) {
			if (nbRoll == null)
				nbRoll = 1;
			resDice = new ArrayList<Integer>();
			for (int i= 0; i< nbRoll; i++) {
				
			}
			
		}
		
		
		
		if (StringUtils.isEmpty(request.getDice2())) {

		}
		if (StringUtils.isEmpty(request.getDice3())) {

		}
		if (StringUtils.isEmpty(request.getDice4())) {

		}
		if (StringUtils.isEmpty(request.getDice5())) {

		}
		return null;
	}

	@Override
	public String usage() {
		
		return DiceRoller.usage("");
	}
	
	

}
