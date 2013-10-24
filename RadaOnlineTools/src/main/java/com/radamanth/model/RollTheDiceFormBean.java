package com.radamanth.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;


@XmlRootElement
@JsonAutoDetect
public class RollTheDiceFormBean {

	private Integer nbRoll1 = 1;
	private Integer nbRoll2 = 2;
	private Integer nbRoll3 = 3;
	private Integer nbRoll4 = 4;
	private Integer nbRoll5 = 5;
	
	private String dice1 ="";
	private String dice2 ="";
	private String dice3 ="";
	private String dice4 ="";
	private String dice5 ="";
	
	private String comment1="";
	private String comment2="";
	private String comment3="";
	private String comment4="";
	private String comment5="";
	public Integer getNbRoll1() {
		return nbRoll1;
	}
	public void setNbRoll1(Integer nbRoll1) {
		this.nbRoll1 = nbRoll1;
	}
	public Integer getNbRoll2() {
		return nbRoll2;
	}
	public void setNbRoll2(Integer nbRoll2) {
		this.nbRoll2 = nbRoll2;
	}
	public Integer getNbRoll3() {
		return nbRoll3;
	}
	public void setNbRoll3(Integer nbRoll3) {
		this.nbRoll3 = nbRoll3;
	}
	public Integer getNbRoll4() {
		return nbRoll4;
	}
	public void setNbRoll4(Integer nbRoll4) {
		this.nbRoll4 = nbRoll4;
	}
	public Integer getNbRoll5() {
		return nbRoll5;
	}
	public void setNbRoll5(Integer nbRoll5) {
		this.nbRoll5 = nbRoll5;
	}
	public String getDice1() {
		return dice1;
	}
	public void setDice1(String dice1) {
		this.dice1 = dice1;
	}
	public String getDice2() {
		return dice2;
	}
	public void setDice2(String dice2) {
		this.dice2 = dice2;
	}
	public String getDice3() {
		return dice3;
	}
	public void setDice3(String dice3) {
		this.dice3 = dice3;
	}
	public String getDice4() {
		return dice4;
	}
	public void setDice4(String dice4) {
		this.dice4 = dice4;
	}
	public String getDice5() {
		return dice5;
	}
	public void setDice5(String dice5) {
		this.dice5 = dice5;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public String getComment2() {
		return comment2;
	}
	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}
	public String getComment3() {
		return comment3;
	}
	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}
	public String getComment4() {
		return comment4;
	}
	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}
	public String getComment5() {
		return comment5;
	}
	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}
	
	
	
	
}
