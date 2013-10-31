package com.radamanth.ws.jaxrs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.ws.jaxrs.IRadaDiceJaxrs;


@Path(value="diceSession")
public class RadaDice implements IRadaDiceJaxrs{

	@Autowired
	IRadaDiceService serviceDice;
	
	@Override
	@GET
	public String usage() {
		return serviceDice.usage();
	}

	@Override
	@POST
	public RollTheDiceFormBean rollTheDice(RollTheDiceFormBean request) {
		return serviceDice.rollTheRoller(request);
	}

	


	
	

}
