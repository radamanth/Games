package com.radamanth.service.impl;

import java.util.ArrayList;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.radamanth.dice.DiceRoller;
import com.radamanth.model.OneRoll;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.utils.StringUtils;

/**
 * Classe de service de lancement de dés
 */
@Service
public class RadaDiceService implements IRadaDiceService {
	
	
	@Autowired
	MailSender mailSender;
	
	@Autowired
    private SimpleMailMessage preConfiguredMessage;
	
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
            ArrayList<Integer> res = new ArrayList<Integer>();
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
        
        if (results.getAuthor() != null && StringUtils.isEmail(results.getAuthor()) )  {
        	SimpleMailMessage message = new SimpleMailMessage(preConfiguredMessage);
        	StringBuffer text = new StringBuffer();
        	for (OneRoll one : results.getRequestedRoll() ) {
        		text.append(one.getComment() );
        		text.append(" : " );
        		text.append(one.getNbRoll());
        		text.append(" : " );
        		text.append(one.getDice());
        		text.append("\n");
        		for (Integer i : one.getResults())
        			text.append(i + " / ");
        		text.append("\n\n\n");
        		
        	}
        	message.setText(text.toString());
        	message.setTo(results.getAuthor());
        	mailSender.send(message);
        	
        }
		return results;
	}



	@Override
    @Produces("text/plain; charset=UTF-8")
    public String usage() {
		
		return DiceRoller.usage("");
	}
	
	

}
