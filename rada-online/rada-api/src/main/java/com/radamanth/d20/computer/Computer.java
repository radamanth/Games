package com.radamanth.d20.computer;

import java.util.List;

public class Computer  extends ComputerDevice{
	
	
	/**
	 * niveau de securité
	 */
	private int securityLevel;
	/**
	 *  Nombre de node
	 */
	private int nbNode;
	/**
	 *  Profondeur de node
	 */
	private int maxNodeDepth;
	/**
	 *  nombre d'alerte déclenchant la surveillance
	 */
	private int alertThreshold;
	/**
	 *  Les fichiers trouvés sont ils cryptés!
	 */
	private boolean crypted;
	/**
	 * Taille des clefs de cryptages (nbre de clefs)
	 */
	private int crytedLevel;
	/**
	 *  liste des clefs de cryptafges @see Cryptotron
	 *  Ex : 
	 */
	private List<Integer> crtptedKeys ;
	/**
	 *  L'ordinateur est il sous surveillance.
	 */
	private boolean underSurveillance;
	
	/**
	 * Liste des fichiers contenus dans le computeur
	 */
	private List<ComputerFile> listOfFile ;
	/**
	 * Liste des device controlés par un computer : autrec computer, camera, porte, tourelles, climatisations, electricité etc...
	 * 
	 */
	private List<ComputerDevice> listOfDevice;
	
	
	
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public int getNbNode() {
		return nbNode;
	}
	public void setNbNode(int nbNode) {
		this.nbNode = nbNode;
	}
	public int getMaxNodeDepth() {
		return maxNodeDepth;
	}
	public void setMaxNodeDepth(int maxNodeDepth) {
		this.maxNodeDepth = maxNodeDepth;
	}
	public int getAlertThreshold() {
		return alertThreshold;
	}
	public void setAlertThreshold(int alertThreshold) {
		this.alertThreshold = alertThreshold;
	}
	public boolean isCrypted() {
		return crypted;
	}
	public void setCrypted(boolean crypted) {
		this.crypted = crypted;
	}
	public int getCrytedLevel() {
		return crytedLevel;
	}
	public void setCrytedLevel(int crytedLevel) {
		this.crytedLevel = crytedLevel;
	}
	public List<Integer> getCrtptedKeys() {
		return crtptedKeys;
	}
	public void setCrtptedKeys(List<Integer> crtptedKeys) {
		this.crtptedKeys = crtptedKeys;
	}
	public boolean isUnderSurveillance() {
		return underSurveillance;
	}
	public void setUnderSurveillance(boolean underSurveillance) {
		this.underSurveillance = underSurveillance;
	}
	public List<ComputerFile> getListOfFile() {
		return listOfFile;
	}
	public void setListOfFile(List<ComputerFile> listOfFile) {
		this.listOfFile = listOfFile;
	}
	public List<ComputerDevice> getListOfDevice() {
		return listOfDevice;
	}
	public void setListOfDevice(List<ComputerDevice> listOfDevice) {
		this.listOfDevice = listOfDevice;
	}
	
	
	
}
