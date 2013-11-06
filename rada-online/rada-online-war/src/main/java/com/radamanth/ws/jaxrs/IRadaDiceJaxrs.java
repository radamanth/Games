package com.radamanth.ws.jaxrs;

import com.radamanth.model.RollTheDiceFormBean;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path(value="diceSession")
public interface IRadaDiceJaxrs {
    

	@GET
	public RollTheDiceFormBean usage();
	
	@POST
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request);
}
