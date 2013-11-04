package com.radamanth.ws.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.radamanth.model.RollTheDiceFormBean;

@Path(value="diceSession")
public interface IRadaDiceJaxrs {
    

//	@GET
//	public String usage();
	
	@GET
	public RollTheDiceFormBean usage();
	
	@POST
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request);
}
