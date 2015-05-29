package com.radamanth.ws.jaxws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.VerifyMailBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.ws.WsNameSpace;
import com.radamanth.ws.jaxws.IRadaDice;

@WebService(targetNamespace=WsNameSpace.RADA_JAXWS_NS)
public class RadaDice implements IRadaDice {

	@Autowired
	IRadaDiceService serviceDice;

	/**
	 * 
	 * @see com.radamanth.ws.jaxws.IRadaDice#rollTheDice(java.lang.String)
	 */
	@Override
	@WebMethod
	public @WebResult(name = "diceResult")
	int rollTheDice(@WebParam(name = "dicePattern") String dicePattern)
			throws IllegalArgumentException, WebServiceException {
		return serviceDice.rollTheDice(dicePattern);

	}

	/**
	 * 
	 * @see com.radamanth.ws.jaxws.IRadaDice#rollTheRoller(com.radamanth.model.RollTheDiceFormBean)
	 */
	@Override
	@WebMethod
	public @WebResult(name = "diceSessionResult")
	RollTheDiceFormBean rollTheRoller(
			@WebParam(name = "diceSessionRequest") RollTheDiceFormBean request)
			throws IllegalArgumentException, WebServiceException {
		return serviceDice.rollTheRoller(request);

	}

	/** 
	 * @see com.radamanth.ws.jaxws.IRadaDice#verifyMail(com.radamanth.model.VerifyMailBean)
	 */
	@Override
	public VerifyMailBean verifyMail(VerifyMailBean mail)
			throws IllegalArgumentException, WebServiceException {
		return serviceDice.verifyMail(mail);
	}

}
