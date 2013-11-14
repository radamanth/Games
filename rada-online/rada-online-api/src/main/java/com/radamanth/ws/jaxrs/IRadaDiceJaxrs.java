package com.radamanth.ws.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.WebServiceException;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.VerifyMailBean;

@Path(value="diceSession")
public interface IRadaDiceJaxrs {
    

	@GET
	public RollTheDiceFormBean usage();
	
	@POST
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request);
	
	@POST
	public VerifyMailBean verifyMail(VerifyMailBean mail)throws IllegalArgumentException, WebServiceException;
}
