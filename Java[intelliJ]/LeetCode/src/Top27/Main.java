package Top27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Remove Element
 * <p>
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * <p>
 * int val = ...; // Value to remove
 * <p>
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * // It is sorted with no values equaling val.
 * <p>
 * int k = removeElement(nums, val); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * <p>
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
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
 * Input: nums = [3,2,2,3], val = 3
 * <p>
 * Output: 2, nums = [2,2,_,_]
 * <p>
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * <p>
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * <p>
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * <p>
 * 0 <= nums[i] <= 50
 * <p>
 * 0 <= val <= 100
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
        System.out.println("[]"); // k = num elementos que se muestran
    }

    public static int removeElement(int[] nums, int val) {
        int k = nums.length, i1 = 0, i2 = nums.length - 1;

        if (i1 == i2 && nums[i1] == val) {
            return 0;
        }

        while (i1 < i2) {
            while (i2 >= i1 && nums[i2] == val) {
                k--;
                i2--;
            }

            while (nums[i1] != val && i1 < i2) {
                i1++;
            }

            if (i1 < i2 && nums[i1] == val && nums[i2] != val) {
                nums[i1] = nums[i2--];
                k--;
            }
        }

        return k;
    }
}
