package com.radamanth.ws.jaxrs.impl;

import com.radamanth.model.OneRoll;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.ws.jaxrs.IRadaDiceJaxrs;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;


@Path(value="diceSession")
public class RadaDice implements IRadaDiceJaxrs{

    @Autowired
    IRadaDiceService serviceDice;

	/**
	 * @see com.radamanth.ws.jaxrs.IRadaDiceJaxrs#usage()
	 */
	@Override
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public RollTheDiceFormBean usage() {
		RollTheDiceFormBean res = new RollTheDiceFormBean();
		ArrayList<OneRoll> requestedRoll = new ArrayList<OneRoll>();
		OneRoll e = new OneRoll();
		e.setComment("comment1");
		e.setDice("1D20");
		e.setNbRoll(10);
		requestedRoll.add(e );
		OneRoll e2 = new OneRoll();
		e2.setComment("comment2");
		e2.setDice("10D20+12R1B2");
		e2.setNbRoll(3);
		requestedRoll.add(e2 );
		res.setRequestedRoll(requestedRoll);
		return res;
	}

	@Override
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request) {
		return serviceDice.rollTheRoller(request);
	}

}
