package com.radamanth.ws.jaxrs;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.WebServiceException;

import com.radamanth.model.CryptotronBean;

/**
 * Created with IntelliJ IDEA.
 * User: radamanth
 * Date: 15/11/13
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
@Path(value="cryptotron")
public interface ICryptotronJaxrs {
	/**
	 * Return usage for service
	 * @return
	 */
    @GET
    public CryptotronBean usage();

    /**
     * Crypt or decrypt a content
     * @param request
     * @return
     * @throws IllegalArgumentException
     * @throws WebServiceException
     */
    @POST
    public CryptotronBean cypher(CryptotronBean request)throws IllegalArgumentException, WebServiceException;
}
