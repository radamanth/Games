package com.radamanth.ws.jaxws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.ws.jaxws.IRadaDice;

@WebService
public class RadaDice implements IRadaDice {

	@Autowired
	IRadaDiceService serviceDice;

	@Override
	@WebMethod
	public @WebResult(name = "diceResult")
	int rollTheDice(@WebParam(name = "dicePattern") String dicePattern)
			throws IllegalArgumentException, WebServiceException {
		return serviceDice.rollTheDice(dicePattern);

	}

	@Override
	@WebMethod
	public @WebResult(name = "diceSessionResult")
	RollTheDiceFormBean rollTheRoller(
			@WebParam(name = "diceSessionRequest") RollTheDiceFormBean request)
			throws IllegalArgumentException, WebServiceException {
		return serviceDice.rollTheRoller(request);

	}

}
