package org.mcs.tasks.memory;


import java.util.Arrays;

/**
 * Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел так,
 * чтобы их сумма равнялась target.
 * <p>
 * Вы можете предположить, что каждый вход будет иметь ровно одно решение,
 * и вы не можете использовать один и тот же элемент дважды.
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] nums2 = {3, 3};
        int target2 = 6;
        int[] nums3 = {0, 3, 4, 0};
        int target3 = 0;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums1, target1)));
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
        System.out.println(Arrays.toString(twoSum(nums3, target3)));

        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums1, target1)));
        System.out.println(Arrays.toString(twoSum2(nums2, target2)));
        System.out.println(Arrays.toString(twoSum2(nums3, target3)));

        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums1, target1)));
        System.out.println(Arrays.toString(twoSum2(nums2, target2)));
        System.out.println(Arrays.toString(twoSum2(nums3, target3)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        int bufferIndex = -1;
        int startIndex = 0;
        while (startIndex < nums.length) {
            for (int index = startIndex; index < nums.length; index++) {
                if (bufferIndex > -1) {
                    if ((target - nums[bufferIndex]) == nums[index] && bufferIndex != index) {
                        result[0] = bufferIndex;
                        result[1] = index;
                        break;
                    }
                } else {
                    bufferIndex = index;
                }
            }
            startIndex++;
            bufferIndex = startIndex;
        }

        return result;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int startIndex = 1;
        while (true) {
            for (int index = 0; index + startIndex < nums.length; index++) {
                if (nums[index] + nums[index+startIndex] == target) {
                    return new int[]{index, index+startIndex};
                }
            }
            startIndex++;
            if (startIndex == nums.length) break;
        }
        return null;
    }

    private static int[] twoSum3(int[] nums, int target) {

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
