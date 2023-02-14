package org.mcs.tasks.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6, 7, 9};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRanges2(nums));
    }

    private static List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }
        int start;
        int end;
        int index = 1;
        int count = 0;

        while (index < nums.length) {
            System.out.println(count);
            if ((nums[index - 1] + 1) == nums[index]) {
                count++;
            } else {
                if (count == 0) {
                    int endIndex = index - 1;
                    result.add("" + nums[endIndex]);
                } else if (count > 0) {
                    start = nums[index - count - 1];
                    end = nums[index - 1];
                    result.add(start + "->" + end);
                    count = 0;
                }

            }

            index++;
        }
        System.out.println("count " + count);
        if (count == 0) {
            int endIndex = nums.length - 1;
            result.add("" + nums[endIndex]);
        } else if (count > 0) {
            start = nums[index - count - 1];
            end = nums[index - 1];
            result.add(start + "->" + end);
        }


        return result;
    }

    private static List<String> summaryRanges2(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        for (int index = 0; index < nums.length; ++index) {
            StringBuilder sb = new StringBuilder(String.valueOf(nums[index]));
            while (index < nums.length - 1 && nums[index] + 1 == nums[index + 1]) {
                index++;
            }
            if (nums[index] != Integer.parseInt(sb.toString())) {
                sb.append("->");
                sb.append(nums[index]);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
