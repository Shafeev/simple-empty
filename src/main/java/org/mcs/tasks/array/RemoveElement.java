package org.mcs.tasks.array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
//        Input: nums = [0,1,2,2,3,0,4,2], val = 2
//        Output: 5, nums = [0,1,4,0,3,_,_,_]
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int[] nums2 = new int[]{3,2,2,3};
        int val2 = 3;
        int result = removeElement(nums, val);
        System.out.println(result);
        int result2 = removeElement(nums2, val2);
        System.out.println(result2);
    }

    static int removeElement(int[] nums, int val) {
        int count = 0;
        int head = nums.length;
        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            if (val == value) {
                while (head > index) {
                    if (nums[head - 1] != val) {
                        nums[index] = nums[head - 1];
                        nums[head - 1] = val;
                        break;
                    } else {
                        head--;
                    }
                }
                if (head > index) {
                    count++;
                }
            } else {
                count++;
            }
        }

        int[] array = new int[count];
        for (int i = 0; i <count; i++) {
            array[i] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(array));
        return count;
    }

}
