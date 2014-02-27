package com.radamanth.ws.jaxrs.impl;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.radamanth.model.VerifyMailBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.service.impl.RadaDiceService;
import com.radamanth.ws.jaxrs.IMailVerifyerJaxrs;

/**
 * Created with IntelliJ IDEA.
 * User: radamanth
 * Date: 15/11/13
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/mailVerify"
@Path("/mailVerify")
public class MailVerifyer implements IMailVerifyerJaxrs {

    @Autowired
    IRadaDiceService serviceDice;

    /**
     *
     * @return usage
     */
    @Override
    @GET
    @Produces("application/json; charset=UTF-8")
    public VerifyMailBean usage() {
        VerifyMailBean usage = new VerifyMailBean();
        usage.setKey("TheMegaGeneratedKeyYouReceveive after "+ RadaDiceService.END_OF_MAIL);
        usage.setMailContent("This the content of the mail from "+RadaDiceService.START_OF_MAIL + " included to " +RadaDiceService.END_OF_MAIL + "included");
        return usage;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * @see com.radamanth.ws.jaxrs.IMailVerifyerJaxrs#verifyMail(com.radamanth.model.VerifyMailBean)
     */
    @Override
    @POST
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    public VerifyMailBean verifyMail(VerifyMailBean mail)
            throws IllegalArgumentException, WebServiceException {

        return serviceDice.verifyMail(mail);
    }
}