package com.radamanth.d20modern.computer.action;

public class ComputerActionResult {
	public final static int RETURN_CODE_OK = 0;
	public final static int RETURN_CODE_ERR = -1;	
	
	/**
	 * 0 is OK
	 */
	private int returnCode = ComputerActionResult .RETURN_CODE_OK;
	private String output ="";
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	
	

}
