package Kata6;

import java.util.HashMap;
import java.util.Map;

/**
 * The main idea is to count all the occurring characters in a string. If you have a string like aba, then the result should be {'a': 2, 'b': 1}.
 * <p>
 * What if the string is empty? Then the result should be empty object literal, {}.
 */
public class Main {
    public static void main(String[] args) {
        String phrase = "Hola Hola";
        System.out.println(phrase);
        System.out.println(count1(phrase));
        System.out.println(count2(phrase));
    }

    public static Map<Character, Integer> count1(String str) {

        Map<Character, Integer> numberOfLetters = new HashMap<>();
        // I will use this boolean to determine if I already examined a letter or not.
        boolean[] ready = new boolean[str.length()];
        // Variable where I store the count of occurrences of a letter.
        int repeat;

        for (int i = 0; i < str.length(); i++) {
            // Reset the counter to 0.
            repeat = 0;

            // If a letter hasn't been examined.
            if (!ready[i]) {

                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        // Add one to the counter if we found a letter.
                        repeat++;
                        //
                        ready[j] = true;
                    }
                }
                // We add the letter and how many times it is found.
                numberOfLetters.put(str.charAt(i), repeat);
            }

        }

        return numberOfLetters;
    }

    public static Map<Character, Integer> count2(String str) {

        Map<Character, Integer> numberOfLetters = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (numberOfLetters.get(str.charAt(i)) == null) {
                numberOfLetters.put(str.charAt(i), 1);
            } else {
                // We add the letter and how many times it is found.
                numberOfLetters.put(str.charAt(i), (numberOfLetters.get(str.charAt(i)) + 1));
            }

        }
        //numberOfLetters.put(str.charAt(0), (numberOfLetters.get(str.charAt(0)) + 4));

        return numberOfLetters;
    }
}
