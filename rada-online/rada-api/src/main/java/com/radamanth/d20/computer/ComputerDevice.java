package com.radamanth.d20.computer;

import java.util.Set;

import com.radamanth.d20.computer.action.ComputerAction;

public class ComputerDevice {
	private Integer Id;
	/**
	 * Le nom du device
	 */
	private String name;
	
	private Set<ComputerAction> listOfPossibleAction;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Set<ComputerAction> getListOfPossibleAction() {
		return listOfPossibleAction;
	}

	public void setListOfPossibleAction(Set<ComputerAction> listOfPossibleAction) {
		this.listOfPossibleAction = listOfPossibleAction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
