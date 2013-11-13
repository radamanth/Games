package com.radamanth.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;


@XmlRootElement
@JsonAutoDetect
public class RollTheDiceFormBean {

	
	private String author = null;
	
	private String dest1 = null;
	
	private String dest2 = null;
	
	private String dest3 = null;
	
	private String dest4 = null;
	
	private String dest5 = null;
	
    private ArrayList<OneRoll> requestedRoll= new ArrayList<OneRoll>();

    public ArrayList<OneRoll> getRequestedRoll() {
        return requestedRoll;
    }

    public void setRequestedRoll(ArrayList<OneRoll> requestedRoll) {
        this.requestedRoll = requestedRoll;
    }

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the dest1
	 */
	public String getDest1() {
		return dest1;
	}

	/**
	 * @param dest1 the dest1 to set
	 */
	public void setDest1(String dest1) {
		this.dest1 = dest1;
	}

	/**
	 * @return the dest2
	 */
	public String getDest2() {
		return dest2;
	}

	/**
	 * @param dest2 the dest2 to set
	 */
	public void setDest2(String dest2) {
		this.dest2 = dest2;
	}

	/**
	 * @return the dest3
	 */
	public String getDest3() {
		return dest3;
	}

	/**
	 * @param dest3 the dest3 to set
	 */
	public void setDest3(String dest3) {
		this.dest3 = dest3;
	}

	/**
	 * @return the dest4
	 */
	public String getDest4() {
		return dest4;
	}

	/**
	 * @param dest4 the dest4 to set
	 */
	public void setDest4(String dest4) {
		this.dest4 = dest4;
	}

	/**
	 * @return the dest5
	 */
	public String getDest5() {
		return dest5;
	}

	/**
	 * @param dest5 the dest5 to set
	 */
	public void setDest5(String dest5) {
		this.dest5 = dest5;
	}
}

