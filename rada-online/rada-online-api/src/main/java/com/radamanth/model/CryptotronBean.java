/**
 * 
 */
package com.radamanth.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * @author radamanth
 *
 */
@XmlRootElement
@JsonAutoDetect
public class CryptotronBean {
	
	private String src = "";
	private String res = "";
	private int[] key = {42};
	private CryptModeEnum mode = CryptModeEnum.CRYPT;
	private int percentage = 100;
	@XmlEnum(value=String.class)
	public static enum CryptModeEnum {
		CRYPT, DECRYPT;
	}
	
	
	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}
	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	/**
	 * @return the res
	 */
	public String getRes() {
		return res;
	}
	/**
	 * @param res the res to set
	 */
	public void setRes(String res) {
		this.res = res;
	}
	/**
	 * @return the key
	 */
	public int[] getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(int[] key) {
		this.key = key;
	}
	/**
	 * @return the mode
	 */
	public CryptModeEnum getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(CryptModeEnum mode) {
		this.mode = mode;
	}
	/**
	 * @return the percentage
	 */
	public int getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	
	
}
