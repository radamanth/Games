package com.radamanth.service.impl;

import java.util.ArrayList;

import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.radamanth.dice.DiceRoller;
import com.radamanth.model.OneRoll;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.service.IRadaDiceService;

/**
 * Classe de service de lancement de dés
 */
@Service
public class RadaDiceService implements IRadaDiceService {
    /**
     *
     * @param dicePattern
     * @return
     * @throws IllegalArgumentException
     */
	@Override
	public int rollTheDice(String dicePattern) throws IllegalArgumentException {
		return DiceRoller.rollDice(dicePattern);
	}

	@Override
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request)
			throws IllegalArgumentException {
		if (request == null)
			throw new IllegalArgumentException(
					"les données d'entrée ne peuvent être nulle.");
		RollTheDiceFormBean results = new RollTheDiceFormBean();
		results.setRequestedRoll(new ArrayList<OneRoll>());		
        for (OneRoll one:request.getRequestedRoll()) {
			OneRoll oneres = new OneRoll();
			
            String dice = one.getDice();
            Integer nb = one.getNbRoll();
            ArrayList<Integer> res = one.getResults();
            if (nb == null )
                nb = 1;
            if (DiceRoller.DICE_PATTERN.matcher(dice).matches()) {
                for (int i = 0; i < nb; i++) {
                    res.add(DiceRoller.rollDice(dice));
                }
            }
			oneres.setResults(res);
			oneres.setDice(dice);
			oneres.setNbRoll(nb);
			oneres.setComment(one.getComment());
			results.getRequestedRoll().add(oneres);
        }
		return results;
	}



	@Override
    @Produces("text/plain; charset=UTF-8")
    public String usage() {
		
		return DiceRoller.usage("");
	}
	
	

}
