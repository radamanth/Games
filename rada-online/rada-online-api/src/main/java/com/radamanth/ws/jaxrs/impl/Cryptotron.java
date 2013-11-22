/**
 * 
 */
package com.radamanth.ws.jaxrs.impl;

import javax.ws.rs.Path;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.radamanth.model.CryptotronBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.ws.jaxrs.ICryptotronJaxrs;

/**
 * @author CER3190183
 *
 */
@Path(value="/cryptotron")
public class Cryptotron implements ICryptotronJaxrs{
	
	@Autowired
    IRadaDiceService serviceDice;

	/** 
	 * @see com.radamanth.ws.jaxrs.ICryptotronJaxrs#usage()
	 */
	@Override
	public CryptotronBean usage() {
		// TODO Auto-generated method stub
		CryptotronBean cryptotronBean = new CryptotronBean();
		cryptotronBean.setSrc("example");
		cryptotronBean.setRes("example");
		int[] keys = {1,11,42};
		cryptotronBean.setKey(keys);
		return cryptotronBean;
	}

	/** 
	 * @see com.radamanth.ws.jaxrs.ICryptotronJaxrs#cypher(com.radamanth.model.CryptotronBean)
	 */
	@Override
	public CryptotronBean cypher(CryptotronBean request)
			throws IllegalArgumentException, WebServiceException {
		
		return request;
	}


}
