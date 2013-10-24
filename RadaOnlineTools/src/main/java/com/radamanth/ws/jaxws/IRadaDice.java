package com.radamanth.ws.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.WebServiceException;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.radamanth.dice.DiceRoller;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.RollTheDiceFormResultBean;

@Path(value = "/dice")
@WebService
public interface IRadaDice {

	/**
	 * The Dice Pattern must respect {@link DiceRoller#DICE_PATTERN}
	 * 
	 * @param dicePattern
	 * @return
	 * @throws IllegalArgumentException
	 * @throws WebServiceException
	 */
	@WSDLDocumentation("Retourne le résultat d'un lancement de dés resptant un pattern "
			+ DiceRoller.DICE_PATTERN
			+ ". Exemple : Une chaine du type 3D6+12R1")
	@WebMethod
	public @WebResult(name = "diceResult")
	int rollTheDice(@WebParam(name = "dicePattern") String dicePattern)
			throws IllegalArgumentException, WebServiceException;

	@WSDLDocumentation("Lance une session de dé et retourne le résultat")
	@WebMethod
	@POST
	public @WebResult(name = "diceSessionResult")
	RollTheDiceFormResultBean rollTheRoller(
			@WebParam(name = "diceSessionRequest") RollTheDiceFormBean request)
			throws IllegalArgumentException, WebServiceException;
}
