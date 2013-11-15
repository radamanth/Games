package com.radamanth.ws.jaxrs;

import com.radamanth.model.VerifyMailBean;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.WebServiceException;

/**
 * Created with IntelliJ IDEA.
 * User: radamanth
 * Date: 15/11/13
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
@Path(value="mailVerifyer")
public interface IMailVerifyerJaxrs {
    @GET
    public VerifyMailBean usage();

    @POST
    public VerifyMailBean verifyMail(VerifyMailBean mail)throws IllegalArgumentException, WebServiceException;
}
