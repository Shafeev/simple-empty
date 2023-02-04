package org.mcs.tasks.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Учитывая массив nums из n целых чисел, вернуть массив всех уникальных четверок [nums[a], nums[b], nums[c], nums[d]],
 * таких что:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c и d различны.
 * nums[a] + nums[b] + nums[c] + nums[d] == цель
 * Вы можете вернуть ответ в любом порядке.
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        int[] nums2 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int target2 = 8;
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target3 = -294967296;


        System.out.println(fourSum(nums, target));
        System.out.println(fourSum(nums2, target2));
        System.out.println(fourSum(nums3, target3));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isDifferent = true;
        int buffer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (buffer != nums[i]) {
                isDifferent = false;

            }
        }
        for (int index = 0; index < nums.length; index++) {
            for (int twoIndex = index + 1; twoIndex < nums.length; twoIndex++) {
                for (int treeIndex = twoIndex + 1; treeIndex < nums.length; treeIndex++) {
                    for (int fourIndex = treeIndex; fourIndex < nums.length; fourIndex++) {
                        long value1 = nums[index];
                        long value2 = nums[twoIndex];
                        long value3 = nums[treeIndex];
                        long value4 = nums[fourIndex];
                        if (value1 + value2 + value3 + value4 == target) {

                            List<Integer> fourListValue = new ArrayList<>();
                            fourListValue.add(nums[index]);
                            fourListValue.add(nums[twoIndex]);
                            fourListValue.add(nums[treeIndex]);
                            fourListValue.add(nums[fourIndex]);
                            Collections.sort(fourListValue);
                            if (!result.contains(fourListValue)) {
                                result.add(fourListValue);
                            }
                            if (isDifferent) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
