package Kata15;

import java.util.List;

/**
 * The observed PIN
 * <p>
 * Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
 * <p>
 * The keypad has the following layout:
 * <p>
 * │ 1 │ 2 │ 3 │<p>
 * │ 4 │ 5 │ 6 │<p>
 * │ 7 │ 8 │ 9 │<p>
 * │ X │ 0 │<p>
 * He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
 * <p>
 * He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
 * <p>
 * * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
 * <p>
 * Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list in Java/Kotlin and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.
 * <p>
 * Detective, we are counting on you!
 */

public class Main {

    public static void main(String[] args) {

        getPINs("1357");
    }

    public static List<String> getPINs(String observed) {
        int numbers = observed.length();
        String[] diffNumber = new String[numbers];

        //TODO: Crear matriz con cada numero del String observed y sus vecinos (vertical y horizontal).
        //TODO: Crear for dentro de for u con un contador externo para conseguir cada variación.

        return null;
    } // getPINs

    private static String getAdjacents(int base) {
        
    }
}
