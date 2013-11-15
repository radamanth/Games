package com.radamanth.ws.jaxrs.impl;
import com.radamanth.model.VerifyMailBean;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.service.impl.RadaDiceService;
import com.radamanth.ws.jaxrs.IMailVerifyerJaxrs;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.xml.ws.WebServiceException;

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
    @Produces("application/json")
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
    @Produces("application/json")
    @Consumes("application/json")
    public VerifyMailBean verifyMail(VerifyMailBean mail)
            throws IllegalArgumentException, WebServiceException {

        return serviceDice.verifyMail(mail);
    }
}