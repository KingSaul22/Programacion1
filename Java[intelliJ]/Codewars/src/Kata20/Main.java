package Kata20;

import java.util.Arrays;

/**
 * Longest Mountain Pass
 * <p>
 * You are an adventurous hiker planning to traverse a mountain range. The mountain range is represented by an array of integers, where each element corresponds to the height of a mountain at that position. Your goal is to find the longest mountain pass you can take based on your initial energy level.
 * <p>
 * Problem Description
 * <p>
 * You are given an array of mountains, where each element represents the height of the mountain.
 * <p>
 * A mountain pass is defined as a subarray of the mountain array. The length of a mountain pass is the length of the subarray.
 * <p>
 * You have an initial energy level E.
 * <p>
 * You start at any initial index of your choice.
 * <p>
 * Going up a mountain (i.e., moving from a lower height to a higher height) costs you energy equal to the difference in heights.
 * <p>
 * Going down a mountain or staying at the same height does not cost you any energy.
 * <p>
 * You can only move to the mountains on your right (i.e., the next index).
 * <p>
 * Your task is to find the longest mountain pass you can take based on your initial energy level. Return the length of the longest mountain pass and the initial index from where you should start.
 * <p>
 * Input
 * <p>
 * mountains: An array of integers representing the heights of the mountains.
 * <p>
 * E: An integer representing your initial energy level.
 * <p>
 * Note: The length of the mountain array can be very large, up to 10^7.
 * <p>
 * Output
 * <p>
 * Return a tuple (max_length, start_index), where:
 * <p>
 * max_length: The length of the longest mountain pass you can take.
 * <p>
 * start_index: The initial index from where you should start the mountain pass.
 * <p>
 * If there are multiple mountain passes with the same length, return the one with the smallest initial index.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestMountainPass(new int[]{}, 0));
        System.out.println("Expected: 0, 0\n");

        System.out.println(longestMountainPass(new int[]{10, 10, 10}, 0));
        System.out.println("Expected: 3, 0\n");

        System.out.println(longestMountainPass(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println("Expected: 1, 0\n");

        System.out.println(longestMountainPass(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 3}, 1));
        System.out.println("Expected: 10, 0\n");

        System.out.println(longestMountainPass(new int[]{9, 1, 2, 3, 4, 5, 6, 9}, 7));
        System.out.println("Expected: 7, 0\n");

        System.out.println(longestMountainPass(new int[]{1, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7));
        System.out.println("Expected: 9, 1\n");
    }

    public static Result longestMountainPass(int[] mountains, int E) {
        /*int maxLength = mountains.length, startIdx = 0, numMountains = 0;
        int finalE = E;
        int[] impossible = Arrays.stream(mountains).filter(a -> a > finalE).sorted().toArray();
        if (impossible.length == mountains.length) return new Result(maxLength, startIdx);

        for (int i = 0; i < mountains.length; i++) {
            if (mountains[i] < E) {
                E -= mountains[i];
                startIdx = i;
                maxLength = mountains[i];
                numMountains++;

                for (int j = i + 1; j < mountains.length; j++) {
                    if (mountains[j] > E) break;
                    E -= mountains[j];
                    maxLength = Math.max(maxLength, mountains[j]);
                    numMountains++;
                }

                break;
            }
        }*/

        int maxLength = numMountains(mountains, 0, E)[1], startIdx = 0;
        int numMountains = numMountains(mountains, startIdx, E)[0];

        for (int i = 1; i < mountains.length && numMountains <= mountains.length - startIdx; i++) {
            int[] stats = numMountains(mountains, i, E);
            if (numMountains < stats[0]) {
                numMountains = stats[0];
                startIdx = i;
                maxLength = stats[1];
            }
        }


        return new Result(maxLength, startIdx);
    }

    /**
     * @param mountains Montañas a pasar
     * @param startIdx  Se inicia desde esta montaña hacia la derecha
     * @param E         Energia
     * @return Montañas que salta && altura máxima de la montaña
     */
    private static int[] numMountains(int[] mountains, int startIdx, int E) {
        int count = 0, max = mountains[startIdx];
        for (int i = startIdx + 1; i < mountains.length; i++) {
            if (mountains[i] > E + mountains[i - 1]) break;

            count++;
            //E -= mountains[i];
            E -= Math.max(mountains[i] - mountains[i - 1], 0);

            if (mountains[i] > max) max = mountains[i];
        }
        return new int[]{count, max};
    }

    /**
     * maxLength
     * startIdx
     */
    public static class Result {
        private int maxLength;
        private int startIdx;

        public Result(int maxLength, int startIdx) {
            this.maxLength = maxLength;
            this.startIdx = startIdx;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("maxLength: ").append(maxLength)
                    .append("\nstartIdx: ").append(startIdx);
            return sb.toString();
        }
    }
}
