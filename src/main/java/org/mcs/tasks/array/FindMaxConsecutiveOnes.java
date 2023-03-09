package org.mcs.tasks.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


    static int findMaxConsecutiveOnes(int[] nums) {
        int[] buffer = new int[nums.length];
        int index = 0;
        for (int value : nums) {
            if (value == 1) {
                buffer[index]++;
            } else {
                index++;
            }
        }

        int maxValue = buffer[0];
        for (Integer max : buffer) {
            if (max > maxValue) {
                maxValue = max;
            }
        }

        return maxValue;
    }
}
