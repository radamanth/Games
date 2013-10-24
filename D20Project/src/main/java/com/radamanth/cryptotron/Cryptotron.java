package com.radamanth.cryptotron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class Cryptotron {
	private final static int DEFAULT_CAESAR_SHIFT = 11;
	public final static int MODE_CRYPT = 1;
	public final static int MODE_DECRYPT = 2;
	/**
	 * Liste de clefs de Caesar pour les shift. si null ou vide alors on utilise
	 * uniquement le Caesar par défaut !
	 */
	private ArrayList<Integer> keyList = new ArrayList<Integer>();
	private TreeSet<Integer> notCryptedIndex = null;
	private String src = "";
	private String lastResult = "";
	private int mode = MODE_CRYPT;
	private int centage = 100;

	public Cryptotron(String src, int mode, int cryptCentage,
			ArrayList<Integer> caeserKey) {
		this.src = src;
		this.mode = mode;
		this.centage = cryptCentage;
		keyList = caeserKey;
	}

	public String cypher() {
		// resultats crypté
		String crypted = new String();
		// Le tableau des mots
		String[] srcTab = src.split(" ");
		for (int i = 0; i < srcTab.length; i++) {
			srcTab[i] = srcTab[i].trim();
		}
		// Nbre de mots
		int nbWord = srcTab.length;
		// Le tableau des mots crypté (ou pas :p )
		String[] retTab = new String[nbWord];

		// Nombre de mot à ne pas crypter ou decrypter
		int nbWordNotCrypted = nbWord * (100 - centage) / 100;
		TreeSet<Integer> notCryptedIndex = new TreeSet<Integer>();
		// selection des mots non cryptés
		for (int i = 0; i < nbWordNotCrypted;) {
			// Random entre 0 et nbWord -1
			int tmpIndex = (int) (Math.random() * (nbWord));
			if (!notCryptedIndex.contains(tmpIndex)) {
				notCryptedIndex.add(tmpIndex);
				i++;
			}
		}
		this.notCryptedIndex = notCryptedIndex;

		// sur tout les mots à crypter
		for (int i = 0; i < nbWord; i++) {
			if (notCryptedIndex.contains(new Integer(i)))
				retTab[i] = srcTab[i].trim();
			else {
				if (mode == MODE_CRYPT)
					retTab[i] = cryptIt(srcTab[i].trim());
				else if (mode == MODE_DECRYPT)
					retTab[i] = decryptIt(srcTab[i].trim());
				else
					retTab[i] = srcTab[i];
			}
		}

		for (int i = 0; i < retTab.length; i++) {
			crypted += retTab[i] + " ";
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

	
	
	
	public static void main(String[] args) {
		String src = "Test de cryptage à la con juste pour voir.";
		ArrayList<Integer> ckey = new ArrayList<Integer>();
		ckey.add(1);
		ckey.add(15);
		ckey.add(23);
		ckey.add(12);
//		System.out.println("LA SOURCE : " + src);
		Cryptotron c = new Cryptotron(src, 1, 100, ckey);
//		String ret = c.cypher();
//		System.out.println("Crypted : " + ret);
//		c.setSrc(ret);
//		c.setMode(c.MODE_DECRYPT);
//		c.setCentage(100);
//		System.out.println("Decrypted : " + c.cypher());
		
		try {
			File f = new File("tmp.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String s ="";
			while (line != null) {
				s += line +"\n";
				line = br.readLine();
			}
			System.out.println("LA SOURCE FILE : " + s);
			c.setSrc(s);
			c.setMode(Cryptotron.MODE_CRYPT);
			c.setCentage(100);
			String ret2 = c.cypher();
			System.out.println("Crypted File : " + ret2);
			File f2 = new File("tmp.crypted.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
			bw.write(ret2);
			bw.close();
			c.setSrc(ret2);
			c.setMode(Cryptotron.MODE_DECRYPT);
			c.setCentage(100);
			ret2 = c.cypher();
			System.out.println("Decrypted file : " + ret2);
			File f3 = new File("tmp.crypted.decrypted.txt");
			bw = new BufferedWriter(new FileWriter(f3));
			bw.write(ret2);
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
