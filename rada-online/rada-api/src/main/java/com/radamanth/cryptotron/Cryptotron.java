package com.radamanth.cryptotron;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Le crytotron permet de faire un pseudo cryptage de caesar d'un fichier texte.
 * Il et destructeur en terme de mise en page car il split le text sur les caractère blanc sauf \n \r et \t 
 * @author CER3190183
 *
 */
public class Cryptotron {
	private final static int DEFAULT_CAESAR_SHIFT = 11;
	public final static int MODE_CRYPT = 1;
	public final static int MODE_DECRYPT = 2;
	/**
	 * Liste de clefs de Caesar pour les shift. si null ou vide alors on utilise
	 * uniquement le Caesar par défaut !
	 */
	private ArrayList<Integer> keyList = new ArrayList<Integer>();
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
	private int mode = MODE_CRYPT;
	
	/**
	 * Pourcentage de cryptag / decryptage
	 */
	private int centage = 100;
	
	public Cryptotron(String src, int mode, int cryptCentage,
			ArrayList<Integer> caeserKey) {
		this.src = src;
		this.mode = mode;
		this.centage = cryptCentage;
		keyList = caeserKey;
	}

	
	public String cypher() {
		// futur resultats crypte
		String crypted = new String();
		
		// Le tableau des mots sources
		String[] srcTab = src.split(" ");
		
		// Nbre de mots
		int nbWord = srcTab.length;
		int nbCarriageReturnNewLine = 0;
		for (String ss:srcTab) {
			if (isAuthorizedWithspaces(ss) )
				nbCarriageReturnNewLine++;
		}
		
		// Le tableau des mots crypte (ou pas :p )
		String[] retTab = new String[nbWord];

		// Nombre de mot à ne pas crypter ou decrypter
		int nbWordNotCrypted = ( nbWord - nbCarriageReturnNewLine) * (100 - centage) / 100;
		
		// set des indexs du tableau source à crypté
		TreeSet<Integer> notCryptedIndex = new TreeSet<Integer>();
		
		// selection des mots non cryptés en excluant \r et \n
		for (int i = 0; i < nbWordNotCrypted;) {
			// Random entre 0 et nbWord -1
			int tmpIndex = (int) (Math.random() * (nbWord));
			if (!notCryptedIndex.contains(tmpIndex) && !isAuthorizedWithspaces(srcTab[tmpIndex]) ) {
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
				if (mode == MODE_CRYPT)
					retTab[i] = cryptIt(srcTab[i]);
				else if (mode == MODE_DECRYPT)
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
		return crypted;
	}


	/**
	 * La chaine de caractère est elle \n ou \r ou \t
	 * @param ss
	 * @return
	 */
	private boolean isAuthorizedWithspaces(String ss) {
		return "\n".equalsIgnoreCase(ss) || "\r".equalsIgnoreCase(ss) || "\t".equalsIgnoreCase(ss);
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

	public ArrayList<Integer> getKeyList() {
		return keyList;
	}

	public TreeSet<Integer> getNotCryptedIndex() {
		return notCryptedIndex;
	}
	
	public String getLastResult() {
		return lastResult;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getCentage() {
		return centage;
	}

	public void setCentage(int centage) {
		this.centage = centage;
	}

	public void setKeyList(ArrayList<Integer> keyList) {
		this.keyList = keyList;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	
	
	
	
}
