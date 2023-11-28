package Kata4;

public class Main {
    /**
     * You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
     * <p>
     * Examples
     * <p>
     * [2, 4, 0, 100, 4, 11, 2602, 36] -->  11 (the only odd number)
     * <p>
     * [160, 3, 1719, 19, 11, 13, -21] --> 160 (the only even number)
     */
    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 1, 1, 1, 2, 1, 1,}));

    }

    static int find(int[] integers) {
        int odd = 0;

        // Knowing that only one type (even or odd) can be repeated,
        // we examine the first three numbers of the array.
        for (int i = 0; i < 3; i++) {
            // Add one to the counter if we found an odd number.
            if (integers[i] % 2 != 0) {
                odd++;
            }
        }

        // If before we find more than 1 odd numbers
        if (odd > 1) {
            for (int i = 0; i < integers.length; i++) {
                // Return the first even number found.
                if (integers[i] % 2 == 0) return integers[i];
            }
        } else {
            for (int i = 0; i < integers.length; i++) {
                // Return the first odd number found.
                if (integers[i] % 2 != 0) return integers[i];
            }
        }
        return 0;
    }
}
