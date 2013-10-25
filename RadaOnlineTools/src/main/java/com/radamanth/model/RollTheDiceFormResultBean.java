package com.radamanth.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@XmlRootElement
@JsonAutoDetect
public class RollTheDiceFormResultBean {

	private RollTheDiceFormBean request;

    public RollTheDiceFormBean getRequest() {
        return request;
    }

    public void setRequest(RollTheDiceFormBean request) {
        this.request = request;
    }
}
