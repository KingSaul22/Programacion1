package Codewars;

import java.util.Arrays;

public class Kata1 {
    public static void main(String[] args) {

    }

    public static int[] beggars(int[] values, int n) {
        if (n == 0) return new int[]{};

        int[] result = new int[n];
        Arrays.fill(result, 0);

        int begger = 0;
        for (int i = 0; i < values.length; i++){
            result[begger] += values[i];
            if (begger == result.length - 1) {
                begger = 0;
            } else {
                begger++;
            }
        }

        return result;
    }
}
