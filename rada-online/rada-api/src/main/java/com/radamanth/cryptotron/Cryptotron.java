package com.radamanth.cryptotron;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Le crytotron permet de faire un pseudo cryptage de caesar d'un fichier texte.
 * 
 * 
 * @author CER3190183
 * 
 */
public class Cryptotron {
	/**
	 * 
	 */
	private static final BigDecimal BIGDEC_100 = new BigDecimal(100);
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
		CRYPT(1), DECRYPT(1);
		
		private int sens ;
		private CryptModeEnum(int sens) {
			this.sens = sens;
		}
		/**
		 * @return the sens
		 */
		public int getSens() {
			return sens;
		}
		
		
	}

	/**
	 * Liste de clefs de Caesar pour les shift. si null ou vide alors on utilise
	 * uniquement le Caesar par défaut !
	 */
	private List<Integer> keyList = new ArrayList<Integer>();
	/**
	 * List des index de mots non cryptés
	 */
	private TreeSet<Integer> cypheredIndex = null;
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
	private BigDecimal centageBDecimal = null;
	
	
	/**
	 * Split Src DAta 
	 */
	private SplitData split = null;
	

	/**
	 * Construction du Cryptotron
	 * 
	 * @param src
	 *            - source à crypter ou décrypter
	 * @param mode
	 *            - Crytpage ou Decryptage
	 * @param cryptCentage
	 * @param caeserKey
	 */
	public Cryptotron(String src, CryptModeEnum mode, int cryptCentage,
			List<Integer> caeserKey) {
		this.src = src;
		this.mode = mode;
		this.centage = cryptCentage;
		this.centageBDecimal = new BigDecimal(this.centage);
		this.centageBDecimal = this.centageBDecimal.divide(BIGDEC_100, 2, RoundingMode.HALF_UP);
		this.keyList = caeserKey;
		this.split = CryptotronUtils.splitIntoWordsAndSpaces(this.src, this.mode);
		
		
	}

	
	

	/**
	 * Retourne la source traité par le {@link Cryptotron}
	 * 
	 * 
	 * 
	 * @return
	 */
	public String cypher() {
		if (this.centage == 0)
			return this.src;
		
		

		int nbWord = split.getWordIndexSet().size() ;
		
		
		TreeSet<Integer> cypheredIndex = new TreeSet<Integer>();
		// Selection des indexs mots à traiter
		
		Integer [] wordIndexArray = new Integer[split.getWordIndexSet().size()];
		split.getWordIndexSet().toArray(wordIndexArray);
		for (int i= 0; i < nbWord;i++) {
			if (i < split.getWordIndexSet().size() && isCyphered(cypheredIndex.size(), i))
				cypheredIndex.add(wordIndexArray[i]);
		}
		this.cypheredIndex = cypheredIndex;
		
		
		
		// sur tout les mots à crypter
		List<String> cryptedResult = new ArrayList<String>();
		for (int i = 0; i < split.getListOfWordsAndWhiteSpace().size(); i++) {
			String cypher = split.getListOfWordsAndWhiteSpace().get(i);
			if (!cypheredIndex.contains(new Integer(i))
					|| CryptotronUtils.isWhiteSpaceOnly(cypher)) {
				// Pas chiffré
				cypher = split.getListOfWordsAndWhiteSpace().get(i);
			}
			else {
				cypher = cryptIt(cypher, mode);
				
			}

			cryptedResult.add(cypher);
		}

		StringBuilder sb = new StringBuilder();
		for (String cypher : cryptedResult) {
			sb.append(cypher);
		}
		return sb.toString();

	}




	

	/**
	 * Cas n : si tu as crypté k mots entre 1 et n, alors si k/n > p alors tu ne cryptes pas m_n, sinon, tu cryptes m_n.
	 * n = indexWord
	 * k = nbAlreadyCrypted
	 * 
	 * 
	 * @param nbAlreadyCrypted
	 * @param indexWord
	 * @return
	 */
	private boolean isCyphered(int nbAlreadyCrypted, int indexWord  )  {
		if (indexWord == 0)
			return true;
		BigDecimal n = new BigDecimal(indexWord);
		BigDecimal k = new BigDecimal(nbAlreadyCrypted);
		BigDecimal result = k.divide(n, 2, RoundingMode.HALF_UP);
		if (result.compareTo(this.centageBDecimal) <= 0) {
			return true;
		}
		
		
		return false;
	}

	/**
	 * methode qui crypte en vrai
	 * 
	 * @param src
	 * @return
	 */
	private String cryptIt(String src, CryptModeEnum mode) {

		if (this.split.getDicoCharList() == null || this.split.getDicoCharList().isEmpty())
			return src;
		
		char[] s = src.toCharArray();
		
		int sens = mode.getSens();
		int caesarshift = 0;
		for (int i = 0; i < s.length; i++) {

			int index = split.getDicoCharList().indexOf(s[i]);
		
			int newIndex = index;
			if (keyList == null || keyList.size() == 0) {
				newIndex = index + (sens * DEFAULT_CAESAR_SHIFT);
				newIndex = checkNewIndex(newIndex);
				s[i] = split.getDicoCharList().get(newIndex);
				
			} else {
				if (caesarshift >= keyList.size())
					caesarshift = 0;
				newIndex = index + (sens *keyList.get(caesarshift++).intValue() );
				newIndex = checkNewIndex(newIndex);
				s[i] = split.getDicoCharList().get(newIndex);
				
			}
//			sens = -1 * sens;

		}
		return new String(s);

	}

	/**
	 * Corrige le nouvelIndex en fonction de la taille du dictionnaire.
	 * @param newIndex
	 * @return
	 */
	private int checkNewIndex(int newIndex) {
		if (this.split.getDicoCharList() == null )
			return newIndex;
		if (this.split.getDicoCharList().size()== 0)
			throw new IllegalStateException("Impossible de corrigé un index si aucun dictionnaire n'est défini.");
		int max = this.split.getDicoCharList().size() -1;
		int increment = this.split.getDicoCharList().size();
		while ( newIndex < 0)
			newIndex += increment;
		while ( newIndex > max)
			newIndex -= increment;
		
		return newIndex;
	}


	
	/**
	 * @return the keyList
	 */
	public List<Integer> getKeyList() {
		return keyList;
	}

	/**
	 * @param keyList
	 *            the keyList to set
	 */
	public void setKeyList(List<Integer> keyList) {
		this.keyList = keyList;
	}

	/**
	 * @return the notCryptedIndex
	 */
	public TreeSet<Integer> getNotCryptedIndex() {
		return cypheredIndex;
	}

	/**
	 * @param notCryptedIndex
	 *            the notCryptedIndex to set
	 */
	public void setNotCryptedIndex(TreeSet<Integer> notCryptedIndex) {
		this.cypheredIndex = notCryptedIndex;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src
	 *            the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
		this.split = CryptotronUtils.splitIntoWordsAndSpaces(this.src, this.mode);
	}

	/**
	 * @return the lastResult
	 */
	public String getLastResult() {
		return lastResult;
	}

	/**
	 * @param lastResult
	 *            the lastResult to set
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
	 * @param mode
	 *            the mode to set
	 */
	public void setMode(CryptModeEnum mode) {
		this.mode = mode;
		this.split = CryptotronUtils.splitIntoWordsAndSpaces(this.src, this.mode);
	}

	/**
	 * @return the centage
	 */
	public int getCentage() {
		return centage;
	}

	/**
	 * @param centage
	 *            the centage to set
	 */
	public void setCentage(int centage) {
		this.centage = centage;
		this.centageBDecimal = new BigDecimal(this.centage);
		this.centageBDecimal= this.centageBDecimal.divide(BIGDEC_100, 2, RoundingMode.HALF_UP);
	}

}
