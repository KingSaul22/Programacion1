package Kata3;

public class Main {
    /**
     * Given an array of integers, find the one that appears an odd number of times.
     * <p>
     * There will always be only one integer that appears an odd number of times.
     */
    public static void main(String[] args) {
        System.out.println(findIt(new int[]{1, 1, 2, 1, 1}));
    }

    public static int findIt(int[] a) {
        // Variable where I store the count of repeated occurrences of a letter.
        int repeat = 0;

        for (int i : a) {
            // For each number, we compare it with the array.
            for (int j : a) {
                // Add one when we find the number.
                if (i == j) {
                    repeat++;
                }
            }
            // In the case that the number appears an odd number of times, we return it.
            if (repeat % 2 != 0) {
                return i;
            }
        }

        return 0;
    }

    /*public static int findIt(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }*/
}
