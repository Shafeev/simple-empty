package org.mcs.tasks.hashTable;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Если дан непустой массив целых чисел nums, то каждый элемент появляется дважды, кроме одного. Найдите ту единственную.
 * <p>
 * Вы должны реализовать решение с линейной сложностью во время выполнения и использовать только постоянное
 * дополнительное пространство. O(1)
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * <p>
 * Input: nums = [1]
 * Output: 1
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 4};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    private static int singleNumber(int[] nums) {
        int result = nums[0];
        HashSet<Integer> values = new HashSet<>();
        for (int num : nums) {
            boolean isAdded = values.add(num);
            if (isAdded) {
                result = num;
            } else {
                values.remove(num);
            }
        }
        for (Integer value : values) {
            result = value;
        }
        return result;
    }

    private static int singleNumber2(int[] nums) {
        int result = 0;

        for (int index = 0; index < nums.length; index++) {
            System.out.print("result = " + result + " number[" + index + "] = " + nums[index] + " result ^ nums = " );
            result = result ^ nums[index];
            System.out.println(result);

        }

        return result;
    }
}
