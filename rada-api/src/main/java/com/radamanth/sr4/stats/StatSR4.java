package com.radamanth.sr4.stats;


public abstract class StatSR4 {

	private final static Double D6P_SR4 = new Double (1D/3D);
	private final static Double D6Q_SR4 = new Double (2D/3D);
	private final static Double D6P_SR4_CRIT = new Double (1D/6D);
	private final static Double D6Q_SR4_CRIT = new Double (5D/6D);
	
	
	/**
         * http://fr.wikipedia.org/wiki/Loi_Binomiale
         * Lancer 8 dés revient à renouveler 8 fois de manière indépendante une épreuve de Bernouilli.
         * Le calcul est donc le suivant :
         * A : « Obtenir au moins 4 dés supérieur ou égal à 5 »
         * X, la variable aléatoire
         * P(A) = P(X >= 4) = P(X = 4) + P(X = 5) + ^Å + P(X=8)
         * P(X = k) = (n k)p^kq^n-k
         * n = 8
         * p = 1/3
         * q = 2/3
         *
         * @param poolSize
         * @param nbSuccessCible
         * @return
         */
	public final static  Double getMyChanceToHaveNbHitByPool(int poolSize, int nbSuccessCible) {
		Double res = new Double(0);
		for (int i = nbSuccessCible; i <= poolSize; i++) {
			res += PX(i, poolSize, D6P_SR4, D6Q_SR4);
		}
		System.out.println("Success : \npoolsize : " + poolSize +" nbsuccess : " + nbSuccessCible + " res : " + res);
		return new Double(0);
	}
	
	
	
	
 	/**
         * Chance d'avoir la moitié de ses dés à 6 pour un critical success
         * @param poolSize
         * @return
         */
	public final static Double getMyChanceToCritByPool(int poolSize) {
		Double res = new Double(0);
		int nbSuccessCible = poolSize / 2;
		if (poolSize % 2 > 0)
			nbSuccessCible++;
		
		for (int i = nbSuccessCible; i <= poolSize; i++) {
			res += PX(i, poolSize, D6P_SR4_CRIT, D6Q_SR4_CRIT);
		}
		System.out.println("Crit : \npoolsize : " + poolSize +" nbsuccess : " + nbSuccessCible + " res : " + res);
		return new Double(0);
	}
	
	/**
         * Chance d'avoir la moitié de ses dés (moins gremlin) à 1
         *
         * @param poolSize
         * @param gremlin
         * @return
         */
	public final static Double getMyChanceToCritFailByPool(int poolSize, int gremlin) {
		Double res = new Double(0);
		int nbCritFailCible = poolSize / 2; 
		if (poolSize % 2 > 0)
			nbCritFailCible++;
		nbCritFailCible = nbCritFailCible - gremlin;
		for (int i = nbCritFailCible; i <= poolSize; i++) {
			res += PX(i, poolSize, D6P_SR4_CRIT, D6Q_SR4_CRIT);
		}
		System.out.println("Crit FAIL : \npoolsize : " + poolSize +" nbFailure : " + nbCritFailCible + " gremlin: "+gremlin+" res : " + res);
		return new Double(0);
	}
	
	/**
	 * P(X = k) = Cnp(poolsize k)*p^k * q^(poolsize-k)
	 * @param k
	 * @param poolsize
	 * @return
	 */
	private final static Double  PX(int k, int poolsize, Double P, Double Q) {
		//System.out.println("Math.pow(D6P_SR4, k) = " + Math.pow(D6P_SR4, k));
		Double res = new Double ( cnp(poolsize, k)*Math.pow(P, k)*Math.pow(Q, (poolsize - k)) );
		//System.out.println("K : " + k + " poolsize : " + poolsize + " res : " + res);
		return res;
	}
	
	/**
	 * Cnk = n! / [p! (n - p)!]
	 * @param n
	 * @param p
	 * @return
	 */
	private final static Double cnp(int n, int p) {
		
		Double res = new Double(factoriel(n)/ ( factoriel(p) *factoriel(n-p) ) );
		//System.out.println("cnp n : " +n +" p : " + p +" = " + res);
		return res;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	private  final static Double factoriel(int p) {
		if (p == 0 ) 
			return new Double(1);
		Double res = new Double(1);
		for (double i = 1; i <= p; i++ ) {
			 res = res *i;
		}
		//System.out.println("factoriel " + p + "= "+res);
		return res;
	}
	
	/**
	 * Retourne le nombre de chance d'avoir exactement N hits
	 * @param nbHit
	 * @param poolSize
	 * @return
	 */
	public final static Double getMyChanceToHaveExactlyNbHit(int nbHit, int poolSize) {
		Double res= PX(nbHit, poolSize, D6P_SR4, D6Q_SR4);
		System.out.println();
		System.out.println("Exact hit : \npoolsize : " + poolSize +" nbHit : " + nbHit +" res : " + res);
		return res;
	}
	
	public static void main(String[] args) {

		getMyChanceToCritFailByPool(14, 4);
		getMyChanceToCritFailByPool(14, 0);
		getMyChanceToCritByPool(14);
		getMyChanceToHaveNbHitByPool(8, 1);
		getMyChanceToHaveExactlyNbHit(10, 12);
		
	}
}
