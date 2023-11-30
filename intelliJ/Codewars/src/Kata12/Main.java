package Kata12;

import java.util.ArrayList;
import java.util.List;

/**
 * Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
 * <p>
 * The number  89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata.
 * What's the use of saying "Eureka"?
 * <p>
 * Because this sum gives the same number: 89 = 8^1 + 9^2
 * <p>
 * <p>
 * The next number in having this property is :135
 * <p>
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 * <p>
 * <p>
 * Task
 * We need a function to collect these numbers, that may receive two integers a, b that defines the range [a,b]
 * (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
 * <p><p>
 * Examples
 * <p>
 * Let's see some cases (input -> output):
 * <p>
 * 1, 10  --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * <p>
 * 1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * <p>
 * If there are no numbers of this kind in the range
 * <p>
 * [a,b] the function should output an empty list.
 * <p>
 * 90, 100 --> []
 */
public class Main {
    public static void main(String[] args) {

        long a = 8L;
        long b = 15L;

        System.out.println(sumDigPow(a, b));
    }

    public static List<Long> sumDigPow2(long a, long b) {
        List<Long> eureka = null;
        long elem = 0, auxElem = 0;

        for (long posElem = a; a <= b; a++) {

            for (long i = (long) Math.log10(a); i > 0; i--) {

                for (long j = 0; j < i; j++) {
                    elem /= 10;
                }
                elem -= auxElem;
                auxElem = 10 * auxElem + elem;
            }
            if (auxElem == posElem) eureka.add(auxElem);
        }

        // your code
        return eureka;
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> eureka = new ArrayList<>();
        long elem, auxElem, box, ans = 0;

        for (long posElem = a; posElem <= b; posElem++) {

            auxElem = 0;
            for (long i = (long) Math.log10(a); i >= 0; i--) {
                elem = posElem;
                for (long j = (long) Math.log10(a); j > i; j--) {
                    elem /= 10;
                }
                elem -= auxElem;
                auxElem = 10 * (auxElem + elem);

                box = elem;
                for (int j = (int) Math.log10(a); j > i; j--){

                    box *= elem;
                }
                ans += box;
                box = 0;
            }

            if (ans == posElem) eureka.add(posElem);
            ans = 0;
        }

        // your code
        return eureka;
    }
}
