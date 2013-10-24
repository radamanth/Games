package com.radamanth.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@XmlRootElement
@JsonAutoDetect
public class RollTheDiceFormResultBean {

	private RollTheDiceFormBean request;
	
	private List<Integer> res1;
	private List<Integer> res2;
	private List<Integer> res3;
	private List<Integer> res4;
	private List<Integer> res5;
	public RollTheDiceFormBean getRequest() {
		return request;
	}
	public void setRequest(RollTheDiceFormBean request) {
		this.request = request;
	}
	public List<Integer> getRes1() {
		return res1;
	}
	public void setRes1(List<Integer> res1) {
		this.res1 = res1;
	}
	public List<Integer> getRes2() {
		return res2;
	}
	public void setRes2(List<Integer> res2) {
		this.res2 = res2;
	}
	public List<Integer> getRes3() {
		return res3;
	}
	public void setRes3(List<Integer> res3) {
		this.res3 = res3;
	}
	public List<Integer> getRes4() {
		return res4;
	}
	public void setRes4(List<Integer> res4) {
		this.res4 = res4;
	}
	public List<Integer> getRes5() {
		return res5;
	}
	public void setRes5(List<Integer> res5) {
		this.res5 = res5;
	}
	
}
