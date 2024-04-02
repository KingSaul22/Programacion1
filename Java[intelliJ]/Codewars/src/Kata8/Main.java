package Kata8;

import java.util.Locale;

/**
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
 * <p>
 * Examples input/output:
 * <p>
 * XO("ooxx") => true
 * <p>
 * XO("xooxx") => false
 * <p>
 * XO("ooxXm") => true
 * <p>
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * <p>
 * XO("zzoo") => false
 */
public class Main {
    public static void main(String[] args) {
        String palabra = "xxoo";

        if (getXO(palabra)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean getXO(String str) {
        // Ignore capitalization.
        str = str.toLowerCase();
        // Variable where I store the count of repeated occurrences of the letter 'x'.
        int countX = 0;
        // Variable where I store the count of repeated occurrences of the letter 'o'.
        int countO = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'x') {
                // Add one if we found 'x'
                countX++;

            } else if (str.charAt(i) == 'o') {
                // Add one if we found 'o'
                countO++;
            }
        }

        // Return true if they appear the same number of times.
        return countX == countO;
    }
}
