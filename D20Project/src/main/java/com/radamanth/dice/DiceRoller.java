package com.radamanth.dice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author radamanth
 * 
 */
public abstract class DiceRoller {

        /**
         * PAttern : ^[0-9]+[dD][0-9]+([pPMm][0-9]*)?([rR][0-9]+)?([bB][0-9]+)?$
         */
        public static final String DICE_PATTERN = "^[0-9]+[dD][0-9]+([\\-\\+][0-9]*)?([rR][0-9]+)?([bB][0-9]+)?$";
            public static final String MINUS = "-";
            public static final String PLUS = "+";
            public static final String REROLL = "r";
            public static final String BEST = "b";

    /**
         * 
         * @param diceStr
         *            -
         * @param score
         * @param critThreshold
         * @return
         */
        public static boolean isCritical(String diceStr, int score,
                        int critThreshold) {

                if (diceStr != null && diceStr.matches(DICE_PATTERN)) {
                        
                        Integer[] tabint = getTabIntFromDiceStr(diceStr);
                        if ((score -  tabint[2]) >= (critThreshold))
                                return true;

                } else
                        usage(diceStr);

                return false;
        }

        private static Integer[] getTabIntFromDiceStr(String diceStr) {
                diceStr = diceStr.toLowerCase();
                
                Integer tabint[] = new Integer[5];
                int indexM = diceStr.indexOf(MINUS);
                int indexP = diceStr.indexOf(PLUS);
                int indexR = diceStr.indexOf(REROLL);
                int indexB = diceStr.indexOf(BEST);


                String splitStr[] = diceStr.split("[d\\-\\+rb]");
                // NbDice
                tabint[0] = Integer.parseInt(splitStr[0]);
                // diceType
                tabint[1] = Integer.parseInt(splitStr[1]);
                int absent = 0;
                // BONUS
                if (indexM != -1 || indexP != -1) {
                        tabint[2] = Integer.parseInt(splitStr[2]);
                        if (indexM != -1)
                            tabint[2] = -1 * tabint[2];
                } else {
                        tabint[2] = 0;
                        absent++;
                }
                // REROLL
                if (indexR != -1) {
                        tabint[3] = Integer.parseInt(splitStr[3 - absent]);
                } else {
                        tabint[3] = 0;
                        absent++;
                }

                if (indexB != -1) {
                        tabint[4] = Integer.parseInt(splitStr[4 - absent]);
                } else {
                        // Dans la cas du BEST ALL
                        tabint[4] = tabint[0];
                }

                return tabint;
        }

        /**
         * 
         * @param diceStr
         *            - Un chaine du type 3D6+12R1
         * @return - Le resultat du jet de d�s ou renvoit une erreur
         */
        public static int rollDice(String diceStr) throws IllegalArgumentException {
                if (diceStr != null) {

                        if (diceStr.matches(DICE_PATTERN)) {
                                
                                Integer[] tabint = getTabIntFromDiceStr(diceStr);
                                try {
                                        int nbDice = tabint[0];
                                        int diceType = tabint[1];
                                        int bonus = tabint[2] ;
                                        int rerollValue = tabint[3];
                                        int bestof = tabint[4];

                                        int resultat = 0;
                                        LinkedList<Integer> tempdiceResult = new LinkedList<Integer>();
                                        // (int)(Math.random() * (higher-lower)) + lower
                                        // valeurs comprises en lower(inclus) et higher(exclus)
                                        for (int i = 0; i < nbDice; i++) {
                                                int tmpIntValue = (int) (Math.random() * ((diceType + 1) - (1 + rerollValue)))
                                                                + (1 + rerollValue);
                                                // System.out.println(tmpIntValue);
                                                tempdiceResult.add(tmpIntValue);
                                        }

                                        Collections.sort(tempdiceResult);
                                        Collections.reverse(tempdiceResult);
                                        // for (Integer ii : tempdiceResult) {
                                        // System.out.println(ii);
                                        // }
                                        Collection<Integer> subset = tempdiceResult.subList(0,
                                                        (int) bestof);
                                        for (Integer best : subset) {
                                                // System.out.println("++" + best);
                                                resultat += best;
                                        }
                                        // System.out.println("++"+bonus);
                                        resultat += (int) bonus;
                                        // System.out.println(resultat);
                                        return resultat;

                                } catch (Exception e) {
                                        throw new IllegalArgumentException(e);
                                }

                        } else {
                                String res = usage(diceStr);
                                throw new IllegalArgumentException(res);
                        }

                }
                return 0;
        }

        public static String usage(String diceStr) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);

                pw.println("Format attendu (" + diceStr + ").");
                pw.println("Cela doit etre de la forme  3D6+4R2B1 ");
                pw.println("3D6 fait partie de la partie obligatoire et lance donc 3 dés à 6 faces. 1D20 lance 1D20 ");
                pw.println("+4 ou -4 cette partie ajoute un bonus/malus.");
                pw.println("R2  Reroll 2 : indique donc les valeurs en dessous de laquelle on relance le dés (valeur comprise) pour ne pas reroller ne pas mettre de valeur ou mettre R0");
                pw.println("B1 pour Best 1  ");
                pw.println("on peut mettre des minuscule au lieux des majuscules.");
                pw.println("La seule partie obligatoire est celle des 3D6. Vous pouvez omettres des partie mais pas les mettres dans le mauvais ordre.");
                pw.println("3D6B1R2 ne fonctionne pas alors que 3D6R1B2 oui. ");
                return sw.toString();
        }

        public static void main(String[] a) {

                System.out.println(DiceRoller.rollDice("1D20-21"));
//                System.out.println(DiceRoller.rollDice("1D20+1"));
//                System.out.println(DiceRoller.rollDice("1D20-10"));
//                System.out.println(DiceRoller.rollDice("1D20+10"));
//                System.out.println(DiceRoller.rollDice("1D20+15"));


        }
}
