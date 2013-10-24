package com.radamanth.d20modern.computer.action;


public interface ComputerAction {

	public String getName();
	public String getDescription();
	public ComputerActionResult doAction();
}
