package com.radamanth.d20.computer.action;


public interface ComputerAction {

	public String getName();
	public String getDescription();
	public ComputerActionResult doAction();
}
