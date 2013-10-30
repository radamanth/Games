package com.radamanth.ws.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.RollTheDiceFormResultBean;

@Path(value="diceSession")
public interface IRadaDiceJaxrs {

	@GET
	public String usage();
	
	@POST
	public RollTheDiceFormBean rollTheDice(RollTheDiceFormBean request);
}
