package Kata2;

public class Main {
    /**
     * A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).
     * <p>
     * For example, take 153 (3 digits), which is narcissistic:
     * 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
     * <p>
     * and 1652 (4 digits), which isn't:
     * 1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
     * <p>
     * The Challenge:
     * <p>
     * Your code must return true or false (not 'true' and 'false') depending upon whether the given number is a Narcissistic number in base 10.
     * <p>
     * This may be True and False in your language, e.g. PHP.
     * <p>
     * Error checking for text strings or other invalid inputs is not required, only valid positive non-zero integers will be passed into the function.
     */
    public static void main(String[] args) {
        String palabra;


        palabra = encode("Prespecialize)");
        System.out.print(palabra);

        System.out.println();
        palabra = encode("Prespecialized");
        System.out.print(palabra);

    }


    static String encode(String word) {
        // Ignore capitalization.
        word = word.toLowerCase();
        char[] letter = word.toCharArray();
        // I will use this boolean to determine if I already examined a letter or not.
        boolean[] ready = new boolean[letter.length];
        // Variable where I store the count of repeated occurrences of a letter.
        int repeat = 0;

        for (int i = 0; i < letter.length; i++) {

            // If a letter hasn't been examined.
            if (!ready[i]) {
                // We need to know if a letter appears more than one time.
                for (int j = 0; j < letter.length && repeat < 2; j++) {

                    if (word.charAt(i) == word.charAt(j)) {
                        repeat++;
                    }
                }

                // If the letter only apears once then we use '('.
                if (repeat == 1) {
                    letter[i] = '(';
                    ready[i] = true;
                } else {
                    // When the letter appears more than once, que replace all of them with ')'.
                    for (int j = 0; j < letter.length; j++) {

                        if (word.charAt(i) == word.charAt(j)) {
                            letter[j] = ')';
                            ready[j] = true;
                        }

                    }
                }
                // Reset the counter of occurrences.
                repeat = 0;
            }
        }

        word = String.valueOf(letter);
        return word;
    }
}