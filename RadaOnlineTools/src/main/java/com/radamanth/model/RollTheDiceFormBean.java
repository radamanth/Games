package com.radamanth.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement
@JsonAutoDetect
public class RollTheDiceFormBean {

    private List<OneRoll> requestedRoll= new ArrayList<OneRoll>();

    public List<OneRoll> getRequestedRoll() {
        return requestedRoll;
    }

    public void setRequestedRoll(List<OneRoll> requestedRoll) {
        this.requestedRoll = requestedRoll;
    }
}
