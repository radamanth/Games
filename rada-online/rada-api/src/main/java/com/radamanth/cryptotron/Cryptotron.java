package com.radamanth.cryptotron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Le crytotron permet de faire un pseudo cryptage de caesar d'un fichier texte.
 * Il et destructeur en terme de mise en page car il split le text sur les caractère blanc sauf \n \r et \t 
 * @author CER3190183
 *
 */
public class Cryptotron {
	/**
	 * defaut caesar shift 
	 */
	private final static int DEFAULT_CAESAR_SHIFT = 11;
	/**
	 * Mode du Crytotron
	 *  
	 * @author radamanth
	 *
	 */
	public static enum CryptModeEnum {
		CRYPT, DECRYPT;
	}
	/**
	 * Liste de clefs de Caesar pour les shift. si null ou vide alors on utilise
	 * uniquement le Caesar par défaut !
	 */
	private List<Integer> keyList = new ArrayList<Integer>();
	/**
	 * List des index de mots non cryptés
	 */
	private TreeSet<Integer> notCryptedIndex = null;
	/**
	 * TExt Source 
	 */
	private String src = "";
	/**
	 * Dernier résultat
	 */
	private String lastResult = "";
	/**
	 * Mode du Crytotron
	 */
	private CryptModeEnum mode = CryptModeEnum.CRYPT;
	
	/**
	 * Pourcentage de cryptag / decryptage
	 */
	private int centage = 100;
	
	/**
	 * Construction du Cryptotron
	 * @param src - source à crypter ou décrypter
	 * @param mode - Crytpage ou Decryptage 
	 * @param cryptCentage
	 * @param caeserKey
	 */
	public Cryptotron(String src, CryptModeEnum mode, int cryptCentage,
			List<Integer> caeserKey) {
		this.src = src;
		this.mode = mode;
		this.centage = cryptCentage;
		keyList = caeserKey;
	}

//	private Pattern PATTERN_WHITESPACE = Pattern.compile("\\s");
	private boolean isWhiteSpaceOnly(String s) {
		if (s == null)
			return false;
		return s.matches("^\\s*$");
	}
	/**
	 * Retourne la source traité par le {@link Cryptotron}
	 * @return
	 */
	public String cypher() {
		// futur resultats crypte
		String crypted = new String();
		
		StringReader sr = new StringReader(src);
		BufferedReader br = new BufferedReader(sr);
		try {
			for (String line = br.readLine(); line != null ; line = br.readLine() ) {
				
				// Le tableau des mots sources
				String[] srcTab = line.split(" ");
				// Nbre de mots
				
				int nbWord = srcTab.length;
				int nbWhiteSpaceReturnNewLine = 0;
				for (String ss:srcTab) {
					if (isWhiteSpaceOnly(ss) )
						nbWhiteSpaceReturnNewLine++;
				}
				// Le tableau des mots crypte (ou pas :p )
				String[] retTab = new String[nbWord];
				// Nombre de mot à ne pas crypter ou decrypter
				int nbWordNotCrypted = ( nbWord - nbWhiteSpaceReturnNewLine) * (100 - centage) / 100;
				// set des indexs du tableau source à crypté
				TreeSet<Integer> notCryptedIndex = new TreeSet<Integer>();
				// selection des mots non cryptés en excluant \r et \n
				for (int i = 0; i < nbWordNotCrypted;) {
					// Random entre 0 et nbWord -1
					int tmpIndex = (int) (Math.random() * (nbWord));
					if (!notCryptedIndex.contains(tmpIndex) && !isWhiteSpaceOnly(srcTab[tmpIndex]) ) {
						notCryptedIndex.add(tmpIndex);
						i++;
					}
				}
				this.notCryptedIndex = notCryptedIndex;
				
				// sur tout les mots à crypter
				for (int i = 0; i < nbWord; i++) {
					if (notCryptedIndex.contains(new Integer(i)))
						retTab[i] = srcTab[i];
					else {
						if (CryptModeEnum.CRYPT.equals(mode))
							retTab[i] = cryptIt(srcTab[i]);
						else if (CryptModeEnum.DECRYPT.equals(mode))
							retTab[i] = decryptIt(srcTab[i]);
						else
							retTab[i] = srcTab[i];
					}
				}

				for (int i = 0; i < retTab.length; i++) {
					crypted += retTab[i] ;
					if (i < retTab.length-1)
						crypted += " ";
					}
			}
		} catch (IOException e) {
			return "Erreur lors de la lecture de la source " + e.getMessage();
		}
		
		return crypted;
	}


	

	/**
	 * methode qui crypte en vrai
	 * 
	 * @param src
	 * @return
	 */
	private String cryptIt(String src) {

		char[] s = src.toCharArray();
		int caesarshift = 0;
		for (int i = 0; i < s.length; i++) {

			if (keyList == null || keyList.size() == 0) {
				s[i] = (char) (s[i] + DEFAULT_CAESAR_SHIFT);
			} else {
				if (caesarshift >= keyList.size())
					caesarshift = 0;

				s[i] = (char) (s[i] + keyList.get(caesarshift++).intValue());
			}

		}
		return new String(s);

	}

	/**
	 * methode qui crypte en vrai
	 * 
	 * @param src
	 * @return
	 */
	private String decryptIt(String src) {

		char[] s = src.toCharArray();
		int caesarshift = 0;
		for (int i = 0; i < s.length; i++) {

			if (keyList == null || keyList.size() == 0) {
				s[i] = (char) (s[i] - DEFAULT_CAESAR_SHIFT);
			} else {
				if (caesarshift >= keyList.size())
					caesarshift = 0;

				s[i] = (char) (s[i] - keyList.get(caesarshift++).intValue());
			}

		}
		return new String(s);

	}


	/**
	 * @return the keyList
	 */
	public List<Integer> getKeyList() {
		return keyList;
	}


	/**
	 * @param keyList the keyList to set
	 */
	public void setKeyList(List<Integer> keyList) {
		this.keyList = keyList;
	}


	/**
	 * @return the notCryptedIndex
	 */
	public TreeSet<Integer> getNotCryptedIndex() {
		return notCryptedIndex;
	}


	/**
	 * @param notCryptedIndex the notCryptedIndex to set
	 */
	public void setNotCryptedIndex(TreeSet<Integer> notCryptedIndex) {
		this.notCryptedIndex = notCryptedIndex;
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
	 * @return the lastResult
	 */
	public String getLastResult() {
		return lastResult;
	}


	/**
	 * @param lastResult the lastResult to set
	 */
	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
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
	 * @return the centage
	 */
	public int getCentage() {
		return centage;
	}


	/**
	 * @param centage the centage to set
	 */
	public void setCentage(int centage) {
		this.centage = centage;
	}

		
	
	
}
