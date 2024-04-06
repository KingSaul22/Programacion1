package Kata18;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.
 * <p>
 * Example: (Input --> Output)
 * <p>
 * "Dermatoglyphics" --> true "aba" --> false "moOse" --> false (ignore letter case)
 * <p>
 * isIsogram "Dermatoglyphics" = true
 * <p>
 * isIsogram "moose" = false
 * <p>
 * isIsogram "aba" = false
 */
public class Main {
    public static void main(String[] args) {
        String cadena = "Ojalata";
        System.out.println(cadena.substring(1, cadena.length() - 1));

        System.out.println(isIsogram("Pe"));
        System.out.println(isIsogramB("Pe"));
    }

    public static boolean isIsogram(String str) {
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.indexOf(str.charAt(i), i + 1) != -1) return false;
        }
        return true;
    }

    public static boolean isIsogramB(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
