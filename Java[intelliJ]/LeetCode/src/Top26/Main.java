package Top26;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * <p>
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * <p>
 * for (int i = 0; i < k; i++) {
 * <p>
 * assert nums[i] == expectedNums[i];
 * <p>
 * }
 * <p>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * <p>
 * Output: 2, nums = [1,2,_]
 * <p>
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * <p>
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * <p>
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * <p>
 * -100 <= nums[i] <= 100
 * <p>
 * nums is sorted in non-decreasing order.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println("[1, 2]");
    }

    public static int removeDuplicates(int[] nums) {
        int k = nums.length == 0 ? 0 : 1, i1 = 0, i2 = 1;

        while (i1 < nums.length - 1 && i2 < nums.length) {
            if (nums[i1] == nums[i2]) {
                i2++;
            } else {
                k++;
                nums[k] = nums[i2];
                i1 = i2++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return k;
    }
}
