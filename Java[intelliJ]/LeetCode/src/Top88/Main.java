package Top88;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * <p>
 * Output: [1]
 * <p>
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * <p>
 * Output: [1]
 * <p>
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * <p>
 * nums2.length == n
 * <p>
 * 0 <= m, n <= 200
 * <p>
 * 1 <= m + n <= 200
 * <p>
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class Main {
    public static void main(String[] args) {
        merge(new int[]{1, 0}, 1, new int[]{2}, 1);
        mergeB(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        mergeC(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void mergeC(int[] nums1, int m, int[] nums2, int n) {
        //two pointers
        //right to left
        int p1 = m - 1, p2 = n - 1;
        int idx = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[idx--] = nums1[p1--];
            } else {
                nums1[idx--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[idx--] = nums2[p2--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeB(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }

        int[] nums3 = new int[m + n];
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < m && i2 < n) {
            if (nums1[i1] < nums2[i2]) {
                nums3[i3++] = nums1[i1++];
            } else if (nums2[i2] < nums1[i1]) {
                nums3[i3++] = nums2[i2++];
            } else {
                nums3[i3++] = nums1[i1++];
                nums3[i3++] = nums2[i2++];
            }
        }

        if (i2 < n - 1) {
            while (i3 < m + n) {
                nums3[i3++] = nums2[i2++];
            }
        } else if (i1 < m - 1) {
            while (i3 < m + n) {
                nums3[i3++] = nums1[i1++];
            }
        }

        //nums1 = nums3;
        System.arraycopy(nums3, 0, nums1, 0, nums3.length);

        System.out.println(Arrays.toString(nums1));
    }


}
