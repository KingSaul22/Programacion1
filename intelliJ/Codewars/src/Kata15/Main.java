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
 * │ X │ 0 │ X │<p>
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
        String[] adjacentsNumber = getAdjacents(observed);

        //TODO: Crear for dentro de for u con un contador externo para conseguir cada variación.

        return null;
    } // getPINs

    private static String[] getAdjacents(String base) {
        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'x', '0', 'x'}
        };

        String[] adjacent = new String[base.length()];
        int letter = 0;
        int ejeX, ejeY;


        //for (int i = 0; i < base.length(); i++) {

        for (int fila = 0; fila < keypad.length && letter < base.length(); fila++) {
            for (int colum = 0; colum < keypad[0].length; colum++) {

                if (base.charAt(letter) == keypad[fila][colum]) {
                    adjacent[letter] = String.valueOf(keypad[fila][colum]);

                    if (fila > 0)
                        adjacent[letter] += String.valueOf(keypad[fila - 1][colum]);

                    if (fila < 3 && !(fila == 2 && (colum == 0 || colum == 2)))
                        adjacent[letter] += String.valueOf(keypad[fila + 1][colum]);

                    if (colum > 0 && fila != 3)
                        adjacent[letter] += String.valueOf(keypad[fila][colum - 1]);

                    if (colum < 2 && fila != 3)
                        adjacent[letter] += String.valueOf(keypad[fila][colum + 1]);


                    letter++;
                    // break? continue? fila/colum = 0 o = -1...
                    fila = -1;
                    break;
                }
            }
        }


        //}

        return adjacent;
    }


}
