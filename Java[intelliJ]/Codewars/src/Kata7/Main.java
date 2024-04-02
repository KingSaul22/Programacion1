package Kata7;

import java.util.Arrays;

/**
 * Well met with Fibonacci bigger brother, AKA Tribonacci.
 * <p>
 * As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(
 * <p>
 * So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this sequence:
 * <p>
 * [1, 1 ,1, 3, 5, 9, 17, 31, ...]
 * <p>
 * But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of [1, 1] basically shifts the common Fibonacci sequence by once place, you may be tempted to think that we would get the same sequence shifted by 2 places, but that is not the case and we would get:
 * <p>
 * [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
 * <p>
 * Well, you may have guessed it by now, but to be clear: you need to create a fibonacci function that given a signature array/list, returns the first n elements - signature included of the so seeded sequence.
 * <p>
 * Signature will always contain 3 numbers; n will always be a non-negative number; if n == 0, then return an empty array (except in C return NULL) and be ready for anything else which is not clearly specified ;)
 */
public class Main {
    public static void main(String[] args) {
        double[] signature = {0, 0, 1};
        int iterations = 10;

        System.out.println(Arrays.toString(tribonacci(signature, iterations)));

    }

    private static double[] tribonacci(double[] s, int n) {
        double[] tribonacci = new double[n];

        for (int i = 0; i < n; i++) {

            if (i < s.length) {
                // First We add the signature to the array.
                tribonacci[i] = s[i];

            } else {
                // And we use the following expression to calculate the other positions.
                tribonacci[i] = tribonacci[i - 3] + tribonacci[i - 2] + tribonacci[i - 1];
            }

        }

        return tribonacci;
    }
}
