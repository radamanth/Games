package com.radamanth.service;

import com.radamanth.model.CryptotronBean;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.VerifyMailBean;

/**
 * 
 * @author radamanth
 *
 */
public interface IRadaDiceService {

	/**
	 * The roller tout seul
	 * @param dicePattern
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int rollTheDice(String dicePattern) throws IllegalArgumentException;
	
	/**
	 * The Epic Dice roller
	 * @param request
	 * @return
	 * @throws IllegalArgumentException
	 */
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request) throws IllegalArgumentException;
	
	/**
	 * Vérificaiton des mails envoyés par le roller ... ca gruge ou pas ?
	 * @param mail
	 * @return
	 * @throws IllegalArgumentException
	 */
	public VerifyMailBean verifyMail(VerifyMailBean mail) throws IllegalArgumentException;
	
	/**
	 * PseudoCryptage de document pour le JDR.
	 * 
	 * @param request
	 * @return
	 * @throws IllegalArgumentException
	 */
	public CryptotronBean cryptotron(CryptotronBean request) throws IllegalArgumentException;
	
	/**
	 * Purge les eventuels fichiers générer par le crytotron
	 */
	public void purgeCypherFiles();
	
	public String usage();
}
